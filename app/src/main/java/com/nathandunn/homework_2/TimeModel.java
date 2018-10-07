package com.nathandunn.homework_2;


import java.util.Calendar;
import java.util.Date;

public class TimeModel {
    private Calendar date;
    private TimeController timeController;

    TimeModel(TimeController newTimeController) {
        this.timeController = newTimeController;
        date = Calendar.getInstance();
    }

    public void setYear(int newYear) {
        this.date.set(Calendar.YEAR, newYear);
        this.timeController.updateView();
    }

    public void setMonth(int newMonth) {
        this.date.set(Calendar.MONTH, newMonth);
        this.timeController.updateView();
    }

    public void setDay(int newDay) {
        this.date.set(Calendar.DAY_OF_MONTH, newDay);
        this.timeController.updateView();
    }

    public void setHour(int newHour) {
        this.date.set(Calendar.HOUR, newHour);
        this.timeController.updateView();
    }

    public void setMinute(int newMinute) {
        this.date.set(Calendar.MINUTE, newMinute);
        this.timeController.updateView();
    }

    public void setSecond(int newSecond) {
        this.date.set(Calendar.SECOND, newSecond);
        this.timeController.updateView();
    }

    public Date getTime(){
        return this.date.getTime();
    }

    public void tick(){
        this.date.set(Calendar.SECOND, this.date.get(Calendar.SECOND) + 1);
        this.timeController.updateView();
    }
}
