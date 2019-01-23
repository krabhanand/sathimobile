package com.sathi.android.sathiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Starter extends Activity {
    String kl;Double dl;EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
       final Button b=(Button)findViewById(R.id.button);
ed=(EditText)findViewById(R.id.editText);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final SharedPreferences sharedPreferences=getSharedPreferences("kukur", Context.MODE_PRIVATE);
                kl=ed.getText().toString();
                final SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("speed", kl);
                editor.commit();
dl=Double.parseDouble(kl);
                if(dl<40) { final AlertDialog alertDialog = new AlertDialog.Builder(
                        Starter.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Speed Limit too low");

                    // Setting Dialog Message
                    alertDialog.setMessage("The speed limit that you are entering should be greater than 40 km/h. Please re-enter the speed.");

                    // Setting Icon to Dialog
                    alertDialog.setIcon(com.sathi.android.sathiapp.R.drawable.sathilogo);

                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed

                        }
                    }); alertDialog.show(); }else {
                    final AlertDialog alertDialog = new AlertDialog.Builder(
                            Starter.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Speed Limit set");

                    // Setting Dialog Message
                    alertDialog.setMessage("The speed limit has been set. Please set up the password next.");

                    // Setting Icon to Dialog
                    alertDialog.setIcon(com.sathi.android.sathiapp.R.drawable.sathilogo);

                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog close
                            Intent k = new Intent("com.sathi.android.sathiapp.Setpwd");
                            startActivity(k);
                            finish();
                        }
                    });
                    alertDialog.show();
            }}
        });
    }

  }
