/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 12);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _InvalidValueException = __webpack_require__(2);

var _InvalidValueException2 = _interopRequireDefault(_InvalidValueException);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var Assert = function () {
    function Assert() {
        _classCallCheck(this, Assert);
    }

    _createClass(Assert, null, [{
        key: 'instanceOf',

        /**
         * @param {object} objectValue
         * @param {function} expectedInstance
         * @param {string} [message]
         */
        value: function instanceOf(objectValue, expectedInstance) {
            var message = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

            this.string(message, "Custom error message passed to Assert.instanceOf needs to be a valid string.");

            if ((typeof objectValue === 'undefined' ? 'undefined' : _typeof(objectValue)) !== 'object') {
                throw _InvalidValueException2.default.expected("object", objectValue, message);
            }

            if (!(objectValue instanceof expectedInstance)) {
                throw _InvalidValueException2.default.expected(expectedInstance.name, objectValue, message.length ? message : "Expected instance of \"${expected}\" but got \"${received}\".");
            }
        }

        /**
         * @param {int} integerValue
         * @param {string} [message]
         */

    }, {
        key: 'integer',
        value: function integer(integerValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(message, "Custom error message passed to Assert.integer needs to be a valid string.");

            if (!Number.isInteger(integerValue)) {
                throw _InvalidValueException2.default.expected("integer", integerValue, message);
            }
        }

        /**
         * @param {number} numberValue
         * @param {string} [message]
         */

    }, {
        key: 'number',
        value: function number(numberValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(message, "Custom error message passed to Assert.number needs to be a valid string.");

            if (typeof numberValue !== 'number') {
                throw _InvalidValueException2.default.expected("number", numberValue);
            }
        }

        /**
         * @param {string} stringValue
         * @param {string} [message]
         */

    }, {
        key: 'string',
        value: function string(stringValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            if (typeof message !== "string") {
                throw "Custom error message passed to Assert.string needs to be a valid string.";
            }

            if (typeof stringValue !== "string") {
                throw _InvalidValueException2.default.expected("string", stringValue, message);
            }
        }

        /**
         * @param {boolean} booleanValue
         * @param {string} [message]
         */

    }, {
        key: 'boolean',
        value: function boolean(booleanValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(message, "Custom error message passed to Assert.boolean needs to be a valid string.");

            if (typeof booleanValue !== 'boolean') {
                throw _InvalidValueException2.default.expected("boolean", booleanValue, message);
            }
        }

        /**
         * @param {boolean} value
         * @param {string} [message]
         */

    }, {
        key: 'true',
        value: function _true(value) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.boolean(value);
            this.string(message, "Custom error message passed to Assert.true needs to be a valid string.");

            if (value !== true) {
                throw _InvalidValueException2.default.expected("true", value, message);
            }
        }

        /**
         * @param {boolean} value
         * @param {string} [message]
         */

    }, {
        key: 'false',
        value: function _false(value) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.boolean(value);
            this.string(message, "Custom error message passed to Assert.false needs to be a valid string.");

            if (value !== false) {
                throw _InvalidValueException2.default.expected("false", value, message);
            }
        }

        /**
         * @param {object} objectValue
         * @param {string} [message]
         */

    }, {
        key: 'object',
        value: function object(objectValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(message, "Custom error message passed to Assert.object needs to be a valid string.");

            if ((typeof objectValue === 'undefined' ? 'undefined' : _typeof(objectValue)) !== 'object') {
                throw _InvalidValueException2.default.expected("object", objectValue, message);
            }
        }

        /**
         * @param {string} expectedFunctionName
         * @param {object} objectValue
         * @param {string} [message]
         */

    }, {
        key: 'hasFunction',
        value: function hasFunction(expectedFunctionName, objectValue) {
            var message = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

            this.string(expectedFunctionName);
            this.object(objectValue);
            this.string(message, "Custom error message passed to Assert.hasFunction needs to be a valid string.");

            if (typeof objectValue[expectedFunctionName] !== 'function') {
                throw _InvalidValueException2.default.expected('object to has function "' + expectedFunctionName + '"', objectValue, message);
            }
        }

        /**
         * @param {array} arrayValue
         * @param {string} [message]
         */

    }, {
        key: 'array',
        value: function array(arrayValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(message, "Custom error message passed to Assert.array needs to be a valid string.");

            if (!Array.isArray(arrayValue)) {
                throw _InvalidValueException2.default.expected("array", arrayValue, message);
            }
        }

        /**
         * @param {function} functionValue
         * @param {string} [message]
         */

    }, {
        key: 'isFunction',
        value: function isFunction(functionValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(message, "Custom error message passed to Assert.isFunction needs to be a valid string.");

            if (typeof functionValue !== 'function') {
                throw _InvalidValueException2.default.expected("function", functionValue, message);
            }
        }

        /**
         * @param {int} expected
         * @param {int} integerValue
         * @param {string} [message]
         */

    }, {
        key: 'greaterThan',
        value: function greaterThan(expected, integerValue) {
            var message = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

            this.number(expected);
            this.number(integerValue);
            this.string(message, "Custom error message passed to Assert.greaterThan needs to be a valid string.");

            if (integerValue <= expected) {
                throw message.length > 0 ? message : 'Expected value ' + integerValue + ' to be greater than ' + expected;
            }
        }

        /**
         * @param {int} expected
         * @param {int} integerValue
         * @param {string} [message]
         */

    }, {
        key: 'greaterThanOrEqual',
        value: function greaterThanOrEqual(expected, integerValue) {
            var message = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

            this.number(expected);
            this.number(integerValue);
            this.string(message, "Custom error message passed to Assert.greaterThanOrEqual needs to be a valid string.");

            if (integerValue < expected) {
                throw message.length > 0 ? message : 'Expected value ' + integerValue + ' to be greater than ' + expected + ' or equal';
            }
        }

        /**
         * @param {int} expected
         * @param {int} integerValue
         * @param {string} [message]
         */

    }, {
        key: 'lessThan',
        value: function lessThan(expected, integerValue) {
            var message = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

            this.number(expected);
            this.number(integerValue);
            this.string(message, "Custom error message passed to Assert.lessThan needs to be a valid string.");

            if (integerValue >= expected) {
                throw message.length > 0 ? message : 'Expected value ' + integerValue + ' to be less than ' + expected;
            }
        }

        /**
         * @param {int} expected
         * @param {int} integerValue
         * @param {string} [message]
         */

    }, {
        key: 'lessThanOrEqual',
        value: function lessThanOrEqual(expected, integerValue) {
            var message = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

            this.number(expected);
            this.number(integerValue);
            this.string(message, "Custom error message passed to Assert.lessThanOrEqual needs to be a valid string.");

            if (integerValue > expected) {
                throw message.length > 0 ? message : 'Expected value ' + integerValue + ' to be less than ' + expected + ' or equal';
            }
        }

        /**
         * @param {array} arrayValue
         * @param {function} expectedInstance
         * @param {string} [message]
         */

    }, {
        key: 'containsOnly',
        value: function containsOnly(arrayValue, expectedInstance) {
            var message = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

            this.array(arrayValue, "Assert.containsOnly require valid array, got \"${received}\".");
            this.string(message, "Custom error message passed to Assert.containsOnly needs to be a valid string.");

            var _iteratorNormalCompletion = true;
            var _didIteratorError = false;
            var _iteratorError = undefined;

            try {
                for (var _iterator = arrayValue[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
                    var element = _step.value;

                    try {
                        this.instanceOf(element, expectedInstance, message);
                    } catch (error) {
                        throw _InvalidValueException2.default.expected(expectedInstance.name, element, message.length ? message : "Expected instance of \"${expected}\" but got \"${received}\".");
                    }
                }
            } catch (err) {
                _didIteratorError = true;
                _iteratorError = err;
            } finally {
                try {
                    if (!_iteratorNormalCompletion && _iterator.return) {
                        _iterator.return();
                    }
                } finally {
                    if (_didIteratorError) {
                        throw _iteratorError;
                    }
                }
            }
        }

        /**
         * @param {int} expectedCount
         * @param {array} arrayValue
         * @param {string} [message]
         */

    }, {
        key: 'count',
        value: function count(expectedCount, arrayValue) {
            var message = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

            this.integer(expectedCount);
            this.array(arrayValue);
            this.string(message, "Custom error message passed to Assert.count needs to be a valid string.");

            if (arrayValue.length !== expectedCount) {
                throw message.length ? message : 'Expected count ' + expectedCount + ', got ' + arrayValue.length;
            }
        }

        /**
         * @param {*} value
         * @param {string} [message]
         */

    }, {
        key: 'notEmpty',
        value: function notEmpty(value) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(message, "Custom error message passed to Assert.empty needs to be a valid string.");

            if (value.length === 0) {
                throw _InvalidValueException2.default.expected("not empty value", value, message);
            }
        }

        /**
         * @param {int} integerValue
         * @param {string} [message]
         */

    }, {
        key: 'oddNumber',
        value: function oddNumber(integerValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.integer(integerValue);
            this.string(message, "Custom error message passed to Assert.oddNumber needs to be a valid string.");

            if (integerValue % 2 !== 1) {
                throw _InvalidValueException2.default.expected("odd number", integerValue, message);
            }
        }

        /**
         * @param {int} integerValue
         * @param {string} [message]
         */

    }, {
        key: 'evenNumber',
        value: function evenNumber(integerValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.integer(integerValue);
            this.string(message, "Custom error message passed to Assert.evenNumber needs to be a valid string.");

            if (integerValue % 2 !== 0) {
                throw _InvalidValueException2.default.expected("even number", integerValue, message);
            }
        }

        /**
         * @param {string} stringValue
         * @param {string} [message]
         */

    }, {
        key: 'jsonString',
        value: function jsonString(stringValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(stringValue);
            this.string(message, "Custom error message passed to Assert.jsonString needs to be a valid string.");

            try {
                JSON.parse(stringValue);
            } catch (e) {
                throw _InvalidValueException2.default.expected("json string", stringValue, message);
            }
        }

        /**
         * @param {string} emailValue
         * @param {string} [message]
         */

    }, {
        key: 'email',
        value: function email(emailValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(emailValue);
            this.string(message, "Custom error message passed to Assert.email needs to be a valid string.");

            var regexp = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i;

            if (!regexp.test(emailValue)) {
                throw _InvalidValueException2.default.expected("valid email address", emailValue, message);
            }
        }

        /**
         * @param {string} urlValue
         * @param {string} [message]
         */

    }, {
        key: 'url',
        value: function url(urlValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(urlValue);
            this.string(message, "Custom error message passed to Assert.url needs to be a valid string.");

            var regexp = /^(?:(?:https?|ftp):\/\/)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,}))\.?)(?::\d{2,5})?(?:[/?#]\S*)?$/i;

            if (!regexp.test(urlValue)) {
                throw _InvalidValueException2.default.expected("valid url", urlValue, message);
            }
        }

        /**
         * @param {string} uuidValue
         * @param {string} [message]
         */

    }, {
        key: 'uuid',
        value: function uuid(uuidValue) {
            var message = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "";

            this.string(uuidValue);
            this.string(message, "Custom error message passed to Assert.uuid needs to be a valid string.");

            var regexp = /^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$/i;

            if (!regexp.test(uuidValue)) {
                throw _InvalidValueException2.default.expected("valid uuid", uuidValue, message);
            }
        }
    }]);

    return Assert;
}();

