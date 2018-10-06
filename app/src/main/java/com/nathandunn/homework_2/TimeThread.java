package com.nathandunn.homework_2;

import android.util.Log;

public class TimeThread extends Thread {

    private TimeModel timeModel;
    private boolean timeRunning;
    private static int count = 0;
    TimeThread(TimeModel timeModel){
        this.timeModel = timeModel;
        this.timeRunning = true;
        count++;
    }

    public void run(){
        Log.d("asdf", "Thread " + count + " running" );
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
