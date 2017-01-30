package me.topas.rssreader.rss;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import me.topas.rssreader.app.DaggerAppComponent;
import me.topas.rssreader.app.SessionData;
import me.topas.rssreader.base.BasePresenter;
import me.topas.rssreader.base.Logger;
import me.topas.rssreader.model.Feed;
import me.topas.rssreader.model.RError;
import me.topas.rssreader.model.RssItem;
import me.topas.rssreader.parser.OnRssParserListener;
import me.topas.rssreader.parser.RssReader;

/**
 * Created by ftopas on 29/01/17.
 */

public class RssPresenter extends BasePresenter<RssContract.View> implements RssContract.Presenter, OnRssParserListener {

    @Singleton
    @Inject
    SessionData mSessionData;

    public RssPresenter() {
        DaggerAppComponent.create().inject(this);
    }

    @Override
    public void loadRssItems(Feed feed, boolean fromCache) {
        if (mSessionData.hasUrl(feed.getUrl()) && fromCache) {
            Logger.logv("Read from cache: " + feed.getUrl());
            mView.onRssItemsLoaded(mSessionData.getContentMap().get(feed.getUrl()));
        } else {
            RssReader request = new RssReader(this, feed.getUrl());
            request.execute();
            mView.showLoading();
        }
    }

    @Override
    public void browseRssUrl(RssItem rssItem) {
        if (isAttached()) {
            mView.onBrowse(rssItem);
        }
    }

    @Override
    public void onSuccess(List<RssItem> rssItemList, String rssUrl) {
        mSessionData.getContentMap().put(rssUrl, rssItemList);
        if (isAttached()) {
            mView.onRssItemsLoaded(rssItemList);
            mView.hideLoading();
        }
    }

    @Override
    public void onFail(String rssUrl) {
        if (isAttached()) {
            mView.hideLoading();
            mView.onFail(new RError("Failed to fetch RSS!"));
        }
    }
}
