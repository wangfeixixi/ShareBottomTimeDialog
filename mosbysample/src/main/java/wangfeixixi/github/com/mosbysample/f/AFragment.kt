package wangfeixixi.github.com.mosbysample.f

import android.util.Log

import wangfeixixi.github.com.mosbysample.base.BaseF

class AFragment : BaseF<AView, APresent>(), AView {
    private val TAG = "AFragment"

    override fun initContentRes(): Int {
        return 0
    }

    override fun initView() {

        tv_name.text = TAG
        tv_name.
    }

    override fun initData(firstLoad: Boolean, isVisibleToUser: Boolean) {
        Log.d(TAG, "firstLoad" + firstLoad + "isVisibleToUser" + isVisibleToUser)
        //        presenter.asdfas();
    }

    override fun createPresenter(): APresent {
        return APresent()
    }
}
