package wangfeixixi.github.com.mosbysample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import wangfeixixi.github.com.mosbysample.base.BaseA;
import wangfeixixi.github.com.mosbysample.base.BaseF;
import wangfeixixi.github.com.mosbysample.f.AFragment;
import wangfeixixi.github.com.mosbysample.f.BFragment;
import wangfeixixi.github.com.mosbysample.f.CFragment;
import wangfeixixi.github.com.mosbysample.f.DFragment;

public class MainActivity extends BaseA<HelloWorldView, HelloWorldPresenter> implements HelloWorldView {
    @BindView(R.id.vp)
    ViewPager vp;

    @BindView(R.id.tv_text)
    TextView tv_text;

    @Override
    protected int onCreateView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        final ArrayList<BaseF> fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());

        vp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });


    }

    @NonNull
    @Override
    public HelloWorldPresenter createPresenter() {
        return new HelloWorldPresenter();
    }

    @Override
    public void showHello(String greetingText) {
        tv_text.setTextColor(Color.RED);
        tv_text.setText(greetingText);
    }

    @Override
    public void showGoodbye(String greetingText) {
        tv_text.setTextColor(Color.BLUE);
        tv_text.setText(greetingText);
    }

    //    点击按钮后，使用Presenter来完成相关操作：
    @OnClick(R.id.btn_ok)
    public void onHelloButtonClicked(View view) {
        presenter.setOk();
//        tv_text.setText("btn_ok");
    }

    @OnClick(R.id.btn_no)
    public void onGoodbyeButtonClicked() {
        presenter.setNo();
//        tv_text.setText("btn_no");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        ButterKnife.(this);
    }


}
