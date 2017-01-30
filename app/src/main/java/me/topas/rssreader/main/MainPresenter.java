package me.topas.rssreader.main;

import me.topas.rssreader.base.BasePresenter;

/**
 * Created by faruktopas on 28/01/17.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Override
    public void loadRssFragments() {
        mView.onLoadRssFragments();
    }
}
