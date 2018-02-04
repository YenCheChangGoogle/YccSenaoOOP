/**
 * 判斷物件是否為空值
 * @param {*} target - 物件
 * @returns {boolean} - true 代表物件為空值，false 代表物件不為空值
 */
function isEmpty(target) {
    let type = typeof target;

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
    }
    else if (type === 'string') {
        if (target.length < 1) {
            return true;
        }
        if (target === '0') {
            return true;
        }
    }
    else if (type === 'object') {
        if (Object.keys(target).length < 1) {
            return true;
        }
    }
    else if (type === 'number') {
        if (target === 0) {
            return true;
        }
    }

    return false;
}

/**
 * 判斷物件是否不為空值
 * @param {*} target - 物件
 * @returns {boolean} - true 代表物件不為空值，false 代表物件為空值
 */
function isNotEmpty(target) {
    return !isEmpty(target);
}

/**
 * 判斷物件是否為 null
 * @param {object} target - 物件
 * @returns {boolean} - true 代表物件為 null，false 代表物件不為 null
 */
function isNull(target) {
    return (target === null) || (target === undefined) || (typeof target === 'undefined');
}

/**
 * 判斷物件是否不為 null
 * @param {object} target - 物件
 * @returns {boolean} - true 代表物件不為 null，false 代表物件為 null
 */
function isNotNull(target) {
    return !isNull(target);
}

export {isEmpty, isNotEmpty, isNull, isNotNull};