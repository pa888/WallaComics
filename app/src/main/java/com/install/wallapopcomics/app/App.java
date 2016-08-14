package com.install.wallapopcomics.app;

import com.install.wallapopcomics.app.util.Constants;
import com.splunk.mint.Mint;

/**
 * Created by Peter on 07.08.2016.
 */
public class App extends SecureApp {
    private static App instance;
    private BackgroundAppManager backgroundAppManager;

    @Override
    public void onCreate() {
        super.onCreate();
        initAllModules();
    }

    private void initAllModules() {
        instance = this;
        Mint.initAndStartSession(this, Constants.MINT_KEY);
        Mint.disableNetworkMonitoring();
        backgroundAppManager = new BackgroundAppManager();
    }

    public BackgroundAppManager getBackgroundAppManager() {
        return backgroundAppManager;
    }

    public static App getInstance() {
        return instance;
    }
}
