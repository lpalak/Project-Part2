package com.quickblox.sample.chat;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.quickblox.core.QBSettings;

public class ApplicationSingleton extends Application {
    private static final String TAG = ApplicationSingleton.class.getSimpleName();

    public static final String APP_ID = "24033";
    public static final String AUTH_KEY = "AZK9R4NMNRNJKDE";
    public static final String AUTH_SECRET = "4QSzkvb7ajWfQ5R";

    public static final String USER_LOGIN = "user1";
    public static final String USER_PASSWORD = "12345678";

    private static ApplicationSingleton instance;
    public static ApplicationSingleton getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate");

        instance = this;

        // Initialise QuickBlox SDK
        //
        QBSettings.getInstance().fastConfigInit(APP_ID, AUTH_KEY, AUTH_SECRET);
    }

    public int getAppVersion() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }
}
