package wangfeixixi.github.com.mosbysample.f;

import android.support.annotation.NonNull;
import android.util.Log;

import wangfeixixi.github.com.mosbysample.base.BaseF;

/**
 * Created by xuany on 2018/5/9.
 */

public class AFragment extends BaseF<AView, APresent> implements AView {
    private String TAG = "AFragment";

    @Override
    protected int initContentRes() {
        return 0;
    }

    @Override
    protected void initView() {

        tv_name.setText(TAG);
    }

    @Override
    protected void initData(boolean firstLoad, boolean isVisibleToUser) {
        Log.d(TAG, "firstLoad" + firstLoad + "isVisibleToUser" + isVisibleToUser);
        presenter.asdfas();
    }

    @NonNull
    @Override
    public APresent createPresenter() {
        return new APresent();
    }
}
