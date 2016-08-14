package com.install.wallapopcomics;

import android.app.Application;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest(Class<Application> applicationClass) {
        super(applicationClass);
    }

    @MediumTest
    @RunWith(AndroidJUnit4.class)
    public class ExampleInstrumentationTest {
        @Test
        public void useAppContext() throws Exception {
            // Context of the app under test.
            Context appContext = InstrumentationRegistry.getTargetContext();

            //Check package name
            assertEquals("com.install.wallacomics", appContext.getPackageName());
        }
    }
}