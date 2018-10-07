package com.nathandunn.homework_2;

import android.util.Log;

public class TimeThread extends Thread {

    private TimeModel timeModel;
    private boolean timeRunning;

    TimeThread(TimeModel timeModel){
        this.timeModel = timeModel;
        this.timeRunning = true;
    }

    public void run(){
        while(timeRunning) {
            try {
                timeModel.tick();
                Thread.sleep(1000);
            } catch (Exception error) {
                error.printStackTrace();
                Log.d("Error", "An error occurred in the TimeThread run method");
            }

        }
    }
}
