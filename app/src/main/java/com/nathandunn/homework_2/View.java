package com.nathandunn.homework_2;

import java.util.Date;

public abstract class View {

    TimeController timeController;

    View(TimeController newTimeController){
        this.timeController = newTimeController;
    }

    public abstract void update(Date date);
}
