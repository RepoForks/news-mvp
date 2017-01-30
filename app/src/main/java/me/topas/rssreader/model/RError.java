package me.topas.rssreader.model;

/**
 * Created by ftopas on 29/01/17.
 */

public class RError {

    private final String mMessage;

    public RError(String message) {
        mMessage = message;
    }

    public String getMessage() {
        return mMessage;
    }
}
