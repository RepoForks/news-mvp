package me.toptas.rssreader.model;

/**
 * Created by ftoptas on 29/01/17.
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
