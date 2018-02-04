import {IObserver} from "./IObserver";

export const ISubject = (superclass) => class extends superclass {
    /**
     * 註冊觀察者
     * @param {IObserver} observer
     */
    registerObserver(observer) {
        throw new TypeError('registerObserver must be implemented!')
    }

    /**
     * 通知觀察者
     */
    notifyObservers() {
        throw new TypeError('notifyObservers must be implemented!')
    }

};