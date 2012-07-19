package com.leviwilson.robo.app;

import android.view.View;
import android.view.View.OnClickListener;

final class OnShowSomeShiz implements OnClickListener {
    
    private final MainActivity mainActivity;

    OnShowSomeShiz(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        this.mainActivity.showDialog(123);
    }
}