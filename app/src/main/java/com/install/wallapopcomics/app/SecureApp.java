package com.install.wallapopcomics.app;

import android.app.Application;
import android.text.TextUtils;

/**
 * Created by Peter on 14.08.2016.
 */
public class SecureApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (!TextUtils.equals("com.install.wallacomics",getPackageName())) {
            throw new IllegalStateException("Not correct package");
        }
    }
}
