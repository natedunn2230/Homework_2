package com.nathandunn.homework_2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeController {

    ArrayList<View> timeViews;
    TimeModel timeModel;

    TimeController(){}

    public void registerModel(TimeModel model){
        this.timeModel = model;
        timeViews = new ArrayList<>();
    }

    public void registerViews(View v){
        this.timeViews.add(v);
    }

    public void updateView(){

        for(View v: this.timeViews){
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
