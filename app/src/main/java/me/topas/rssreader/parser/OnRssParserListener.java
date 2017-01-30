package me.topas.rssreader.parser;

import java.util.List;

import me.topas.rssreader.model.RssItem;

/**
 * Created by ftopas on 29/01/17.
 */

public interface OnRssParserListener {

    void onSuccess(List<RssItem> rssItemList, String rssUrl);

    void onFail(String rssUrl);
}
