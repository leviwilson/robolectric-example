package com.leviwilson.robo.app.views;

import static com.leviwilson.robo.app.ViewHelper.setTextTo;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.leviwilson.robo.app.R.id;
import com.leviwilson.robo.app.R.layout;
import com.leviwilson.robo.app.models.Widget;

public class CustomWidgetView extends LinearLayout {

    private Widget widget;

    public CustomWidgetView(Context context) {
        super(context);
        inflate(context);
    }

    public CustomWidgetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }
    
    private void inflate(final Context context) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(layout.view_custom_widget, this);
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
        
        setTextTo(this, id.widget_name, widget.getName());
    }

    public Widget getWidget() {
        return widget;
    }

}
