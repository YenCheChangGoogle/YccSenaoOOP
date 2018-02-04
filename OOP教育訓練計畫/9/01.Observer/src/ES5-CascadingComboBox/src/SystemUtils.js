/**
 * 判斷物件是否為空值
 * @param {*} target 要判斷的物件，可以傳入任何物件。
 * @returns {boolean} true = 為空值， false = 不是空值
 */
function isEmpty(target) {
    var type = typeof target;

    if (type === 'undefined') {
        return true;
    }

    if (type === 'boolean') {
        return !target;
    }

    if (target === null) {
        return true;
    }

    if (target === undefined) {
        return true;
    }

    if (target instanceof Array) {
        if (target.length < 1) {
            return true;
        }
    } else if (type === 'string') {
        if (target.length < 1) {
            return true;
        }
        if (target === '0') {
            return true;
        }
    } else if (type === 'object') {
        if (Object.keys(target).length < 1) {
            return true;
        }
    } else if (type === 'number') {
        if (target === 0) {
            return true;
        }
    }

    return false;
}

function isNotEmpty(target) {
    return !isEmpty(target);
}

function isNullObject(object) {
    return (object === null) || (object === undefined) || (typeof object === 'undefined');
}

function isNotNullObject(object) {
    return !isNullObject(object);
}

function isArray(object) {
    if (isNullObject(object)) {
        return false;
    }
    return (object instanceof Array);
}

function AssertArrayType(data) {
    if (!isArray(data)) {
        throw '參數必須是陣列型態';
    }
}