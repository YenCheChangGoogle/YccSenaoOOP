import {CascadingComboBox} from "../v2/CascadingComboBox";

let comboBox3 = new CascadingComboBox('category3');
let comboBox2 = new CascadingComboBox('category2');
let comboBox1 = new CascadingComboBox('category1');
comboBox1.attachChild(comboBox2);
comboBox1.attachChild(comboBox3);

comboBox3.onCreateOption = onCreateOption;
comboBox3.onItemSelected = onItemSelected;

comboBox2.onCreateOption = onCreateOption;
comboBox2.onCreateChildData = onCreateChildData;
comboBox2.onItemSelected = onItemSelected;

comboBox1.onCreateOption = onCreateOption;
comboBox1.onCreateChildData = onCreateChildData;
comboBox1.onItemSelected = onItemSelected;

comboBox1.setData(
    sampleData["Category"],
    ['GP1601-005', 'GP1611-003', 'GP1611-137']);

/**
 *
 * @param {CascadingComboBox} sender
 * @param {int} index
 * @param {object} element
 * @returns {{key, value}}
 */
function onCreateOption(sender, index, element) {
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
function onCreateChildData(sender, data) {
    return data.children;
}

/**
 *
 * @param {CascadingComboBox} sender
 * @param {int} index
 */
function onItemSelected(sender, index) {
    console.log(`${sender.id} item #${index} seleted.`);
}