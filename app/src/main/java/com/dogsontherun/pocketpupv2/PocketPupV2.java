package com.dogsontherun.pocketpupv2;

import android.app.Application;
import android.content.res.Configuration;

import com.parse.Parse;
import com.parse.ParseCrashReporting;
import com.parse.ParseObject;

/**
 * Created by Stelzy on 5/7/2015.
 */
public class PocketPupV2 extends Application {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Crash Reporting
        ParseCrashReporting.enable(this);

        // Enable Local Datastore with Parse
        Parse.enableLocalDatastore(this);

        // Register Subclasses
        ParseObject.registerSubclass(HomeAddressPO.class);
        ParseObject.registerSubclass(EmergencyContactPO.class);
        ParseObject.registerSubclass(BillingInfoPO.class);
        ParseObject.registerSubclass(PetPO.class);
        ParseObject.registerSubclass(ServiceWalkingRunningPO.class);

        // Initialize Parse application
        Parse.initialize(this, "mkZrMJ7f1fM05vVxaufUkIviQUIU3dYtVwRpd0sW", "bhxZD3DnsAdbw83nhoTHXaYqLJJB4XkWAzByK8CL");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}