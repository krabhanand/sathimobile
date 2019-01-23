package com.sathi.android.sathiapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Peerm extends Service {
    public Peerm() {
    }
public  static int poli;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
