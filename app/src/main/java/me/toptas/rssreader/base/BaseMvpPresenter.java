package me.toptas.rssreader.base;

/**
 * Created by ftoptas on 04/02/17.
 */

public interface BaseMvpPresenter<V extends BaseView> {

    void attach(V view);

    void detach();

    boolean isAttached();
}
