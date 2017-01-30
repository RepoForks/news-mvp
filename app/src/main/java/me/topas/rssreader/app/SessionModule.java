package me.topas.rssreader.app;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SessionModule {

    @Provides
    @Singleton
    SessionData providesSessionData() {
        return new SessionData();
    }


}