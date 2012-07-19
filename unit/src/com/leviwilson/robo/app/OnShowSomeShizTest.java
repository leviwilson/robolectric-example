package com.leviwilson.robo.app;

import static org.mockito.Mockito.verify;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;

@RunWith(RoboExampleTestRunner.class)
public class OnShowSomeShizTest {
    
    @Mock MainActivity mainActivity;
    
    @Test
    public void itDisplaysDialog123WhenClicked() {
        final OnShowSomeShiz sut = new OnShowSomeShiz(mainActivity);
        
        sut.onClick(null);
        
        verify(mainActivity).showDialog(123);
    }
}
