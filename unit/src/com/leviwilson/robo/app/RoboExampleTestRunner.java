package com.leviwilson.robo.app;

import java.io.File;

import org.junit.runners.model.InitializationError;
import org.mockito.MockitoAnnotations;

import android.app.Application;

import com.xtremelabs.robolectric.RobolectricTestRunner;

public class RoboExampleTestRunner extends RobolectricTestRunner {

    public RoboExampleTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass, new File("../app"));
    }
    
    @Override
    protected Application createApplication() {
        return new RoboExampleApplication();
    }
    
    @Override
    public Object createTest() throws Exception {
        Object theTest = super.createTest();
        MockitoAnnotations.initMocks(theTest);
        return theTest;
    }

}
