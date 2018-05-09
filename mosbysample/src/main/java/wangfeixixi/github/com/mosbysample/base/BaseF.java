package wangfeixixi.github.com.mosbysample.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import butterknife.BindView;
import butterknife.ButterKnife;
import wangfeixixi.github.com.mosbysample.R;

public abstract class BaseF<V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment {

    @BindView(R.id.tv_name)
    public TextView tv_name;

    private boolean isPrepared = false;
    private boolean firstLoad = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a_fragment, null);
        ButterKnife.bind(this, inflate);
        isPrepared = true;
        initView();

        lazyLoad();
        return inflate;
    }

    private void lazyLoad() {
        if (isPrepared) {
            if (getUserVisibleHint() && firstLoad) {
                initData(firstLoad, getUserVisibleHint());
                firstLoad = false;
                return;
            }
            initData(false, getUserVisibleHint());
        }
    }

    protected abstract void onUserVisible(boolean isVisible);

    protected abstract void initView();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    protected abstract void initData(boolean firstLoad, boolean isVisibleToUser);

    @NonNull
    public abstract P createPresenter();
}
