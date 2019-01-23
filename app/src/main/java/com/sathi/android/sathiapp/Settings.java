package com.sathi.android.sathiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Anand on 11-08-2015.
 */
public class Settings extends Activity {
    Button b91,b92,b93,b94;int k=0;String p,n;
    protected void onCreate(Bundle paadaa) {

        super.onCreate(paadaa);
        setContentView(com.sathi.android.sathiapp.R.layout.settings);
        int color=1;
        final SmsManager smsManager = SmsManager.getDefault();
        SharedPreferences sharedPreferences = getSharedPreferences("kukur", Context.MODE_PRIVATE);
        p = sharedPreferences.getString("password", "");
        n = sharedPreferences.getString("number", "");          smsManager.sendTextMessage("+91" + n, null, "Message From Sathi App: Sathi App is now active on this number. The settings of this app has been opened." + "", null, null);

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
        Intent myIntent = new Intent(this, MyService.class);
        this.startService(myIntent);
        b91=(Button)findViewById(com.sathi.android.sathiapp.R.id.button4);
        b92=(Button)findViewById(com.sathi.android.sathiapp.R.id.button5);
        b94=(Button)findViewById(R.id.button17);
        TextView textView =(TextView)findViewById(R.id.textView21);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "© 2015<a href='http://www.sathiapp.com/support/'> SathiApp Support </a>";
        textView.setText(Html.fromHtml(text));
        b91.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k = new Intent("com.sathi.android.sathiapp.PWDNUM");
                startActivity(k);
            }
        });
        b92.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent j = new Intent("com.sathi.android.sathiapp.PWDPWD");
                startActivity(j);
            }
        });
b93=(Button)findViewById(R.id.button2);
        b93.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(Peerm.poli==3) { AlertDialog alertDialog = new AlertDialog.Builder(
                        Settings.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Already Active");

                    // Setting Dialog Message
                    alertDialog.setMessage("Travel mode is already active on this device.");

                    // Setting Icon to Dialog
                    alertDialog.setIcon(com.sathi.android.sathiapp.R.drawable.sathilogo);

                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed

                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();}
                else{final SmsManager smsManager = SmsManager.getDefault();
                    SharedPreferences sharedPreferences = getSharedPreferences("kukur", Context.MODE_PRIVATE);
                    p = sharedPreferences.getString("password", "");
                    n = sharedPreferences.getString("number", "");          smsManager.sendTextMessage("+91" + n, null, "Message From Sathi App: Public Transport mode has been activated on this number. SathiApp will stop working for now. Please make sure that the person holding this number logs in into the SathiApp again after the journey is complete to help SathiApp ensure his/her safety." + "", null, null);


                    AlertDialog alertDialog = new AlertDialog.Builder(
                        Settings.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Public Transport Mode Activated");

                    // Setting Dialog Message
                    alertDialog.setMessage("SathiApp will be not be able to provide you security. You will have to re-open this app and login into it (enter password) after you complete your journey to allow SathiApp to secure you again.");

                    // Setting Icon to Dialog
                    alertDialog.setIcon(com.sathi.android.sathiapp.R.drawable.sathilogo);

                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed

                            Intent myIntent = new Intent(Settings.this, MyService.class);
stopService(myIntent);stopService(myIntent);stopService(myIntent);stopService(myIntent);
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();}
            }});
    b94.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){Intent j=new Intent("com.sathi.android.sathiapp.PWDSPEED");
            startActivity(j);}});

    }}


