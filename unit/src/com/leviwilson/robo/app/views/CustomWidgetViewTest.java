package com.leviwilson.robo.app.views;

import static com.leviwilson.robo.app.ViewHelper.*;
import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.*;
import org.junit.runner.RunWith;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.leviwilson.robo.app.R.id;
import com.leviwilson.robo.app.R.layout;
import com.leviwilson.robo.app.*;
import com.leviwilson.robo.app.models.Widget;

@RunWith(RoboExampleTestRunner.class)
public class CustomWidgetViewTest {
    
    TestWidgetActivity activity;
    
    @Before
    public void setUp() {
        activity = new TestWidgetActivity();
        shadowOf(activity).create();
    }
    
    @Test
    public void itHasTheWidgetLogo() {
        final ImageView widgetLogo = findFor(activity, id.widget_image);
        assertThat(widgetLogo, is(notNullValue()));
    }
    
    @Test
    public void theWidgetCanBeSetAndGotten() {
        final Widget expectedWidget = new Widget();
        final CustomWidgetView theWidgetView = theWidgetView();
        
        theWidgetView.setWidget(expectedWidget);
        
        assertThat(theWidgetView.getWidget(), is(sameInstance(expectedWidget)));
    }
    
    @Test
    public void itDisplaysTheWidgetsTextualInformation() {
        final Widget theWidget = new Widget("The Widget Name");
        final CustomWidgetView theWidgetView = theWidgetView();
        
        theWidgetView.setWidget(theWidget);
        
        assertThat(textOf(theWidgetView, id.widget_name), is("The Widget Name"));
    }

    private CustomWidgetView theWidgetView() {
        final CustomWidgetView theWidgetView = findFor(activity, id.custom_widget_item);
        return theWidgetView;
    }
    
    private class TestWidgetActivity extends Activity {
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(layout.widget_item);
        }
    }

}
