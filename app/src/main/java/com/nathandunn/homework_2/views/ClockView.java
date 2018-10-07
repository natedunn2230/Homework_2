package com.nathandunn.homework_2.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.nathandunn.homework_2.R;
import com.nathandunn.homework_2.TimeController;

import java.util.Date;

public abstract class ClockView extends View {

    protected TimeController timeController;


    public ClockView(Context context, TimeController newTimeController){
        super(context);
        this.timeController = newTimeController;
    }

    public abstract void update(Date date);


}
