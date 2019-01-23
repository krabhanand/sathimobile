package com.sathi.android.sathiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Setpwd extends Activity {
String kl,n,ll;EditText kk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpwd);
        final Button b=(Button)findViewById(R.id.button40);
kk=(EditText)findViewById(R.id.editText40);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final SharedPreferences sharedPreferences = getSharedPreferences("kukur", Context.MODE_PRIVATE);
                kl = kk.getText().toString();
                final SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("password", kl);
                editor.commit();
                n = sharedPreferences.getString("number", "");
                ll = sharedPreferences.getString("speed", "60");
                final SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("+91" + n, null, "Message From Sathi App: Sathi App has been set up. The password is " + kl + ". The speed limit is " + ll + "." + "", null, null);

                AlertDialog alertDialog = new AlertDialog.Builder(
                        Setpwd.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("Password set up.");

                // Setting Dialog Message
                alertDialog.setMessage("The password has been set up. Now, we are ready to go.");

                // Setting Icon to Dialog
                alertDialog.setIcon(com.sathi.android.sathiapp.R.drawable.sathilogo);

                // Setting OK Button
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        Intent intent = new Intent("com.sathi.android.sathiapp.SETTINGS");
                        startActivity(intent);
                        finish();
                    }
                }); alertDialog.show();
            }          });}

}
