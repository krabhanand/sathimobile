package com.sathi.android.sathiapp;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

public class UNinstall extends DeviceAdminReceiver {

    @Override
    public void onDisabled(Context context, Intent intent) {
        // TODO Auto-generated method stub
        super.onDisabled(context, intent);
    }

    @Override
    public void onEnabled(Context context, Intent intent) {
        // TODO Auto-generated method stub
        super.onEnabled(context,intent);
    }
}
