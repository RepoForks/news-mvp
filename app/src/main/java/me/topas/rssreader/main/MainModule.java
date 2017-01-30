package me.toptas.rssreader.main;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    @Singleton
    MainPresenter providesMainPresenter() {
        return new MainPresenter();
    }

}