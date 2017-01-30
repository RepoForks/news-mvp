package me.toptas.rssreader.main;

import me.toptas.rssreader.base.BasePresenter;

/**
 * Created by faruktoptas on 28/01/17.
 */

public class MainPresenter extends BasePresenter<me.toptas.rssreader.main.MainContract.View> implements me.toptas.rssreader.main.MainContract.Presenter {

    @Override
    public void loadRssFragments() {
        mView.onLoadRssFragments();
    }
}