exports.default = Assert;

/***/ }),
/* 1 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var assert = __webpack_require__(0).default;

module.exports = assert;

if (typeof window !== 'undefined') {
    window.Assert = assert;
}

/***/ }),
/* 2 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _Assert = __webpack_require__(0);

var _Assert2 = _interopRequireDefault(_Assert);

var _MessageFactory = __webpack_require__(3);

var _MessageFactory2 = _interopRequireDefault(_MessageFactory);

var _ValueConverter = __webpack_require__(4);

var _ValueConverter2 = _interopRequireDefault(_ValueConverter);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var InvalidValueException = function () {
    function InvalidValueException() {
        _classCallCheck(this, InvalidValueException);
    }

    _createClass(InvalidValueException, null, [{
        key: 'expected',

        /**
         * @param {string} type
         * @param {*} value
         * @param {string} [message]
         * @returns {Error}
         */
        value: function expected(type, value) {
            var message = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : "";

            _Assert2.default.string(message);

            if (message.length) {
                return new Error(_MessageFactory2.default.create(message, { expected: type, received: _ValueConverter2.default.toString(value) }));
            }

            return new Error('Expected ' + type + ' but got "' + _ValueConverter2.default.toString(value) + '".');
        }
    }]);

    return InvalidValueException;
}();

