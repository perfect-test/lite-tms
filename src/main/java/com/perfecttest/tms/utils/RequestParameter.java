package com.perfecttest.tms.utils;

public class RequestParameter {
    private String name;
    private String value;

    public RequestParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public RequestParameter withName(final String name) {
        this.name = name;
        return this;
    }

    public RequestParameter withValue(final String value) {
        this.value = value;
        return this;
    }
}
