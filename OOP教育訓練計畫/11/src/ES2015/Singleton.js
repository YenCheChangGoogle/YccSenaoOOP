let instance = null;

export class Singleton {
    constructor(data) {
        if (!instance) {
            this.data = data;
            instance = this
        }
        else {
            return instance;
        }
    }

    SingletonOperation() {
    }

    GetSingletonData() {
        return this.data
    }
}