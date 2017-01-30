package me.toptas.rssreader.main;

import me.toptas.rssreader.base.BaseView;

/**
 * Created by faruktoptas on 28/01/17.
 */

public interface MainContract {

    // User actions. Presenter will implement
    interface Presenter {
        void loadRssFragments();
    }

    // Action callbacks. Activity/Fragment will implement
    interface View extends BaseView {
        void onLoadRssFragments();
    }

}
