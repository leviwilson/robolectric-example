package com.leviwilson.robo.app;

import java.util.List;

import android.content.Context;
import android.view.*;
import android.widget.ArrayAdapter;

import com.leviwilson.robo.app.R.layout;
import com.leviwilson.robo.app.models.Widget;

class WidgetAdapter extends ArrayAdapter<Widget> {
    
    public WidgetAdapter(Context context, final List<Widget> widgets) {
        super(context, layout.widget_item, widgets);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View theView = null;
        
        if( null == theView ) {
            final LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            theView = inflater.inflate(layout.widget_item, null);
        }
        
        return theView;
    }
}