exports.default = InvalidValueException;

/***/ }),
/* 3 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _Assert = __webpack_require__(0);

var _Assert2 = _interopRequireDefault(_Assert);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var VALUE_NAME_REGEXP = /\${(.*?)}/g;

var MessageFactory = function () {
    function MessageFactory() {
        _classCallCheck(this, MessageFactory);
    }

    _createClass(MessageFactory, null, [{
        key: 'create',

        /**
         * @param {string} template
         * @param {object} [data]
         */
        value: function create(template) {
            var data = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : {};

            _Assert2.default.string(template);
            _Assert2.default.object(data);

            return template.replace(VALUE_NAME_REGEXP, function (placeholder, propertyName) {
                if (data.hasOwnProperty(propertyName)) {
                    return data[propertyName];
                }

                return placeholder;
            });
        }
    }]);

    return MessageFactory;
}();

exports.default = MessageFactory;

/***/ }),
/* 4 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var ValueConverter = function () {
    function ValueConverter() {
        _classCallCheck(this, ValueConverter);
    }

    _createClass(ValueConverter, null, [{
        key: 'toString',

        /**
         * @param {*} value
         * @returns {string}
         */
        value: function toString(value) {
            if (typeof value === 'string') {
                return 'string["' + value + '"]';
            }

            if (typeof value === 'number') {
                if (Number.isInteger(value)) {
                    return 'int[' + value + ']';
                }

                return 'float[' + value + ']';
            }

            if (typeof value === 'boolean') {
                return 'boolean[' + (value ? "true" : "false") + ']';
            }

            if (typeof value === 'function') {
                return 'function[' + value.toString() + ']';
            }

            if ((typeof value === 'undefined' ? 'undefined' : _typeof(value)) === 'object') {
                if (Array.isArray(value)) {
                    return 'array[length: ' + value.length + ']';
                }

                if (value instanceof Map) {
                    return 'Map[size: ' + value.size + ']';
                }

                if (value instanceof WeakMap) {
                    return 'WeakMap[]';
                }

                if (value instanceof Set) {
                    return 'Set[size: ' + value.size + ']';
                }

                if (value instanceof WeakSet) {
                    return 'WeakSet[]';
                }

                if (value instanceof String) {
                    return 'String["' + value + '"]';
                }

                if (value instanceof Number) {
                    var source = value.valueOf();

                    if (Number.isInteger(source)) {
                        return 'Number:int[' + source + ']';
                    }

                    return 'Number:float[' + source + ']';
                }

                if (value instanceof Boolean) {
                    return 'Boolean[' + (value.valueOf() ? "true" : "false") + ']';
                }

                if (value instanceof Date) {
                    return 'Date["' + value.toUTCString() + '"]';
                }

                if (value instanceof RegExp) {
                    return 'RegExp[' + value.toString() + ']';
                }

                return 'object[' + JSON.stringify(value) + ']';
            }

            if (typeof value === 'undefined') {
                return 'undefined';
            }

            throw 'Unhandled type ' + (typeof value === 'undefined' ? 'undefined' : _typeof(value));
        }
    }]);

    return ValueConverter;
}();

