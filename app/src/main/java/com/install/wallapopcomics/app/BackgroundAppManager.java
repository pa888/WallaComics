package com.install.wallapopcomics.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Peter on 07.08.2016.
 */
public class BackgroundAppManager {
    private ExecutorService executorService;

    public BackgroundAppManager() {
        executorService = Executors.newFixedThreadPool(8);
    }

    public Future executeTask(Runnable runnable) {
        return executorService.submit(runnable);
    }
}
