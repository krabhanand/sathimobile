package com.sathi.android.sathiapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.telephony.SmsManager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Checker extends Service {
    public Checker() {
    }long i=0;String n,p,ll;
    public int onStartCommand(Intent intent, int flags, int startId) {
    ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), com.sathi.android.sathiapp.R.raw.sathiwarning);
        mp.start();
        SharedPreferences sharedPreferences = getSharedPreferences("kukur", Context.MODE_PRIVATE);
        p = sharedPreferences.getString("password", "");
        n = sharedPreferences.getString("number", "");
        ll = sharedPreferences.getString("speed","60");

        final SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+91" + n, null, "Message From Sathi App: Speed limit of " + ll + " km/h has been crossed." +"", null, null);

        stopService(new Intent(Checker.this, MyService.class));
        scheduler.scheduleAtFixedRate
                (new Runnable() {
                    public void run() {
                        // call service
                        i++;

                   if(i==(60*2)){startService(new Intent(Checker.this, MyService.class));stopService(new Intent(Checker.this, Checker.class));}
                    }
                }, 0, 1, TimeUnit.SECONDS);
                        return 0;}
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
