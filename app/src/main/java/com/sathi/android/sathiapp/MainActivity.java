package com.sathi.android.sathiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Anand on 15-08-2015.
 */
public class MainActivity extends Activity{
    EditText e1;
    Button b1;String n,pass,lp;double speedy,k=0,o;TextView tl;
    protected void onCreate(Bundle coong) {
        super.onCreate(coong);
        setContentView(com.sathi.android.sathiapp.R.layout.activity_main);
        b1=(Button)findViewById(com.sathi.android.sathiapp.R.id.button);
        final SharedPreferences sharedPreferences=getSharedPreferences("kukur", Context.MODE_PRIVATE);
        e1=(EditText)findViewById(com.sathi.android.sathiapp.R.id.editText);
        pass=sharedPreferences.getString("password", "");lp="";
        if(pass.equals(lp)){
     e1.setInputType(InputType.TYPE_CLASS_NUMBER);
      e1.setHint("Enter Friend's Mobile Number");

            b1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    n = e1.getText().toString();
                    final SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("number", n);
                    editor.commit();


                    final AlertDialog alertDialog = new AlertDialog.Builder(
                            MainActivity.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Mobile Number Set");

                    // Setting Dialog Message

                    alertDialog.setMessage("The mobile number has been set. Now enter speed limit.");

                    // Setting Icon to Dialog
                    alertDialog.setIcon(com.sathi.android.sathiapp.R.drawable.sathilogo);

                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed
                            Intent k = new Intent("com.sathi.android.sathiapp.Starter");
                            startActivity(k);
finish();
                        }
                    }); alertDialog.show();
}});

                }
else{
            b1.setOnClickListener(new View.OnClickListener()

                                  {
                                      public void onClick(View v) {
                                          n = e1.getText().toString();
                                          if (n.equals(pass)) {
                                              Intent intent = new Intent("com.sathi.android.sathiapp.SETTINGS");
                                              startActivity(intent);
                                              finish();
                                          } else {
                                              AlertDialog alertDialog = new AlertDialog.Builder(
                                                      MainActivity.this).create();

                                              // Setting Dialog Title
                                              alertDialog.setTitle("Wrong Password");

                                              // Setting Dialog Message
                                              alertDialog.setMessage("The password you have entered is wrong.");

                                              // Setting Icon to Dialog
                                              alertDialog.setIcon(com.sathi.android.sathiapp.R.drawable.sathilogo);

                                              // Setting OK Button
                                              alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                                  public void onClick(DialogInterface dialog, int which) {
                                                      // Write your code here to execute after dialog closed
                                                      finish();
                                                  }
                                              });

                                              // Showing Alert Message
                                              alertDialog.show();

                                          }
                                      }
                                  }

            );
        }}}