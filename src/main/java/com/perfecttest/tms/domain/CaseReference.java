package com.perfecttest.tms.domain;

public class CaseReference {
    private String url;
    private String displayValue;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public CaseReference withUrl(final String url) {
        this.url = url;
        return this;
    }

    public CaseReference withDisplayValue(final String displayValue) {
        this.displayValue = displayValue;
        return this;
    }


}
