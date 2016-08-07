package com.install.wallapopcomics.app;

import android.app.Application;

/**
 * Created by Peter on 07.08.2016.
 */
public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        initAllModules();
    }

    private void initAllModules() {
        instance = this;
    }

    public static App getInstance(){
        return instance;
    }
}
