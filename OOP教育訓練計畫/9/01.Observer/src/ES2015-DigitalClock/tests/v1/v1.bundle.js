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
/******/ 	return __webpack_require__(__webpack_require__.s = 1);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
const HOURS_PER_DAY = 24;
/* harmony export (immutable) */ __webpack_exports__["a"] = HOURS_PER_DAY;

const MINUTES_PER_HOUR = 60;
/* harmony export (immutable) */ __webpack_exports__["b"] = MINUTES_PER_HOUR;

const SECONDS_PER_MINUTE = 60;
/* harmony export (immutable) */ __webpack_exports__["d"] = SECONDS_PER_MINUTE;

const MSECONDS_PER_SECOND = 1000;
/* harmony export (immutable) */ __webpack_exports__["c"] = MSECONDS_PER_SECOND;

const SECONDS_PER_DAY = HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
/* unused harmony export SECONDS_PER_DAY */


/***/ }),
/* 1 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__DigitalClock_js__ = __webpack_require__(2);


let options = {
    time: 'dc',
    period: 'dc_period',
    second: 'dc_second'
};

let digitalClock = new __WEBPACK_IMPORTED_MODULE_0__DigitalClock_js__["a" /* DigitalClock */](options);

/***/ }),
/* 2 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__Clock_js__ = __webpack_require__(3);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__TimeConsts__ = __webpack_require__(0);



class DigitalClock {

    constructor(options) {
        this._clock = new __WEBPACK_IMPORTED_MODULE_0__Clock_js__["a" /* Clock */]();
        this.hoursAndMinutes = document.getElementById(options.time);
        this.seconds = document.getElementById(options.second);
        this.period = document.getElementById(options.period);
        this.bindEvents();
        this.initClock();
    }

    render(hours, minutes, seconds) {
        this.hoursAndMinutes.innerHTML = hours + ":" + minutes;
        this.seconds.innerHTML = seconds;
        this.period.innerHTML = (hours > 12) ? 'PM' : 'AM';
    }

    bindEvents() {
        setInterval(() => {
            let hours = this.ticking(this._clock.hours);
            let minutes = this.ticking(this._clock.minutes);
            let seconds = this.ticking(this._clock.seconds);
            this.render(hours, minutes, seconds);
        }, __WEBPACK_IMPORTED_MODULE_1__TimeConsts__["c" /* MSECONDS_PER_SECOND */]);
    }

    initClock() {
        let now = new Date();
        this._clock.hours = now.getHours();
        this._clock.minutes = now.getMinutes();
        this._clock.seconds =  now.getSeconds();
    }

    ticking(ticVal) {
        if (ticVal < 10) {
            ticVal = "0" + ticVal;
        }
        return ticVal;
    }

}
/* harmony export (immutable) */ __webpack_exports__["a"] = DigitalClock;


/***/ }),
/* 3 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__TimeConsts__ = __webpack_require__(0);


class Clock {

    constructor() {
        this._hours = 0;
        this._minutes = 0;
        this._seconds = 0;
        this.initTimer();
    }

    get seconds() {
        return this._seconds;
    }

    set seconds(value) {
        this._seconds = value;
    }

    get hours() {
        return this._hours;
    }

    set hours(value) {
        this._hours = value;
    }

    get minutes() {
        return this._minutes;
    }

    set minutes(value) {
        this._minutes = value;
    }

    initTimer() {
        setInterval(() => {
            this._seconds++;

            if (this._seconds >= __WEBPACK_IMPORTED_MODULE_0__TimeConsts__["d" /* SECONDS_PER_MINUTE */]) {

                this._seconds = 0;
                this._minutes++;

                if (this._minutes >= __WEBPACK_IMPORTED_MODULE_0__TimeConsts__["b" /* MINUTES_PER_HOUR */]) {

                    this._minutes = 0;
                    this._hours++;

                    if (this._hours >= __WEBPACK_IMPORTED_MODULE_0__TimeConsts__["a" /* HOURS_PER_DAY */]) {
                        this._hours = 0;
                    }
                }
            }
        }, __WEBPACK_IMPORTED_MODULE_0__TimeConsts__["c" /* MSECONDS_PER_SECOND */]);
    }
}
/* harmony export (immutable) */ __webpack_exports__["a"] = Clock;


/***/ })
/******/ ]);