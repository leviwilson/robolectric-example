package com.leviwilson.robo.app;

import static com.leviwilson.robo.app.ViewHelper.setTextTo;


import android.app.*;
import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

import com.leviwilson.robo.app.R.id;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(id.toggle_greeting).setOnClickListener(new ToggleGreetingOnClick());

        Application normalApplication = getApplication();
        RoboExampleApp app = (RoboExampleApp) normalApplication;
        final WidgetLoader loader = app.instanceOf(WidgetLoader.class);

        final ListView widgetsList = ViewHelper.findFor(this, id.widgets_list);
        widgetsList.setAdapter(new WidgetAdapter(getApplicationContext(), loader.load()));

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
