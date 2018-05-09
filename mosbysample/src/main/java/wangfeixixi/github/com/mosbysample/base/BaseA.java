package wangfeixixi.github.com.mosbysample.base;

import android.os.Bundle;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import butterknife.ButterKnife;

public abstract class BaseA<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onCreateView());
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    protected abstract int onCreateView();
    protected abstract void init(Bundle savedInstanceState);
}
