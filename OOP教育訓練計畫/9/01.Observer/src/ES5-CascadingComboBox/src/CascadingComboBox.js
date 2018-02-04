/**
 * @typedef {Object} optionType
 * @property {string} key
 * @property {string} value
 */

/**
 * @callback onCreateChildDataCallback
 * @param {Object} data
 * @param {CascadingComboBox} target
 * @returns {Object}
 */

/**
 * @callback onCreateOptionCallback
 * @param {Number} index
 * @param {Object} data
 * @returns {optionType}
 */

/**
 * @callback onSelectedCallback
 * @param {Number} selectedIndex
 * @param {CascadingComboBox} target
 */

/**
 * @typedef {Object} Attachment
 * @property {CascadingComboBox} child
 * @property {onCreateChildDataCallback} onCreateChildData
 */

/**
 * @param {Object} options
 * @property {string} id
 * @property {onCreateOptionCallback} onCreateOption
 * @property {onSelectedCallback} onSelected
 * @returns {{attachChild: _attachChild, setData: _setData}}
 * @constructor
 */
function CascadingComboBox(options) {
    /**
     * 這個 ComboBox 的DOM 物件
     * @type {object}
     */
    var _domObject;

    var _this;

    /**
     * 建立選項的 callback
     * @type {onCreateOptionCallback}
     */
    var _onCreateOptionCallback;
    /**
     * 項目被選擇的 callback
     * @type {onSelectedCallback}
     */
    var _onSelectedCallback;

    /**
     * 子選單綁定資料
     * @type {Attachment[]}
     */
    var _children = [];

    /**
     * 選單資料
     * @type {object[]}
     */
    var _data;

    /**
     * 預設選項資料
     * @type {string[]}
     */
    var _defaultOptions;

    /**
     * 加入子選單
     * @param {Attachment} attachment
     */
    function _attachChild(attachment) {
        _children.push(attachment);
    }

    /**
     * 設定資料。
     * @param data 陣列型態的資料
     * @param defaultOptions 指定已選擇的 key 陣列。
     *        如果串接三層， defaultOptions 就要將三層的 key 組成陣列傳入。
     *        ex: ['GP1601-005', 'GP1611-003', 'GP1611-137']
     * @param {CascadingComboBox} target
     */
    function _setData(data, defaultOptions, target) {
        AssertArrayType(data);
        if (isNotNullObject(defaultOptions)) { AssertArrayType(defaultOptions); }
        _data = data;
        _defaultOptions = defaultOptions;
        _clearOptions();
        createOptions();
        if (_domObject.selectedIndex > 0) { updateChildren(); }
    }

    /**
     * 清除子選單
     */
    function clearChildren() {
        _.each(_children,
            /**
             * 呼叫子選單的清除功能
             * @param {Attachment} attachment
             */
            function (attachment) {
                attachment.child.clearOptions();
            })
    }

    /**
     * 清除選項
     */
    function _clearOptions() {
        _domObject.length = 1;
        clearChildren();
    }

    /**
     * 建立選項
     */
    function createOptions() {
        if (!_onCreateOptionCallback) { return; }
        for (var i = 0; i < _data.length; i++) {
            var option = _onCreateOptionCallback(i, _data[i]);
            var newOption = new Option(option.value, option.key);
            _domObject.options[_domObject.options.length] = newOption;
            if (isNotEmpty(_defaultOptions)) {
                if (newOption.value === _defaultOptions[0]) {
                    newOption.selected = true;
                }
            }
        }
    }

    /**
     * 更新子選單
     */
    function updateChildren() {
        _.each(_children,
            /**
             * 呼叫子選單的清除功能
             * @param {Attachment} attachment
             */
            function (attachment) {
                if (!attachment.onCreateChildData) { return; }
                var selectedData = _data[_domObject.selectedIndex - 1];
                var dataForChild = attachment.onCreateChildData(selectedData, attachment.child);
                var selectedKeysForChild = [];
                if (!isEmpty(_defaultOptions)) {
                    selectedKeysForChild = _defaultOptions.slice(1);
                }
                attachment.child.setData(dataForChild, selectedKeysForChild, attachment.child);
            })
    }

    function initComponents() {
        _domObject = document.getElementById(options.id);
        if (isNullObject(_domObject)) {
            throw 'DOM 元素 ID "' + options.id + '" 不存在!';
        }

        _onCreateOptionCallback = options.onCreateOption;
        _onSelectedCallback = options.onSelected;
        _this = this;
    }

    function bindEvents() {
        // 當使用者選擇某個項目時會呼叫此函式
        _domObject.onchange = function () {
            if (!isNullObject(_onSelectedCallback)) {
                _onSelectedCallback(_domObject.selectedIndex, _this);
            }

            if (isEmpty(_children)) { return; }

            // 如果是選到第一個選項(預設值)
            if (_domObject.selectedIndex === 0) {
                clearChildren();
                return;
            }

            updateChildren();
        }
    }

    initComponents();
    bindEvents();

    return {
        attachChild: _attachChild,
        clearOptions: _clearOptions,
        setData: _setData
    }
}