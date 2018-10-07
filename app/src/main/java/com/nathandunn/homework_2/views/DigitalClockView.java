package com.nathandunn.homework_2.views;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nathandunn.homework_2.TimeController;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DigitalClockView extends ClockView {

    private TextView digitalClockTextView;
    private String stringTime;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd MMM YYYY");


    public DigitalClockView(Context context,  TimeController newTimeController){
        super(context, newTimeController);
        init();
    }

    public void update(Date time){
        stringTime = dateFormat.format(time);
        digitalClockTextView.setText(stringTime);
    }

    private void init(){
        digitalClockTextView = new TextView(super.getContext());
        digitalClockTextView.setText("Createddddd");
    }

}
