package com.leviwilson.robo.app;

import java.util.*;

import com.leviwilson.robo.app.models.Widget;

public class WidgetLoader {

    public List<Widget> load() {
        // fake widgets for the for realz app
        return Arrays.asList(new Widget("First Widget Name"), new Widget("Second Widget Name"));
    }

}
