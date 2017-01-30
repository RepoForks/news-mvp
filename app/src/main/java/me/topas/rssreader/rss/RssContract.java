package me.topas.rssreader.rss;

import java.util.List;

import me.topas.rssreader.base.BaseView;
import me.topas.rssreader.model.Feed;
import me.topas.rssreader.model.RssItem;

/**
 * Created by ftopas on 29/01/17.
 */

public interface RssContract {

    // User actions. Presenter will implement
    interface Presenter {
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
