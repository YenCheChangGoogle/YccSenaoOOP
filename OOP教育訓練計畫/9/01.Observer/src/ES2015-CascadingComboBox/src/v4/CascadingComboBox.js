import * as SystemUtils from './SystemUtils';
import {ComboBox} from "./ComboBox";

/**
 * 連動下拉選單
 */
export class CascadingComboBox extends ComboBox {
    /**
     * @param {Object} options
     * @property {string} id
     * @property {createOptionCallback} onCreateOption
     * @property {itemSelectedCallback} onItemSelected
     * @constructor
     */
    constructor(options) {
        super(options);
        this.children = [];
        this.data = [];
        this.defaultOptions = [];
    }

    /**
     * 繫結事件
     */
    onItemSelected() {
        super.onItemSelected();
        if (this.domObject.selectedIndex === 0) {
            this.clearChildren();
            return;
        }
        this.updateChildren();
    }

    /**
     * 加入子選單
     * @param {Attachment} attachment
     */
    attachChild(attachment) {
        this.children.push(attachment);
    }

    /**
     * 設定資料。
     * @param {Object[]} data - 陣列型態的資料
     * @param {string[]} defaultOptions - 預設選項
     *        如果串接三層， defaultOptions 就要將三層的 key 組成陣列傳入。
     *        ex: ['GP1601-005', 'GP1611-003', 'GP1611-137']
     */
    setData(data, defaultOptions) {
        super.setData(data, defaultOptions);
        if (this.selectedIndex > 0) { this.updateChildren(); }
    }

    /**
     * 清除選項內容，子選單也會一併清除
     */
    clear() {
        super.clear();
        this.clearChildren();
    }

    /**
     * 清除子選單
     */
    clearChildren() {
        this.children.forEach(
            /**
             * 呼叫子選單的清除功能
             * @param {Attachment} attachment
             */
            (attachment) => {
                attachment.child.clear();
            });
    }

    /**
     * 更新下層選單
     */
    updateChildren() {
        // 將資料設定到下層選單
        this.children.forEach(
            /**
             * 呼叫子選單的清除功能
             * @param {Attachment} attachment
             */
            (attachment) => {
                if (SystemUtils.isNull(attachment.onCreateChildData)) { return; }
                let selectedData = this.data[this.domObject.selectedIndex - 1];
                let dataForChild = attachment.onCreateChildData(selectedData, attachment.child);
                let selectedKeysForChild = [];
                if (SystemUtils.isNotEmpty(this.defaultOptions)) {
                    selectedKeysForChild = this.defaultOptions.slice(1);
                }
                attachment.child.setData(dataForChild, selectedKeysForChild, attachment.child);
            }
        )
    }
}