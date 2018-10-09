package com.nathandunn.homework_2;

import com.nathandunn.homework_2.views.ClockView;

import java.util.ArrayList;

public class TimeController {

    private ArrayList<ClockView> ClockViews;
    private TimeModel timeModel;

    TimeController(){
        ClockViews = new ArrayList<>();
    }

    public void registerModel(TimeModel model){
        this.timeModel = model;
    }

    public void registerViews(ClockView v){
        this.ClockViews.add(v);
    }

    public void updateView(){

        for(ClockView v: this.ClockViews){
            v.update(timeModel.getTime());
        }
    }

    public void updateModel(int year, int month, int day, int hour, int minute, int second){
        this.timeModel.setYear(year);
        this.timeModel.setMonth(month);
        this.timeModel.setDay(day);
        this.timeModel.setHour(hour);
        this.timeModel.setMinute(minute);
        this.timeModel.setSecond(second);
    }
}
