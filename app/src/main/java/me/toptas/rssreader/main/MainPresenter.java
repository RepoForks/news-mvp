package me.toptas.rssreader.main;

import java.util.Random;

import me.toptas.rssreader.base.BasePresenter;

/**
 * Created by faruktoptas on 28/01/17.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private String[] helloTexts = {"BONJOUR", "HOLA", "HALLO", "MERHABA", "HELLO", "CIAO", "KONNICHIWA"};

    @Override
    public void loadHelloText() {
        Random random = new Random();
        String hello = helloTexts[random.nextInt(helloTexts.length)];
        mView.onTextLoaded(hello);
    }
}
