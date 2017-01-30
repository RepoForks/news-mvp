package me.topas.rssreader.rss;

import dagger.Component;

/**
 * Created by ftopas on 29/01/17.
 */

@Component(modules = {RssModule.class})
public interface RssComponent {

    void inject(RssFragment obj);

}



