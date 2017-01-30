package me.toptas.rssreader.main;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    MainPresenter providesMainPresenter() {
        return new MainPresenter();
    }
}