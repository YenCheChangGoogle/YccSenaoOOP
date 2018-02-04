import {ISubject} from "./ISubject";

export const IObserver = (superclass) => class extends superclass {
    /**
     *
     * @param {ISubject} subject
     */
    update(subject) {
        throw new TypeError('update must be implemented');
    }
};