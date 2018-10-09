package com.nathandunn.homework_2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;

import com.nathandunn.homework_2.commands.UpdateTimeCommand;
import com.nathandunn.homework_2.views.AnalogClockView;
import com.nathandunn.homework_2.views.ClockView;
import com.nathandunn.homework_2.views.DigitalClockView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mainActivityContext;

    private TimeModel timeModel;
    private TimeController timeController;
    private TimeThread timeThread;
    private CommandQ commands;

    private NumberPicker hNumberPicker, mNumberPicker, sNumberPicker, dayNumberPicker, monthNumberPicker, yearNumberPicker;
    private LinearLayout clockListLayout;
    private Button addDigitalButton, addAnalogButton, updateTimeButton, undoButton, redoButton;

    public MainActivity() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mainActivityContext = this;

        init();

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

        updateTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newYear = yearNumberPicker.getValue();
                int newMonth = monthNumberPicker.getValue() ;
                int newDay = dayNumberPicker.getValue();
                int newHour = hNumberPicker.getValue();
                int newMinute = mNumberPicker.getValue();
                int newSecond = sNumberPicker.getValue();

                int [] newTime = {newYear, newMonth, newDay, newHour, newMinute, newSecond};

                commands.executeCommand(new UpdateTimeCommand(timeController, timeModel.getTime(), newTime));

            }
        });

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commands.undoCommand();

            }
        });

        redoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commands.redoCommand();
            }
        });

    }

    private void init(){
        // reference ListView in activity_main.xml. Adapter is the connection between ClockViews and clockListView
        clockListLayout = findViewById(R.id.clock_list_layout);

        //Establishing relationship between timeController and TimeModel
        timeController = new TimeController();
        timeModel = new TimeModel(timeController, this);
        timeController.registerModel(timeModel);

         commands = CommandQ.getInstance();

        //Thread that takes care of ticking time
        timeThread = new TimeThread(timeModel);
        timeThread.start();

        // reference buttons in activity_main.xml
        addDigitalButton = findViewById(R.id.add_digital_clock);
        addAnalogButton = findViewById(R.id.add_analog_clock);
        updateTimeButton = findViewById(R.id.update_time_button);
        undoButton = findViewById(R.id.undo_button);
        redoButton = findViewById(R.id.redo_button);

        //Number pickers for editing date
        hNumberPicker = findViewById(R.id.hour_number_picker);
        mNumberPicker = findViewById(R.id.minute_number_picker);
        sNumberPicker = findViewById(R.id.second_number_picker);
        dayNumberPicker = findViewById(R.id.day_number_picker);
        monthNumberPicker = findViewById(R.id.month_number_picker);
        yearNumberPicker = findViewById(R.id.year_number_picker);

        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        //set min/max value of pickers
        hNumberPicker.setMinValue(1);
        hNumberPicker.setMaxValue(12);
        mNumberPicker.setMinValue(1);
        mNumberPicker.setMaxValue(59);
        sNumberPicker.setMinValue(1);
        sNumberPicker.setMaxValue(59);
        monthNumberPicker.setMinValue(0);
        monthNumberPicker.setMaxValue(months.length - 1);
        monthNumberPicker.setDisplayedValues(months);
        dayNumberPicker.setMinValue(1);
        dayNumberPicker.setMaxValue(31);
        yearNumberPicker.setMinValue(0);
        yearNumberPicker.setMaxValue(9999);

        //allow wrapping when user scrolls past choices
        hNumberPicker.setWrapSelectorWheel(true);
        mNumberPicker.setWrapSelectorWheel(true);
        sNumberPicker.setWrapSelectorWheel(true);
        dayNumberPicker.setWrapSelectorWheel(true);
        monthNumberPicker.setWrapSelectorWheel(true);
        yearNumberPicker.setWrapSelectorWheel(true);

        //sets default values of pickers
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.setTime(timeModel.getTime());
        hNumberPicker.setValue(tempCalendar.get(Calendar.HOUR));
        mNumberPicker.setValue(tempCalendar.get(Calendar.MINUTE));
        sNumberPicker.setValue(tempCalendar.get(Calendar.SECOND));
        dayNumberPicker.setValue(tempCalendar.get(Calendar.DAY_OF_MONTH));
        monthNumberPicker.setValue(tempCalendar.get(Calendar.MONTH));
        yearNumberPicker.setValue(tempCalendar.get(Calendar.YEAR));

    }

}
