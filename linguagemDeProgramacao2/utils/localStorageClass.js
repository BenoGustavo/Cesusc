class LocalStorageController {
    constructor() {
        if (!window.localStorage) {
            throw new Error('Local storage is not supported by this browser.');
        }

        this.localStorage = window.localStorage;
    }

    setList(key, list) {
        this.localStorage.setItem(key, JSON.stringify(list));
    }

    getList(key) {
        const list = this.localStorage.getItem(key);
        return list ? JSON.parse(list) : null;
    }

    addItemToList(key, item) {
        let list = this.getList(key);
        if (!list) {
            list = [];
        }
        list.push(item);
        this.setList(key, list);
    }

    removeItemFromList(key, itemIndex) {
        let list = this.getList(key);
        if (list && list.length > itemIndex) {
            list.splice(itemIndex, 1);
            this.setList(key, list);
        }
    }

    clearList(key) {
        this.localStorage.removeItem(key);
    }

    clearAll() {
        this.localStorage.clear();
    }
}