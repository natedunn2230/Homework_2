package com.nathandunn.homework_2;

import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DigitalClockView extends TimeView {

    String stringTime;
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd MMM YYYY");

    DigitalClockView(TimeController newTimeController){
        super(newTimeController);
    }

    public void update(Date time){
        stringTime = dateFormat.format(time);
    }

}
