package me.toptas.rssreader.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    /**
     * Injected presenter
     */
    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResource());
        ButterKnife.bind(this);
        injectDependencies();
        mPresenter.attach(this);
        init(savedInstanceState);
    }

    /**
     * Detach presenter
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    /**
     * Getter for the presenter
     *
     * @return the present for the activity
     */
    protected T getPresenter() {
        return mPresenter;
    }

    /**
     * Layout resource to be inflated
     *
     * @return layout resource
     */
    @LayoutRes
    protected abstract int getContentResource();

    /**
     * Initializations
     */
    protected abstract void init(@Nullable Bundle state);

    /**
     * Injecting dependencies
     */
    protected abstract void injectDependencies();

}