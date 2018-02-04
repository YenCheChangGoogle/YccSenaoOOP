import {Clock} from "./Clock.js";
import * as TimeConsts from './TimeConsts';

export class DigitalClock {

    constructor(options) {
        this._clock = new Clock();
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
        }, TimeConsts.MSECONDS_PER_SECOND);
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