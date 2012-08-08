package com.leviwilson.robo.app;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class ViewHelper {

    public static String textOf(Activity activity, int id) {
        final TextView textView = (TextView) activity.findViewById(id);
        return textView.getText().toString();
    }

    public static String textOf(final View view, int id) {
        final TextView textView = (TextView) view.findViewById(id);
        return textView.getText().toString();
    }

    public static void clickOn(Activity activity, int id) {
        activity.findViewById(id).performClick();
    }

    public static void setTextTo(Activity activity, int id, String text) {
        final TextView textView = (TextView) activity.findViewById(id);
        textView.setText(text);
    }

    public static void setTextTo(View view, int id, String text) {
        final TextView textView = (TextView) view.findViewById(id);
        textView.setText(text);
    }

    @SuppressWarnings("unchecked")
    public static <ViewType> ViewType findFor(Activity activity, int id) {
        return (ViewType) activity.findViewById(id);
    }

}
