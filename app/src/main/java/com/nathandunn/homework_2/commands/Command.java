package com.nathandunn.homework_2.commands;

import com.nathandunn.homework_2.TimeController;

public abstract class Command {

    protected TimeController timeController;

    public Command(TimeController timeController) {
        this.timeController = timeController;
    }

    public abstract void doIt();
    public abstract void undoIt();
}