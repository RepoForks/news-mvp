package me.toptas.rssreader.rss;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import me.toptas.rssreader.app.DaggerAppComponent;
import me.toptas.rssreader.app.SessionData;
import me.toptas.rssreader.base.BasePresenter;
import me.toptas.rssreader.base.Logger;
import me.toptas.rssreader.model.Feed;
import me.toptas.rssreader.model.RError;
import me.toptas.rssreader.model.RssItem;
import me.toptas.rssreader.parser.OnRssParserListener;
import me.toptas.rssreader.parser.RssReader;

/**
 * Created by ftoptas on 29/01/17.
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
