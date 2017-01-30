package me.toptas.rssreader.rss;

import dagger.Component;

/**
 * Created by ftoptas on 29/01/17.
 */

@Component(modules = {RssModule.class})
public interface RssComponent {

    void inject(RssFragment obj);

}



