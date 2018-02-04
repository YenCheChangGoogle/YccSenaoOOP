import {IObserver} from "./IObserver";
import {ComboBox} from "./ComboBox";

export class Button extends IObserver(Object) {

    constructor(id) {
        super();
        this.domObject = document.getElementById(id);
    }

    /**
     * Subject 更新
     * @param {ISubject} subject
     */
    update(subject) {
        this.caption = subject.selectedIndex;
    }

    get caption() {
        return this.domObject.innerHTML;
    }

    set caption(value) {
        this.domObject.innerHTML = value;
    }
}