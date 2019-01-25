package com.honpe.po;

public class EmailTemplateWithBLOBs extends EmailTemplate {
    private String context;

    private String attachment;

    private String receivers;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getReceivers() {
        return receivers;
    }

    public void setReceivers(String receivers) {
        this.receivers = receivers == null ? null : receivers.trim();
    }
}