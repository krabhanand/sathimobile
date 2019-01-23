package com.sathi.android.sathiapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;

public class PackageChangeReciever extends BroadcastReceiver {
    public PackageChangeReciever() {
    }
String nm;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        SharedPreferences sharedPreferences = context.getSharedPreferences("kukur", Context.MODE_PRIVATE);
        nm= sharedPreferences.getString("number","");
        final SmsManager smsManager = SmsManager.getDefault();
      //  smsManager.sendTextMessage("+91" + nm, null, "Message from Sathi App: Warning! Sathi App has been uninstalled" +"", null, null);

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
