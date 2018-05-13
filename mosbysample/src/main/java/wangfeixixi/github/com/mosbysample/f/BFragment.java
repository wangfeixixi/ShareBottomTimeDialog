package wangfeixixi.github.com.mosbysample.f;

import android.support.annotation.NonNull;
import android.util.Log;

import wangfeixixi.github.com.mosbysample.base.BaseF;

public class BFragment extends BaseF<BView, BPresent> implements BView {
    private String TAG = "BFragment";

    @Override
    protected void initView() {

        getTv_name().setText("BFragment");
    }

    @Override
    protected void initData(boolean firstLoad, boolean isVisibleToUser) {

        Log.d(TAG, "firstLoad" + firstLoad + "isVisibleToUser" + isVisibleToUser);
    }

    @NonNull
    @Override
    public BPresent createPresenter() {
        return new BPresent();
    }

    @Override
    protected int initContentRes() {
        return 0;
    }
}
