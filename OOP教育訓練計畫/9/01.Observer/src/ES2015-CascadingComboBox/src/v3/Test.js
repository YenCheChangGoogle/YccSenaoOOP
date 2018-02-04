import {CascadingComboBox} from "../v3/CascadingComboBox";

let mainCombobox = new CascadingComboBox({
    id: 'categoryMain',
    onCreateOption: onCreateOptionCallback,
    onSelected: onItemSelectedCallback
});

mainCombobox.setData(MPro.promotion);

let combobox1 = new CascadingComboBox({
    id: 'category1',
    onCreateOption: onCreateOptionCallback,
    onSelected: onItemSelectedCallback
});

mainCombobox.attachChild({
    child: combobox1,
    onCreateChildData:
        /**
         * @callback onCreateChildDataCallback
         * @param {Object} data
         * @param {CascadingComboBox} target
         * @returns {Object}
         */
        function (data, target) {
            return data.children1[0].children1;
        }
});

let combobox2 = new CascadingComboBox({
    id: 'category2',
    onCreateOption: onCreateOptionCallback,
    onSelected: onItemSelectedCallback
});

mainCombobox.attachChild({
    child: combobox2,
    onCreateChildData:
        /**
         * @callback onCreateChildDataCallback
         * @param {Object} data
         * @param {CascadingComboBox} target
         * @returns {Object}
         */
        function (data, target) {
            return data.children1[0].children2;
        }
});

let combobox3 = new CascadingComboBox({
    id: 'category3',
    onCreateOption: onCreateOptionCallback,
    onSelected: onItemSelectedCallback
});

mainCombobox.attachChild({
    child: combobox3,
    onCreateChildData:
        /**
         * @callback onCreateChildDataCallback
         * @param {Object} data
         * @param {CascadingComboBox} target
         * @returns {Object}
         */
        function (data, target) {
            return data.children1[0].children3;
        }
});

/**
 *
 * @param {CascadingComboBox} sender
 * @param {int} index
 * @param {object} element
 * @returns {{key, value}}
 */
function onCreateOptionCallback(sender, index, element) {
    return {
        key: element.id,
        value: element.name
    }
}

/**
 *
 * @param {CascadingComboBox} sender
 * @param {object} data
 * @returns {Array|*|children|HTMLCollection}
 */
function onCreateChildDataCallback(sender, data) {
    return data.children;
}

/**
 *
 * @param {CascadingComboBox} sender
 * @param {int} index
 */
function onItemSelectedCallback(sender, index) {
    console.log(`${sender.id} item #${index} seleted.`);
}