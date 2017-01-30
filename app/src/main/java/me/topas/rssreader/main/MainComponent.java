package me.toptas.rssreader.main;

import javax.inject.Singleton;

import dagger.Component;
import me.toptas.rssreader.chrome.ChromeTabsWrapperModule;

@Singleton
@Component(modules = {MainModule.class, ChromeTabsWrapperModule.class})
public interface MainComponent {

    void inject(MainActivity obj);

}