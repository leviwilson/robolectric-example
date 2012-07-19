package com.leviwilson.robo.app;

import static com.leviwilson.robo.app.ViewHelper.setTextTo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

import com.leviwilson.robo.app.R.id;
import com.leviwilson.robo.app.R.layout;
import com.leviwilson.robo.app.models.Widget;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(id.toggle_greeting).setOnClickListener(new ToggleGreetingOnClick());
        
        RoboExampleApp app = (RoboExampleApp) getApplication();
        final WidgetLoader loader = app.instanceOf(WidgetLoader.class);
        
        final ListView widgetsList = ViewHelper.findFor(this, id.widgets_list);
        widgetsList.setAdapter(new ArrayAdapter<Widget>(getApplicationContext(), layout.widget_item, loader.load()));
        
        widgetsList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent = new Intent(getApplicationContext(), WidgetDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private final class ToggleGreetingOnClick implements OnClickListener {
        @Override
        public void onClick(View v) {
            setTextTo(MainActivity.this, id.hello_world, "Hello, Northwoods!");
        }
    }
    
}
