import {CascadingComboBox} from "../v4/CascadingComboBox";
import {Button} from "../v4/Button";

let mainCombobox = new CascadingComboBox({
    id: 'categoryMain',
    onCreateOption: onCreateOptionCallback,
    onSelected: onItemSelectedCallback
});

let okButton = new Button('okbutton');
mainCombobox.registerObserver(okButton);

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
 * @param {int} index
 * @param {object} element
 * @returns {{key, value}}
 */
function onCreateOptionCallback(index, element) {
    return {
        key: element.id,
        value: element.name
    }
}

/**
 *
 * @param {object} data
 * @returns {Array|*|children|HTMLCollection}
 */
function onCreateChildDataCallback(data) {
    return data.children;
}

/**
 *
 * @param {int} index
 */
function onItemSelectedCallback(index) {
    console.log(`${sender.id} item #${index} seleted.`);
}