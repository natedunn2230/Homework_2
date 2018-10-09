package com.nathandunn.homework_2.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nathandunn.homework_2.R;
import com.nathandunn.homework_2.TimeController;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DigitalClockView extends ClockView {

    private TextView digitalClockTextView;
    private String stringTime;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd MMM YYYY");


    public DigitalClockView(Context context, TimeController newTimeController){
        super(context, newTimeController);
        LayoutInflater.from(context).inflate(R.layout.digital_clock, this, true);
        init();
    }

    @Override
    public void update(Date time){
        stringTime = dateFormat.format(time);
        digitalClockTextView.setText(stringTime);
}

    private void init(){
        digitalClockTextView = findViewById(R.id.digital_clock_text_view);
        digitalClockTextView.setText("...");
    }

}
