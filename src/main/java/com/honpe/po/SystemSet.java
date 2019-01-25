package com.honpe.po;

public class SystemSet {
    private String setKey;

    private String setValue;

    public String getSetKey() {
        return setKey;
    }

    public void setSetKey(String setKey) {
        this.setKey = setKey == null ? null : setKey.trim();
    }

    public String getSetValue() {
        return setValue;
    }

    public void setSetValue(String setValue) {
        this.setValue = setValue == null ? null : setValue.trim();
    }
}