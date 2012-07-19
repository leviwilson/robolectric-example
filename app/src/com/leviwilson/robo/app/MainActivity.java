package com.leviwilson.robo.app;

import static com.leviwilson.robo.app.ViewHelper.findFor;
import android.app.*;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

import com.leviwilson.robo.app.R.id;
import com.leviwilson.robo.app.R.layout;
import com.leviwilson.robo.app.models.*;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(id.toggle_name).setOnClickListener(new OnToggleNameListener());
        
        final ListView widgetList = findFor(this, id.widget_list);
        widgetList.setAdapter(new ArrayAdapter<Widget>(this, layout.widget_item, getLoader().load()));
        
        widgetList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final Intent intentToStart = new Intent(getApplicationContext(), WidgetActivity.class);
                startActivity(intentToStart);
            }
        });
        
        findViewById(id.show_some_shiz).setOnClickListener(new OnShowSomeShiz(this));
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder = new Builder(getApplicationContext());
        
        AlertDialog dialog = builder.setTitle("Some Shiz")
            .setMessage("Seriously, pay attention to this")
            .create();
        return dialog;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private WidgetLoader getLoader() {
        RoboExampleApplication application = (RoboExampleApplication) getApplication();
        final WidgetLoader loader = application.instanceOf(WidgetLoader.class);
        return loader;
    }

    private final class OnToggleNameListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            ViewHelper.setTextOf(MainActivity.this, id.hello_world, "Hello, Northwoods!");
        }
    }
    
}
