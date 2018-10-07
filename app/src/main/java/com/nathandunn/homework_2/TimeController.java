package com.nathandunn.homework_2;

import com.nathandunn.homework_2.views.ClockView;

import java.util.ArrayList;

public class TimeController {

    private ArrayList<ClockView> ClockViews;
    private TimeModel timeModel;

    TimeController(){}

    public void registerModel(TimeModel model){
        this.timeModel = model;
        ClockViews = new ArrayList<>();
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
        this.timeModel.setMonth(day);
        this.timeModel.setMonth(hour);
        this.timeModel.setMonth(minute);
        this.timeModel.setMonth(second);
    }
}
