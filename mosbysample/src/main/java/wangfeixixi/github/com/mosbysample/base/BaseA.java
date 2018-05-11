package wangfeixixi.github.com.mosbysample.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewStub;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseA<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P> {

    private Unbinder bind;
    public Activity mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = this;
        setContentView(onCreateView());
        bind = ButterKnife.bind(this);
        init(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    protected abstract int onCreateView();

    protected abstract void init(Bundle savedInstanceState);

    private SweetAlertDialog pDialogLoading = null;

    public void showLoadingDialog(boolean isShow) {
        if (isShow) {
            if (pDialogLoading == null) {
                pDialogLoading = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
                        .setTitleText("正在加载中...");
            }
            if (!pDialogLoading.isShowing())
                pDialogLoading.show();
        } else {
            if (pDialogLoading != null && pDialogLoading.isShowing()) {
                pDialogLoading.dismiss();
            }
        }
    }

    public SweetAlertDialog errorDialog = null;

    public boolean isError(final Throwable e) {
        if (e != null && e.getMessage() != null) {
            if (errorDialog == null) {
                errorDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("")
                        .setContentText(CodeInfo.getErroCodeInfo(e.getMessage())).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                errorDialog.dismiss();
                                onErrorDialogClick(e.getMessage());
                            }
                        });
            }
            if (!errorDialog.isShowing())
                errorDialog.show();
            return true;
        }
        return false;
    }


    protected void onErrorDialogClick(String message) {
        switch (message) {
            case "23001":
            case "23002":
            case "23003":
                this.finish();
                this.startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public View view_no_car = null;
    private SwipeRefreshLayout sr_nocar = null;

    public void showNoCar(boolean isShow, int resID) {
        if (sr_nocar != null)
            sr_nocar.setRefreshing(false);
        if (isShow) {
            try {
                showLoadingDialog(false);
                view_no_car = ((ViewStub) findViewById(resID)).inflate();
                if (view_no_car == null) return;

                SwipeRefreshLayout sr_nocar = view_no_car.findViewById(R.id.sr_nocar);
                sr_nocar.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        onNoCarRefresh();
                    }
                });
                view_no_car.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onNoCarRefresh();
                    }
                });
            } catch (Exception e) {

            }
        }
        if (view_no_car != null)
            view_no_car.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public void onNoCarRefresh() {

    }

    View view_no_net = null;

    public void showNoNet(boolean isShow, int resID) {
        if (isShow) {
            try {
                showLoadingDialog(false);
                view_no_net = ((ViewStub) findViewById(resID)).inflate();
                if (view_no_net == null) return;
                view_no_net.findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        initData();
                    }
                });

            } catch (Exception e) {

            }
        }
        if (view_no_net != null)
            view_no_net.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    protected void initData() {

    }
}
