package com.nathandunn.homework_2;

import java.util.Date;

public abstract class TimeView {

    TimeController timeController;

    TimeView(TimeController newTimeController){
        this.timeController = newTimeController;
    }

    public abstract void update(Date date);
}
