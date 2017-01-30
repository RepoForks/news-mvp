package me.topas.rssreader.app;

import java.util.HashMap;
import java.util.List;

import me.topas.rssreader.model.RssItem;

public class SessionData {
    private final HashMap<String, List<RssItem>> mContentMap = new HashMap<>();

    public HashMap<String, List<RssItem>> getContentMap() {
        return mContentMap;
    }


    public boolean hasUrl(String url) {
        return mContentMap.containsKey(url);
    }
}