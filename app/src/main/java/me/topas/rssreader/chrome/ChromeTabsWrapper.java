package me.topas.rssreader.chrome;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v4.content.ContextCompat;

import me.topas.rssreader.R;

/**
 * Created by faruktoptas on 29/01/17.
 */

public class ChromeTabsWrapper {

    private static final String CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";

    private Context mContext;
    private CustomTabsSession mCustomTabsSession;
    private CustomTabsServiceConnection mConnection;
    private CustomTabsClient mClient;

    public ChromeTabsWrapper(Context context) {
        mContext = context;
    }


    public void openCustomtab(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(mContext, Uri.parse(url));
    }

    public void bindCustomTabsService() {
        if (mClient != null) return;

        mConnection = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
                mClient = client;
                mClient.warmup(0);
                if (mCustomTabsSession == null) {
                    mCustomTabsSession = mClient.newSession(new CustomTabsCallback());
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        boolean ok = CustomTabsClient.bindCustomTabsService(mContext, CUSTOM_TAB_PACKAGE_NAME, mConnection);
    }

    public void unbindCustomTabsService() {
        if (mConnection == null) return;
        mContext.unbindService(mConnection);
        mClient = null;
        mCustomTabsSession = null;
    }
}
