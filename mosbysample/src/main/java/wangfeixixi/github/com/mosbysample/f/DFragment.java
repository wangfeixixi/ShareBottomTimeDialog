package wangfeixixi.github.com.mosbysample.f;

import android.support.annotation.NonNull;
import android.util.Log;

import wangfeixixi.github.com.mosbysample.base.BaseF;

/**
 * Created by xuany on 2018/5/9.
 */

public class DFragment extends BaseF<DView, DPresent> implements DView {
    private String TAG = "DFragment";

    @Override
    protected void onUserVisible(boolean isVisible) {

        Log.d(TAG, "onUserVisible" + isVisible);
    }

    @Override
    protected void initView() {

        getTv_name().setText("DFragment");
    }

    @Override
    protected void initData(boolean firstLoad, boolean isVisibleToUser) {

        Log.d(TAG, "firstLoad" + firstLoad + "isVisibleToUser" + isVisibleToUser);
    }


    @NonNull
    @Override
    public DPresent createPresenter() {
        return new DPresent();
    }
}
