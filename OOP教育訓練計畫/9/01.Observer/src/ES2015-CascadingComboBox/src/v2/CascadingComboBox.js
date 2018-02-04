import * as SystemUtils from './SystemUtils';
import Assert from 'assert-js';

/**
 * 連動下拉選單
 */
export class CascadingComboBox {
    /**
     * Constructor
     * @param {string} id
     */
    constructor(id) {
        this.id = id;
        this.domObject = document.getElementById(id);
        Assert.true(SystemUtils.isNotNull(this.domObject), `HTML 元素 ${id} 不存在!`);
        this.children = [];
        this.data = [];
        this.defaultOptions = [];
        this.onCreateOption = null;
        this.onCreateChildData = null;
        this.onItemSelected = null;

        this.bindEvents();
    }

    /**
     * 繫結事件
     */
    bindEvents() {
        // 當使用者選擇某個項目時會呼叫此函式
        this.domObject.onchange = () => {
            if (SystemUtils.isNull(this.onItemSelected)) { return; }

            // 將選取的項目編號傳給使用者指定的 callback
            this.onItemSelected(this, this.domObject.selectedIndex);

            // 如果沒設定下層選單，不用處理
            if (SystemUtils.isEmpty(this.children)) { return; }

            // 如果是選到第一個選項(預設值)
            if (this.domObject.selectedIndex === 0) {
                this.clearChildren();
                return;
            }

            this.updateChildren();
        }
    }

    /**
     * 加入子選單
     * @param {CascadingComboBox} child
     */
    attachChild(child) {
        this.children.push(child);
    }

    /**
     * 設定資料。
     * @param {Object[]} data - 陣列型態的資料
     * @param {string[]} defaultOptions - 預設選項
     *        如果串接三層， defaultOptions 就要將三層的 key 組成陣列傳入。
     *        ex: ['GP1601-005', 'GP1611-003', 'GP1611-137']
     */
    setData(data, defaultOptions) {
        this.data = data || [];
        this.defaultOptions = defaultOptions || [];
        this.fillOptions();
    }

    /**
     * 填滿選項
     */
    fillOptions() {
        // 清除目前的選項
        this.clear();

        // 根據傳入的資料建立選項
        this.data.forEach(this.createOptions.bind(this));

        // 如果有子選單而且有預設值
        if (SystemUtils.isNotEmpty(this.children) && this.domObject.selectedIndex > 0) {
            this.updateChildren();
        }
    }

    /**
     * 建立選項
     * @param {object} element
     * @param {int} index - element 的編號
     */
    createOptions(element, index) {
        if (SystemUtils.isNull(this.onCreateOption)) {
            return;
        }

        // 呼叫使用者指定的 callback 將陣列元素轉換成 option
        let option = this.onCreateOption(this, index, element);

        // 新增一個選項
        let newOption = new Option(option.value, option.key);
        this.domObject.options[this.domObject.options.length] = newOption;

        // 有預設選項嗎?
        if (SystemUtils.isEmpty(this.defaultOptions)) {
            return;
        }

        // 此選項是否為預設被選取?
        newOption.defaultOptions = newOption.value === this.defaultOptions[0];
    }

    /**
     * 清除選項內容，子選單也會一併清除
     */
    clear() {
        this.domObject.length = 1;
        this.clearChildren();
    }

    /**
     * 清除子選單
     */
    clearChildren() {
        this.children.forEach((child) => {
            child.clear();
        });
    }

    /**
     * 更新下層選單
     */
    updateChildren() {
        if (SystemUtils.isNull(this.onCreateChildData)) { return; }

        // 取得選到的資料
        let selectedData = this.data[this.domObject.selectedIndex - 1];

        // 呼叫 callback 將選到的資料傳換成給下層選單的資料
        let dataForChild = this.onCreateChildData(this, selectedData);
        let selectedKeysForChild = [];
        if (SystemUtils.isNotEmpty(this.defaultOptions)) {
            selectedKeysForChild = this.defaultOptions.slice(1);
        }

        // 將資料設定到下層選單
        this.children.forEach((child) => {
                child.setData(dataForChild, selectedKeysForChild);
            }
        )
    }
}