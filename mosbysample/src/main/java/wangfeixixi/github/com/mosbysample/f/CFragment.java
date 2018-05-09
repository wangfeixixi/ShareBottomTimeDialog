package wangfeixixi.github.com.mosbysample.f;

import android.support.annotation.NonNull;
import android.util.Log;

import wangfeixixi.github.com.mosbysample.base.BaseF;

/**
 * Created by xuany on 2018/5/9.
 */

public class CFragment extends BaseF<CView, CPresent> implements CView {
    private String TAG = "CFragment";

    @Override
    protected void onUserVisible(boolean isVisible) {

        Log.d(TAG, "onUserVisible" + isVisible);
    }

    @Override
    protected void initView() {

        tv_name.setText("CFragment");
    }

    @Override
    protected void initData(boolean firstLoad, boolean isVisibleToUser) {

        Log.d(TAG, "firstLoad" + firstLoad + "isVisibleToUser" + isVisibleToUser);
    }


    @NonNull
    @Override
    public CPresent createPresenter() {
        return new CPresent();
    }
}
