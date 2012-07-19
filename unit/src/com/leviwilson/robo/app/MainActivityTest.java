package com.leviwilson.robo.app;

import static com.leviwilson.robo.app.ViewHelper.*;
import static com.leviwilson.test.matchers.StartedActivityMatcher.started;
import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.widget.ListView;

import com.leviwilson.robo.app.R.id;
import com.leviwilson.robo.app.models.Widget;
import com.xtremelabs.robolectric.Robolectric;

@RunWith(RoboExampleTestRunner.class)
public class MainActivityTest {
    
    private MainActivity activity;
    
    @Mock private WidgetLoader loader;
    
    @Before
    public void setUp() {
        activity = new MainActivity();
        
        RoboExampleApp app = (RoboExampleApp) Robolectric.application;
        app.setSingletonInstance(WidgetLoader.class, loader);
    }

    @Test
    public void itProperlyGreetsUs() {
        createActivity();
        assertThat(textOf(activity, id.hello_world), is("Hello world!"));
    }
    
    @Test
    public void itCanChangeTheGreeting() {
        createActivity();
        clickOn(activity, id.toggle_greeting);
        assertThat(textOf(activity, id.hello_world), is("Hello, Northwoods!"));
    }
    
    @Test
    public void itCanLoadWidgets() {
        createActivity();
        verify(loader).load();
    }
    
    @Test
    public void itCanListTheWidgets() {
        setWidgetsToBe(new Widget(), new Widget());
        createActivity();
        
        final ListView listView = findFor(activity, id.widgets_list);
        assertThat(listView.getCount(), is(2));
    }
    
    @Test
    public void itCanShowDetailsAboutAWidget() {
        int theFirstPosition = 0;
        setWidgetsToBe(new Widget());
        createActivity();
        
        selectWidgetAt(theFirstPosition);
        
        assertThat(activity, started(WidgetDetailsActivity.class));
    }

    private void createActivity() {
        shadowOf(activity).create();
    }

    private void setWidgetsToBe(Widget... widgets) {
        when(loader.load())
            .thenReturn(Arrays.asList(widgets));
    }

    private void selectWidgetAt(int index) {
        final ListView listView = findFor(activity, id.widgets_list);
        listView.getOnItemClickListener().onItemClick(null, null, index, index);
    }

}
