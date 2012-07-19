package com.leviwilson.robo.app;

import java.util.HashMap;

import com.leviwilson.robo.app.models.WidgetLoader;

import android.app.Application;

public class RoboExampleApplication extends Application {
    
    private HashMap<Class<?>, Object> objectContainer = new HashMap<Class<?>, Object>();
    
    public RoboExampleApplication() {
        setSingletonInstance(WidgetLoader.class, new WidgetLoader());
    }

    public void setSingletonInstance(Class<?> clazz, final Object instance) {
        objectContainer.put(clazz, instance);
    }
    
    @SuppressWarnings("unchecked")
    public <InstanceType> InstanceType instanceOf(Class<?> clazz) {
        return (InstanceType) objectContainer.get(clazz);
    }

}
