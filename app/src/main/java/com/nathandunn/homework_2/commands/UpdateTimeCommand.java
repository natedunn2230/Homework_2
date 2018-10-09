package com.nathandunn.homework_2.commands;

import com.nathandunn.homework_2.TimeController;

import java.util.Calendar;
import java.util.Date;

public class UpdateTimeCommand extends Command{

    private Date previousTime;
    int newYear, newMonth, newDay, newHour, newMinute, newSecond;

    public UpdateTimeCommand(TimeController timeController, Date previousTime, int[] newTime){
        super(timeController);
        this.previousTime = previousTime;
        this.newYear = newTime[0];
        this.newMonth = newTime[1];
        this.newDay = newTime[2];
        this.newHour = newTime[3];
        this.newMinute = newTime[4];
        this.newSecond = newTime[5];
    }

    @Override
    public void doIt() {
        super.timeController.updateModel(newYear, newMonth, newDay, newHour, newMinute, newSecond);
    }

    @Override
    public void undoIt() {
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.setTime(this.previousTime);

        int prevYear = tempCalendar.get(Calendar.YEAR);
        int prevMonth = tempCalendar.get(Calendar.MONTH);
        int prevDay = tempCalendar.get(Calendar.DAY_OF_MONTH);
        int prevHour = tempCalendar.get(Calendar.HOUR);
        int prevMinute = tempCalendar.get(Calendar.MINUTE);
        int prevSecond = tempCalendar.get(Calendar.SECOND);

        super.timeController.updateModel(prevYear, prevMonth, prevDay, prevHour, prevMinute, prevSecond);
    }
}
