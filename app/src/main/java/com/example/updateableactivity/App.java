package com.example.updateableactivity;

import android.app.Application;
import android.support.v4.content.LocalBroadcastManager;

public class App extends Application {

    private static LocalBroadcastManager localBroadcastManager;

    @Override
    public void onCreate() {
        super.onCreate();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    public static LocalBroadcastManager broadcasts() {
        return localBroadcastManager;
    }

}
