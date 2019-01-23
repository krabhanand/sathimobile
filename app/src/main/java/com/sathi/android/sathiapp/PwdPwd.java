package com.sathi.android.sathiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Anand on 14-08-2015.
 */
public class PwdPwd extends Activity {
    Button b7,b71;EditText et1,et2,et3;String pwd,opwd,npwd,cnpwd,nm;
    protected void onCreate(Bundle pada) {
        super.onCreate(pada);setContentView(com.sathi.android.sathiapp.R.layout.pwdpwd);
  b7=(Button)findViewById(com.sathi.android.sathiapp.R.id.button7);
        et2=(EditText)findViewById(com.sathi.android.sathiapp.R.id.editText3);
        et3=(EditText)findViewById(com.sathi.android.sathiapp.R.id.editText4);
        b7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                npwd = et2.getText().toString();
                cnpwd = et3.getText().toString();
                if(npwd.equals(cnpwd)){
                SharedPreferences sharedPreferences = getSharedPreferences("kukur", Context.MODE_PRIVATE);
               nm= sharedPreferences.getString("number","");
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("password",npwd);
                    editor.commit();
                    TextView textView =(TextView)findViewById(com.sathi.android.sathiapp.R.id.textView21);
                    textView.setClickable(true);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    String text = "© 2015<a href='http://www.sathiapp.com/support/'> SathiApp Support </a>";
                    textView.setText(Html.fromHtml(text));
                    final SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("+91" + nm, null, "Message from Sathi App: The password has been changed to " + npwd+"", null, null);

                    AlertDialog alertDialog = new AlertDialog.Builder(
                            PwdPwd.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Password Changed");

                    // Setting Dialog Message
                    alertDialog.setMessage("The password has been successfully changed.");

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

                else if(!npwd.equals(cnpwd))
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(
                            PwdPwd.this).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Password Mismatch");

                    // Setting Dialog Message
                    alertDialog.setMessage("The password and the confirmed password must be the same");

                    // Setting Icon to Dialog
                    alertDialog.setIcon(com.sathi.android.sathiapp.R.drawable.sathilogo);

                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed

                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();
                }
            }
            });
}}