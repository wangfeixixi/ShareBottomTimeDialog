package wangfeixixi.github.com.mosbysample.f

import android.util.Log
import kotlinx.android.synthetic.main.a_fragment.*
import wangfeixixi.github.com.mosbysample.R

import wangfeixixi.github.com.mosbysample.base.BaseF


class CFragment : BaseF<CView, CPresent>(), CView {
    override fun initContentRes(): Int = R.layout.a_fragment

    private val TAG = "CFragment"

    protected fun onUserVisible(isVisible: Boolean) {

        Log.d(TAG, "onUserVisible$isVisible")
    }

    override fun initView() {
        tv_name.text = TAG

    }

    override fun initData(firstLoad: Boolean, isVisibleToUser: Boolean) {

        Log.d(TAG, "firstLoad" + firstLoad + "isVisibleToUser" + isVisibleToUser)
    }


    override fun createPresenter(): CPresent {
        return CPresent()
    }
}
