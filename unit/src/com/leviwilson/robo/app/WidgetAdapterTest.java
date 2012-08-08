package com.leviwilson.robo.app;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.content.Context;
import android.view.*;

import com.leviwilson.robo.app.R.layout;
import com.leviwilson.robo.app.models.Widget;

@RunWith(RoboExampleTestRunner.class)
public class WidgetAdapterTest {
    
    WidgetAdapter adapter;
    
    @Mock Context context;
    @Mock LayoutInflater inflater;
    @Mock View view;

    private List<Widget> widgets;
    
    @Before
    public void setUp() {
        widgets = Arrays.asList(new Widget());
        adapter = new WidgetAdapter(context, widgets);
        
        when(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
            .thenReturn(inflater);
        
        when(inflater.inflate(anyInt(), (ViewGroup)any()))
            .thenReturn(view);
    }
    
    @Test
    public void itCanReturnAView() {
        assertThat(adapter.getView(0,  null, null), is(notNullValue()));
    }
    
    @Test
    public void itAlwaysInflatesCustomWidgets() {
        adapter.getView(0, null, null);
        
        verify(inflater).inflate(layout.widget_item, null);
    }
    
}
