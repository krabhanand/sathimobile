package com.sathi.android.sathiapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.app.admin.DevicePolicyManager;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import android.telephony.SmsManager;

public class MyService extends Service {
    public MyService() {
    }
    protected PolicyManager policyManager;
    String n, p, ll;long tm=0,ttt=0;
    public static int kali=0;
    double sp,speedy,kk=0, k=0;
    static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(15); // no
    static ScheduledFuture<?> t;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        turnGPSOn();
        final LocationManager locationManager = (LocationManager) this
                .getSystemService(Context.LOCATION_SERVICE);
        final SmsManager smsManager = SmsManager.getDefault();
        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();
        SharedPreferences sharedPreferences = getSharedPreferences("kukur", Context.MODE_PRIVATE);
        p = sharedPreferences.getString("password", "");
        n = sharedPreferences.getString("number", "");
        policyManager = new PolicyManager(this);
        if (!policyManager.isAdminActive()) {
            Intent activateDeviceAdmin = new Intent(
                    DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            activateDeviceAdmin.putExtra(
                    DevicePolicyManager.EXTRA_DEVICE_ADMIN,
                    policyManager.getAdminComponent());
            activateDeviceAdmin
                    .putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                            "After activating admin, you will be able to block application uninstallation.");

        }
        scheduler.scheduleAtFixedRate
                (new Runnable() {
                    public void run() {
                        // call service
                        if ( !locationManager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                            if(kk==0){
                                smsManager.sendTextMessage("+91" + n, null, "Message From Sathi App: Warning! G.P.S. has been turned off, Sathi App will not be able to work." + "", null, null);
                                kk=1;
                            }
                           Intent kola=new Intent("com.sathi.android.sathiapp.LOP");kola.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), com.sathi.android.sathiapp.R.raw.tt);
                            mp.start();
                            startActivity(kola);
                        }
                        else{kk=0;}
                    }
                }, 0, 45, TimeUnit.SECONDS);

         LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                SharedPreferences sharedPreferences = getSharedPreferences("kukur", Context.MODE_PRIVATE);
                p = sharedPreferences.getString("password", "");
                n = sharedPreferences.getString("number", "");
Peerm.poli=1;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("kukuriya", "potty");
                editor.commit();
                location.getLatitude();
                speedy = location.getSpeed();
                speedy = speedy * 3.6;
                ll = sharedPreferences.getString("speed","60");
                sp=Double.parseDouble(ll);
                if (speedy >= sp && kali == 0) {
                    smsManager.sendTextMessage("+91" + n, null, "Message From Sathi App: Speed limit of " + ll + " km/h has been crossed." +"", null, null);
kali=1;                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), com.sathi.android.sathiapp.R.raw.sathiwarning);
                    mp.start(); }
                else if(speedy<(0.67*sp)){kali=0;}
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, tm,
                0, locationListener);

        return 0;
    }

    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onStop() {
        SharedPreferences sharedPreferences = getSharedPreferences("kukur", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("kukuriya", "pottya");
        editor.commit();
    }
    //@Override
    //protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
      //  if (resultCode == Activity.RESULT_OK
           //     && requestCode == PolicyManager.DPM_ACTIVATION_REQUEST_CODE) {
            // handle code for successfull enable of admin
        //} else {
         //   super.onActivityResult(requestCode, resultCode, data);
       // }

   // }
    public void onDestroy() {
        SharedPreferences sharedPreferences = getSharedPreferences("kukur", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("kukuriya", "pottya");
        editor.commit();
    }

    public void turnGPSOn() {



        String provider = Settings.Secure.getString(MyService.this.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        if (!provider.contains("gps")) { //if gps is disabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            sendBroadcast(poke);


        }
    }
    public void sendmsg(){
        t = executor.scheduleAtFixedRate
                (new Runnable() {
                    public void run() {
                        // call service
                        if (tm > 0) {
                            ttt = 0;
                            tm = 0;
                            t.cancel(false);
                        }
                        tm++;
                    }
                }, 0, 60 * 3, TimeUnit.SECONDS);



    }}


