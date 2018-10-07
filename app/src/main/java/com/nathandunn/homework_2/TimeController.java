package com.nathandunn.homework_2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeController {

    private ArrayList<TimeView> timeViews;
    private TimeModel timeModel;

    TimeController(){}

    public void registerModel(TimeModel model){
        this.timeModel = model;
        timeViews = new ArrayList<>();
    }

    public void registerViews(TimeView v){
        this.timeViews.add(v);
    }

    public void updateView(){

        for(TimeView v: this.timeViews){
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
