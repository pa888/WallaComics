package com.install.wallapopcomics;

/**
 * Created by Peter on 07.08.2016.
 */

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Base class for Local Unit Tests
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        sdk = 21)
@Ignore
public class BaseTest {
    protected static TestUtils testUtils;

    /**
     * Common initialization of tests
     *
     * @throws Exception {@link ApiInterfaceTest} and another child can throw throws IOException
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testUtils = new TestUtils();
    }
}
