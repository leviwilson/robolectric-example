package com.leviwilson.robo.app;

import java.util.HashMap;

import android.app.Application;

public class RoboExampleApp extends Application {
    
    private HashMap<Class<?>, Object> objectContainer = new HashMap<Class<?>, Object>();

    public void setSingletonInstance(Class<?> clazz, Object instance) {
        objectContainer.put(clazz, instance);
    }
    
    @SuppressWarnings("unchecked")
    public <InstanceType> InstanceType instanceOf(Class<?> clazz) {
        return (InstanceType) objectContainer.get(clazz);
    }

}
