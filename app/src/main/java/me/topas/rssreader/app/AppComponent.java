package me.topas.rssreader.app;

import javax.inject.Singleton;

import dagger.Component;
import me.topas.rssreader.rss.RssPresenter;

/**
 * Created by ftopas on 29/01/17.
 */

@Singleton
@Component(modules = {SessionModule.class})
public interface AppComponent {

    void inject(RssPresenter obj);

}

