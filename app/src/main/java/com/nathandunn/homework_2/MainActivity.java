package com.nathandunn.homework_2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.nathandunn.homework_2.views.AnalogClockView;
import com.nathandunn.homework_2.views.ClockView;
import com.nathandunn.homework_2.views.DigitalClockView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mainActivityContext;

    private TimeModel timeModel;
    private TimeController timeController;
    private TimeThread timeThread;

    private LinearLayout clockListLayout;
    private Button addDigitalButton, addAnalogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mainActivityContext = this;

        // reference buttons in activity_main.xml
        addDigitalButton = findViewById(R.id.add_digital_clock);
        addAnalogButton = findViewById(R.id.add_analog_clock);

        // reference ListView in activity_main.xml. Adapter is the connection between ClockViews and clockListView
        clockListLayout = findViewById(R.id.clock_list_layout);

        //Establishing relationship between timeController and TimeModel
        timeController = new TimeController();
        timeModel = new TimeModel(timeController, this);
        timeController.registerModel(timeModel);

        //Thread that takes care of ticking time
        timeThread = new TimeThread(timeModel);
        timeThread.start();

        //On click listeners
        addDigitalButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                DigitalClockView newDigitalClock = new DigitalClockView(mainActivityContext, timeController);
                timeController.registerViews(newDigitalClock);
                clockListLayout.addView(newDigitalClock);
                clockListLayout.invalidate();
            }
        });

        addAnalogButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                AnalogClockView newAnalogClock = new AnalogClockView(mainActivityContext, timeController);
                timeController.registerViews(newAnalogClock);
                clockListLayout.addView(newAnalogClock);
                clockListLayout.invalidate();
            }
        });

    }

}
