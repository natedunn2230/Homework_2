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
    private TextView analogClockTextView;
    private String stringTime;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");

    public AnalogClockView(Context context, TimeController newTimeController){
        super(context, newTimeController);
        LayoutInflater.from(context).inflate(R.layout.analog_clock, this, true);
        init();
    }

    public void update(Date time){
        stringTime = dateFormat.format(time);
        analogClockTextView.setText(stringTime);

        Calendar calendar  = Calendar.getInstance();
        calendar.setTime(time);
        analogClock.setTime(calendar);
    }

    private void init(){
        analogClock = findViewById(R.id.analog_clock);

        analogClockTextView = findViewById(R.id.analog_clock_text_view);
        analogClockTextView.setText("...");
    }

}
