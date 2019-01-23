package com.sathi.android.sathiapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TravelMode extends Service {
    public TravelMode() {
    }long i;
    public int onStartCommand(Intent intent, int flags, int startId) {
        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();
        stopService(new Intent(TravelMode.this, Checker.class));
        stopService(new Intent(TravelMode.this, MyService.class));
        scheduler.scheduleAtFixedRate
                (new Runnable() {
                    public void run() {
                        // call service
                        i++;
                        Peerm.poli=3;
                        if(i==(60*60*2)){startService(new Intent(TravelMode.this, MyService.class));stopService(new Intent(TravelMode.this, TravelMode.class));}
                    }
                }, 0, 1, TimeUnit.SECONDS);
        return START_STICKY;}

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
