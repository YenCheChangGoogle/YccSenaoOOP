import * as SystemUtils from "./SystemUtils";
import {ISubject} from "./ISubject";

import Assert from "assert-js";
/**
 * @typedef {Object} optionType
 * @property {string} key
 * @property {string} value
 */

/**
 * @callback createOptionCallback
 * @param {Number} index
 * @param {Object} data
 * @returns {optionType}
 */

/**
 * @callback itemSelectedCallback
 * @param {Number} selectedIndex
 * @param {CascadingComboBox} target
 */

export class ComboBox extends ISubject(Object){
    /**
     * @param {Object} options
     * @property {string} id
     * @property {createOptionCallback} onCreateOption
     * @property {itemSelectedCallback} onItemSelected
     * @constructor
     */
    constructor(options) {
        super();
        this.domObject = document.getElementById(options.id);
        Assert.true(
            SystemUtils.isNotNull(this.domObject),
            `HTML 元素 ${options.id} 不存在!`);
        this.itemSelectedCallback = options.onItemSelected;
        this.createOptionCallback = options.onCreateOption;
        this.observers = [];
        this.bindEvents();
    }

    get selectedIndex() {
        return this.domObject.selectedIndex;
    }

    set selectedIndex(value) {
        this.domObject.selectedIndex = value;
    }

    bindEvents() {
        this.domObject.onchange = this.onItemSelected.bind(this);
    }

    onItemSelected() {
        if (SystemUtils.isNotNull(this.itemSelectedCallback)) {
            this.itemSelectedCallback(this.domObject.selectedIndex);
        }
        this.notifyObservers();
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
    }

    /**
     * 建立選項
     * @param {object} element
     * @param {int} index - element 的編號
     */
    createOptions(element, index) {
        if (SystemUtils.isNull(this.createOptionCallback)) {
            return;
        }

        // 呼叫使用者指定的 callback 將陣列元素轉換成 option
        let option = this.createOptionCallback(index, element);

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
    }

    /**
     * 註冊觀察者
     * @param {ComboBoxObserver} observer
     */
    registerObserver(observer) {
        this.observers.push(observer);
    }

    /**
     * 通知觀察者
     */
    notifyObservers() {
        /**
         * @param observer Observer
         */
        this.observers.forEach((observer) => {
            observer.update(this);
        })
    }
}