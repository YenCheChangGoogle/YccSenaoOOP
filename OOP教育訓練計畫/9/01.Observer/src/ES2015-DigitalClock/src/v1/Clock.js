import * as TimeConsts from './TimeConsts';

export class Clock {

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

            if (this._seconds >= TimeConsts.SECONDS_PER_MINUTE) {

                this._seconds = 0;
                this._minutes++;

                if (this._minutes >= TimeConsts.MINUTES_PER_HOUR) {

                    this._minutes = 0;
                    this._hours++;

                    if (this._hours >= TimeConsts.HOURS_PER_DAY) {
                        this._hours = 0;
                    }
                }
            }
        }, TimeConsts.MSECONDS_PER_SECOND);
    }
}