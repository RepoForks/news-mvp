package me.toptas.rssreader.rss;

import java.util.List;

import me.toptas.rssreader.base.BaseMvpPresenter;
import me.toptas.rssreader.base.BaseView;
import me.toptas.rssreader.model.Feed;
import me.toptas.rssreader.model.RssItem;

/**
 * Created by ftoptas on 29/01/17.
 */

public interface RssContract {

    // User actions. Presenter will implement
    interface Presenter extends BaseMvpPresenter<RssContract.View>{
        void loadRssItems(Feed feed, boolean fromCache);
        void browseRssUrl(RssItem rssItem);
    }

    // Action callbacks. Activity/Fragment will implement
    interface View extends BaseView {
        void showLoading();
        void hideLoading();
        void onRssItemsLoaded(List<RssItem> rssItems);
        void onBrowse(RssItem rssItem);
    }
}
