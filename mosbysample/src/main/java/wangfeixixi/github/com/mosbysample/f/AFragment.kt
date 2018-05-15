package wangfeixixi.github.com.mosbysample.f

import android.util.Log
import android.view.View
import android.widget.Toast
import butterknife.OnClick
import kotlinx.android.synthetic.main.a_fragment.*
import wangfeixixi.github.com.mosbysample.R

import wangfeixixi.github.com.mosbysample.base.BaseF

class AFragment : BaseF<AView, APresent>(), AView {
    private val TAG = "AFragment"

    override fun initContentRes(): Int = R.layout.a_fragment

    override fun initView() {
        tv_name.text = TAG
    }

    override fun initData(firstLoad: Boolean, isVisibleToUser: Boolean) {
        Log.d(TAG, "firstLoad" + firstLoad + "isVisibleToUser" + isVisibleToUser)
        //        presenter.asdfas();
    }

    override fun createPresenter(): APresent {
        return APresent()
    }

    @OnClick(R.id.tv_name)
    fun tvNameClick(view: View) {
        Log.d(TAG, "测试可以不")
        Toast.makeText(context, "测试可以不", Toast.LENGTH_SHORT).show()
    }
}
