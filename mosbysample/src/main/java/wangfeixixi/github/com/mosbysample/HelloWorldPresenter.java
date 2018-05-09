package wangfeixixi.github.com.mosbysample;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import wangfeixixi.github.com.mosbysample.base.BaseP;

public class HelloWorldPresenter extends BaseP<HelloWorldView> {


    public void setOk() {
        getView().showGoodbye("aaaaaa");
    }


    public void setNo() {
        getView().showHello("setNo");
    }
}
