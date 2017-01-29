package me.topas.rssreader.main;

import dagger.Component;
import me.topas.rssreader.chrome.ChromeTabsWrapperModule;

@Component(modules = {MainModule.class, ChromeTabsWrapperModule.class})
public interface MainComponent {

    void inject(MainActivity obj);

}