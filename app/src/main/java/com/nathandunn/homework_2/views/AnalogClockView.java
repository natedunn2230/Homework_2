package com.nathandunn.homework_2.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.nathandunn.homework_2.R;
import com.nathandunn.homework_2.TimeController;
import com.tomerrosenfeld.customanalogclockview.CustomAnalogClock;
import com.tomerrosenfeld.customanalogclockview.HandsOverlay;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AnalogClockView extends ClockView {

    private CustomAnalogClock analogClock;
    private TextView analogClockDateTextView, analogClockSecondsTextView;
    private String stringDateTime, stringSecondTime;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
    private SimpleDateFormat secondFormat = new SimpleDateFormat("ss");

    public AnalogClockView(Context context, TimeController newTimeController){
        super(context, newTimeController);
        LayoutInflater.from(context).inflate(R.layout.analog_clock, this, true);
        init();
    }

    @Override
    public void update(Date time){
        stringDateTime = dateFormat.format(time);
        analogClockDateTextView.setText(stringDateTime);

        stringSecondTime = secondFormat.format(time);
        analogClockSecondsTextView.setText(stringSecondTime);

        Calendar calendar  = Calendar.getInstance();
        calendar.setTime(time);
        analogClock.setTime(calendar);
    }

    private void init(){
        analogClock = findViewById(R.id.analog_clock);

        analogClockDateTextView = findViewById(R.id.analog_clock_date_text_view);
        analogClockSecondsTextView = findViewById(R.id.analog_clock_seconds_text_view);

        analogClockDateTextView.setText("...");
        analogClockSecondsTextView.setText("...");
    }

}