exports.default = ValueConverter;

/***/ }),
/* 5 */,
/* 6 */,
/* 7 */,
/* 8 */,
/* 9 */,
/* 10 */,
/* 11 */,
/* 12 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__v2_CascadingComboBox__ = __webpack_require__(13);


let comboBox3 = new __WEBPACK_IMPORTED_MODULE_0__v2_CascadingComboBox__["a" /* CascadingComboBox */]('category3');
let comboBox2 = new __WEBPACK_IMPORTED_MODULE_0__v2_CascadingComboBox__["a" /* CascadingComboBox */]('category2');
let comboBox1 = new __WEBPACK_IMPORTED_MODULE_0__v2_CascadingComboBox__["a" /* CascadingComboBox */]('category1');
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

/***/ }),
/* 13 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__SystemUtils__ = __webpack_require__(14);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_assert_js__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_assert_js___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_assert_js__);



/**
 * 連動下拉選單
 */
class CascadingComboBox {
    /**
     * Constructor
     * @param {string} id
     */
    constructor(id) {
        this.id = id;
        this.domObject = document.getElementById(id);
        __WEBPACK_IMPORTED_MODULE_1_assert_js___default.a.true(__WEBPACK_IMPORTED_MODULE_0__SystemUtils__["c" /* isNotNull */](this.domObject), `HTML 元素 ${id} 不存在!`);
        this.children = [];
        this.data = [];
        this.defaultOptions = [];
        this.onCreateOption = null;
        this.onCreateChildData = null;
        this.onItemSelected = null;

        this.bindEvents();
    }

