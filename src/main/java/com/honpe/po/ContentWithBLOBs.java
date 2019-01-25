package com.honpe.po;

public class ContentWithBLOBs extends Content {
    private String content;

    private String enContent;

    private String jpContent;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getEnContent() {
        return enContent;
    }

    public void setEnContent(String enContent) {
        this.enContent = enContent == null ? null : enContent.trim();
    }

    public String getJpContent() {
        return jpContent;
    }

    public void setJpContent(String jpContent) {
        this.jpContent = jpContent == null ? null : jpContent.trim();
    }
}