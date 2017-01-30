package me.topas.rssreader.rss;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ftopas on 29/01/17.
 */

@Module
public class RssModule {

    @Provides
    RssPresenter providesRssPresenter() {
        return new RssPresenter();
    }
}
