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
 * Created by Anand on 09-09-2015.
 */
public class Pwdspeed extends Activity {
    EditText et,et1;String pass,sp,no,p;Button b6,b7;
    protected void onCreate(Bundle setsp) {
        super.onCreate(setsp);
        setContentView(com.sathi.android.sathiapp.R.layout.setspeed);
        et=(EditText)findViewById(com.sathi.android.sathiapp.R.id.editText16);
        final SharedPreferences sharedPreferences=getSharedPreferences("kukur", Context.MODE_PRIVATE);
        pass=sharedPreferences.getString("password", "");
        TextView textView =(TextView)findViewById(com.sathi.android.sathiapp.R.id.textView21);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "© 2015<a href='http://www.sathiapp.com/support/'> SathiApp Support </a>";
        textView.setText(Html.fromHtml(text));
        no=sharedPreferences.getString("number", "");b6=(Button)findViewById(com.sathi.android.sathiapp.R.id.button18);
        b6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                    sp=et.getText().toString();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("speed", sp);
                    editor.commit();
                    final SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("+91" + no, null, "Message From Sathi App: The speed limit has been set to "+sp+"", null, null);
                AlertDialog alertDialog = new AlertDialog.Builder(
                        Pwdspeed.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("Speed Changed");

                // Setting Dialog Message
                alertDialog.setMessage("The speed limit has been successfully changed.");

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

               }});

    }
}

