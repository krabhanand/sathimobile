package com.sathi.android.sathiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.widget.TextView;

/**
 * Created by Anand on 11-08-2015.
 */
public class PwdNum extends Activity {
EditText et,et1,et2;String mpass,no,pass,nno,ono;Button b6;
    protected void onCreate(Bundle pad) {
    super.onCreate(pad);
    setContentView(com.sathi.android.sathiapp.R.layout.pwdnum);

        et1=(EditText)findViewById(com.sathi.android.sathiapp.R.id.editText5);
        et2=(EditText)findViewById(com.sathi.android.sathiapp.R.id.editText6);
       final SharedPreferences sharedPreferences=getSharedPreferences("kukur", Context.MODE_PRIVATE);
        TextView textView =(TextView)findViewById(com.sathi.android.sathiapp.R.id.textView21);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "© 2015<a href='http://www.sathiapp.com/support/'> SathiApp Support </a>";
        textView.setText(Html.fromHtml(text));
        no=sharedPreferences.getString("number", "");b6=(Button)findViewById(com.sathi.android.sathiapp.R.id.button6);
        b6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

        nno=et2.getText().toString();
        ono=et1.getText().toString();
        if(ono.equals(no))
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("number",nno);
            editor.commit();
            final SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("+91" + ono, null, "Message From Sathi App: The mobile number has been changed to " + nno, null, null);
            AlertDialog alertDialog = new AlertDialog.Builder(
                    PwdNum.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("Number Changed");

            // Setting Dialog Message
            alertDialog.setMessage("The mobile number has been successfully changed.");

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

        else if(!ono.equals(no))
        {
            AlertDialog alertDialog = new AlertDialog.Builder(
                    PwdNum.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("Number Mismatch");

            // Setting Dialog Message
            alertDialog.setMessage("The old number you have entered does not match.");

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
        }}});

}
}
