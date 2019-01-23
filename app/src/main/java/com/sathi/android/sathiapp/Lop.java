package com.sathi.android.sathiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Anand on 30-08-2015.
 */
public class Lop extends Activity {
    Button butto;protected void onCreate(Bundle autt) {
        super.onCreate(autt);
        setContentView(R.layout.lop);
       butto= (Button)findViewById(R.id.button15);
        TextView textView =(TextView)findViewById(R.id.textView21);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "© 2015<a href='http://www.sathiapp.com/support/'> SathiApp Support </a>";
        textView.setText(Html.fromHtml(text));
        butto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                //turnGPSOn();
                finish();
            }
        });

    }

}