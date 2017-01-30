package me.toptas.rssreader.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import me.toptas.rssreader.R;
import me.toptas.rssreader.base.BaseActivity;
import me.toptas.rssreader.chrome.ChromeTabsWrapper;
import me.toptas.rssreader.chrome.ChromeTabsWrapperModule;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.tvHello)
    TextView mTextView;

    @Inject
    ChromeTabsWrapper mChromeTabsWrapper;


    @Override
    protected int getContentResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(@Nullable Bundle state) {
        getPresenter().loadHelloText();
    }

    @Override
    public void injectDependencies() {
        DaggerMainComponent
                .builder()
                .mainModule(new MainModule())
                .chromeTabsWrapperModule(new ChromeTabsWrapperModule(this))
                .build()
                .inject(this);
    }


    @Override
    public void onTextLoaded(String text) {
        mTextView.setText(text);
    }

    @OnClick(R.id.tvHello)
    public void onClick() {
        getPresenter().loadHelloText();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mChromeTabsWrapper.bindCustomTabsService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mChromeTabsWrapper.unbindCustomTabsService();
    }
}