    /**
     * 繫結事件
     */
    bindEvents() {
        // 當使用者選擇某個項目時會呼叫此函式
        this.domObject.onchange = () => {
            if (__WEBPACK_IMPORTED_MODULE_0__SystemUtils__["d" /* isNull */](this.onItemSelected)) { return; }

            // 將選取的項目編號傳給使用者指定的 callback
            this.onItemSelected(this, this.domObject.selectedIndex);

            // 如果沒設定下層選單，不用處理
            if (__WEBPACK_IMPORTED_MODULE_0__SystemUtils__["a" /* isEmpty */](this.children)) { return; }

            // 如果是選到第一個選項(預設值)
            if (this.domObject.selectedIndex === 0) {
                this.clearChildren();
                return;
            }

            this.updateChildren();
        }
    }

    /**
     * 加入子選單
     * @param {CascadingComboBox} child
     */
    attachChild(child) {
        this.children.push(child);
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

        // 如果有子選單而且有預設值
        if (__WEBPACK_IMPORTED_MODULE_0__SystemUtils__["b" /* isNotEmpty */](this.children) && this.domObject.selectedIndex > 0) {
            this.updateChildren();
        }
    }

    /**
     * 建立選項
     * @param {object} element
     * @param {int} index - element 的編號
     */
    createOptions(element, index) {
        if (__WEBPACK_IMPORTED_MODULE_0__SystemUtils__["d" /* isNull */](this.onCreateOption)) {
            return;
        }

        // 呼叫使用者指定的 callback 將陣列元素轉換成 option
        let option = this.onCreateOption(this, index, element);

        // 新增一個選項
        let newOption = new Option(option.value, option.key);
        this.domObject.options[this.domObject.options.length] = newOption;

        // 有預設選項嗎?
        if (__WEBPACK_IMPORTED_MODULE_0__SystemUtils__["a" /* isEmpty */](this.defaultOptions)) {
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
        this.clearChildren();
    }

    /**
     * 清除子選單
     */
    clearChildren() {
        this.children.forEach((child) => {
            child.clear();
        });
    }

    /**
     * 更新下層選單
     */
    updateChildren() {
        if (__WEBPACK_IMPORTED_MODULE_0__SystemUtils__["d" /* isNull */](this.onCreateChildData)) { return; }

        // 取得選到的資料
        let selectedData = this.data[this.domObject.selectedIndex - 1];

        // 呼叫 callback 將選到的資料傳換成給下層選單的資料
        let dataForChild = this.onCreateChildData(this, selectedData);
        let selectedKeysForChild = [];
        if (__WEBPACK_IMPORTED_MODULE_0__SystemUtils__["b" /* isNotEmpty */](this.defaultOptions)) {
            selectedKeysForChild = this.defaultOptions.slice(1);
        }

        // 將資料設定到下層選單
        this.children.forEach((child) => {
                child.setData(dataForChild, selectedKeysForChild);
            }
        )
    }
}
/* harmony export (immutable) */ __webpack_exports__["a"] = CascadingComboBox;


/***/ }),
/* 14 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return isEmpty; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return isNotEmpty; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "d", function() { return isNull; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return isNotNull; });


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

/***/ })
/******/ ]);