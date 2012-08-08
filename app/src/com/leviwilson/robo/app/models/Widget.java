package com.leviwilson.robo.app.models;

public class Widget {
    
    private String name;

    public Widget() {
        name = "";
    }

    public Widget(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
