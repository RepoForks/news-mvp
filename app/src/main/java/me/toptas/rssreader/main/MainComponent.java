package me.toptas.rssreader.main;

import dagger.Component;
import me.toptas.rssreader.chrome.ChromeTabsWrapperModule;

@Component(modules = {MainModule.class, ChromeTabsWrapperModule.class})
public interface MainComponent {

    void inject(MainActivity obj);

}