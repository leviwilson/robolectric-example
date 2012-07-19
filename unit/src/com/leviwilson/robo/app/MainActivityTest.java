package com.leviwilson.robo.app;

import static com.leviwilson.robo.app.ViewHelper.*;
import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.app.AlertDialog;
import android.widget.ListView;

import com.leviwilson.robo.app.R.id;
import com.leviwilson.robo.app.models.*;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.shadows.*;

@RunWith(RoboExampleTestRunner.class)
public class MainActivityTest {

    private MainActivity activity;
    
    @Mock private WidgetLoader loader;

    @Before
    public void setUp() {
        activity = new MainActivity();
        
        RoboExampleApplication application = (RoboExampleApplication) Robolectric.application;
        application.setSingletonInstance(WidgetLoader.class, loader);
    }

    @Test
    public void itProperlyGreetsUs() {
        createActivity();
        assertThat(textOf(activity, id.hello_world), is("Hello world!"));
    }

    @Test
    public void itCanToggleTheName() {
        createActivity();
        clickOn(activity, id.toggle_name);
        assertThat(textOf(activity, id.hello_world), is("Hello, Northwoods!"));
    }

    @Test
    public void itCanLoadWidgets() {
        createActivity();
        verify(loader).load();
    }
    
    @Test
    public void itCanListWidgetsLikeABoss() {
        setWidgetsToBe(new Widget(), new Widget());
        createActivity();
        
        final ListView widgetList = findFor(activity, id.widget_list);
        assertThat(widgetList.getCount(), is(2));
    }
    
    @Test
    public void itCanShowAnIndividualWidget() {
        Widget theWidget = new Widget();
        setWidgetsToBe(theWidget);
        createActivity();
        
        final ListView widgetList = findFor(activity, id.widget_list);
        widgetList.getOnItemClickListener().onItemClick(null, null, 0, 0);
        
        final String actualNewActivity = shadowOf(activity).getNextStartedActivity().getComponent().getClassName();
        assertThat(actualNewActivity, is(WidgetActivity.class.getName()));
    }
    
    @Test
    public void itCanAlertTheProperAuthorities() {
        createActivity();
        clickOn(activity, id.show_some_shiz);
        
        ShadowActivity shadowActivity = shadowOf(activity);
        final int lastShownDialogId = shadowActivity.getLastShownDialogId();
        final ShadowAlertDialog alertDialog = shadowOf((AlertDialog) shadowActivity.getDialogById(lastShownDialogId));;
        assertThat(alertDialog.getTitle().toString(), is("Some Shiz"));
        assertThat(alertDialog.getMessage(), is("Seriously, pay attention to this"));
    }

    private void createActivity() {
        shadowOf(activity).create();
    }

    private void setWidgetsToBe(Widget... widgets) {
        when(loader.load())
            .thenReturn(Arrays.asList(widgets));
    }

}
