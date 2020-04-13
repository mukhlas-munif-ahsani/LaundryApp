package com.tiunida.laundry0.ActivitySetup.events;

import android.graphics.Bitmap;

public class SetupEvent {
    public static final int onInputError = 0;
    public static final int onInputSuccess = 1;
    public static final int onFIrestoreError = 2;

    private int eventType;
    private String errorMessage;
    private Bitmap image;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
