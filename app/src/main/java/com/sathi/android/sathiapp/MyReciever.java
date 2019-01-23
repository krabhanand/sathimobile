package com.sathi.android.sathiapp;

/**
 * Created by Anand on 28-08-2015.
 */
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;

public class MyReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent myIntent = new Intent(context, MyService.class);
        context.startService(myIntent);
    }
}