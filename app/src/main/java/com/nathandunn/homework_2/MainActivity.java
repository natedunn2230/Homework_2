package com.nathandunn.homework_2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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

    private ListView clockListView;
    private Button addDigitalButton;

    private ArrayList<ClockView> ClockViews;
    private ArrayAdapter<ClockView> clockArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mainActivityContext = this;

        // reference buttons in activity_main.xml
        addDigitalButton = findViewById(R.id.add_digital_clock);

        //views that the ListView holds and adapter for connection to the
        ClockViews = new ArrayList<>();

        clockArrayAdapter = new ArrayAdapter<ClockView>(this, android.R.layout.simple_list_item_1, ClockViews);

        // reference ListView in activity_main.xml. Adapter is the connection between ClockViews and clockListView
        clockListView = findViewById(R.id.clock_list_view);
        clockListView.setAdapter(clockArrayAdapter);

        //Establishing relationship between timeController and TimeModel
        timeController = new TimeController();
        timeModel = new TimeModel(timeController);
        timeController.registerModel(timeModel);

        //Thread that takes care of ticking time
        timeThread = new TimeThread(timeModel);
        timeThread.start();


        //Listener to add a clock to the view
        addDigitalButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
            DigitalClockView newDigitalClock = new DigitalClockView(mainActivityContext, timeController);
            timeController.registerViews(newDigitalClock);
            ClockViews.add(newDigitalClock);
            clockArrayAdapter.notifyDataSetChanged();
            }
        });

    }

}
