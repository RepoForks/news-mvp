package me.topas.rssreader.chrome;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by faruktoptas on 29/01/17.
 */

@Module
public class ChromeTabsWrapperModule {

    private Context mContext;

    public ChromeTabsWrapperModule(Context context) {
        mContext = context;
    }

    @Provides
    ChromeTabsWrapper providesChromeTabsWrapper() {
        return new ChromeTabsWrapper(mContext);
    }

}
