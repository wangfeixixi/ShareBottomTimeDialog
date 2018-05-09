package wangfeixixi.github.com.mosbysample.f;

import android.support.annotation.NonNull;
import android.util.Log;

import wangfeixixi.github.com.mosbysample.base.BaseF;

/**
 * Created by xuany on 2018/5/9.
 */

public class BFragment extends BaseF<BView, BPresent> implements BView {
    private String TAG = "BFragment";


    @Override
    protected void onUserVisible(boolean isVisible) {

        Log.d(TAG, "onUserVisible" + isVisible);
    }

    @Override
    protected void initView() {

        tv_name.setText("BFragment");
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
}
