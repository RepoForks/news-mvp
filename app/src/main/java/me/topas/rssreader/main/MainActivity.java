package me.topas.rssreader.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import me.topas.rssreader.R;
import me.topas.rssreader.base.BaseActivity;
import me.topas.rssreader.chrome.ChromeTabsWrapper;
import me.topas.rssreader.chrome.ChromeTabsWrapperModule;
import me.topas.rssreader.model.Feed;
import me.topas.rssreader.model.RError;
import me.topas.rssreader.model.RssItem;
import me.topas.rssreader.rss.RssFragment;
import me.topas.rssreader.rss.RssFragmentAdapter;
import me.topas.rssreader.util.FeedParser;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, RssFragment.OnItemSelectListener {


    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.tablayout)
    TabLayout mTabLayout;

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar mToolbar;

    @Inject
    ChromeTabsWrapper mChromeTabsWrapper;


    @Override
    protected int getContentResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(@Nullable Bundle state) {
        setSupportActionBar(mToolbar);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        getPresenter().loadRssFragments();
    }

    @Override
    public void injectDependencies() {
        DaggerMainComponent.builder()
                .mainModule(new MainModule())
                .chromeTabsWrapperModule(new ChromeTabsWrapperModule(this))
                .build()
                .inject(this);

    }

    @Override
    public void onLoadRssFragments() {
        setUpViewPager();
    }


    @Override
    protected void onStart() {
        super.onStart();
        mChromeTabsWrapper.bindCustomTabsService();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mChromeTabsWrapper.unbindCustomTabsService();
    }




    @Override
    public void onFail(RError rError) {

    }

    @Override
    public void onItemSelected(RssItem rssItem) {
        mChromeTabsWrapper.openCustomtab(rssItem.getUrl());
    }

    private void setUpViewPager() {
        List<RssFragment> fragmentList = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (Feed feed : new FeedParser().parseFeeds(this)) {
            fragmentList.add(RssFragment.newInstance(feed));
            titles.add(feed.getTitle());
        }

        RssFragmentAdapter adapter = new RssFragmentAdapter(getSupportFragmentManager(), fragmentList, titles);
        mViewPager.setAdapter(adapter);
    }

    private void setupTabbar() {

    }
}
