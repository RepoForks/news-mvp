package me.toptas.rssreader.app;

import javax.inject.Singleton;

import dagger.Component;
import me.toptas.rssreader.rss.RssPresenter;

/**
 * Created by ftoptas on 29/01/17.
 */

@Singleton
@Component(modules = {SessionModule.class})
public interface AppComponent {

    void inject(RssPresenter obj);

}

