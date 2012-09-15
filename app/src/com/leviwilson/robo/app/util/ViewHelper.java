package com.leviwilson.robo.app.util;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class ViewHelper {
    
    @SuppressWarnings("unchecked")
    public static <ViewType> ViewType findFor(final Activity activity, final int id) {
        return (ViewType) activity.findViewById(id);
    }
    
    @SuppressWarnings("unchecked")
    public static <ViewType> ViewType findFor(final View view, final int id) {
        return (ViewType) view.findViewById(id);
    }
    
    public static String textOf(final Activity activity, final int id) {
        return text(activity, id).getText().toString();
    }
    
    public static String textOf(final View view, final int id) {
        return text(view, id).getText().toString();
    }
    
    public static void setText(final Activity activity, final int id, final String text) {
        text(activity, id).setText(text);
    }
    
    public static void setText(final View view, final int id, final String text) {
        text(view, id).setText(text);
    }

    private static TextView text(final Activity activity, final int id) {
        final TextView textView = findFor(activity, id);
        return textView;
    }

    private static TextView text(final View view, final int id) {
        final TextView textView = findFor(view, id);
        return textView;
    }

}
