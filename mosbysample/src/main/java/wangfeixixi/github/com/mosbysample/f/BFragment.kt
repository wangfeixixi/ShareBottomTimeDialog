package wangfeixixi.github.com.mosbysample.f

import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.b_fragment.*
import kotlinx.android.synthetic.main.vs_test.*
import kotlinx.android.synthetic.main.vs_test.view.*
import wangfeixixi.github.com.mosbysample.R
import wangfeixixi.github.com.mosbysample.base.BaseF

class BFragment : BaseF<BView, BPresent>(), BView, View.OnClickListener {
    override fun onClick(v: View?) {

    }

    private var TAG = "BFragment"

    override fun initView() {
        tv_name.text = TAG
        tv_name.setOnClickListener(this)

//        vs_test!!.inflate();
        showNoNet(true)
    }

    fun showNoNet(isShow: Boolean) {
        if (isShow) {
            try {
                val view = vs_test!!.inflate();
//                view
                view!!.tv_test_test!!.setOnClickListener(View.OnClickListener {
                    TAG += "1";
                    tv_name.text = TAG
                })
            } catch (e: Exception) {

            }

        }
        vs_test.visibility = if (isShow) View.VISIBLE else View.GONE
//        vs_test.visibility(if(isShow)View.VISIBLE else View.GONE)
    }

    override fun initData(firstLoad: Boolean, isVisibleToUser: Boolean) {

        Log.d(TAG, "firstLoad" + firstLoad + "isVisibleToUser" + isVisibleToUser)
    }

    override fun createPresenter(): BPresent {
        return BPresent()
    }

    override fun initContentRes(): Int = R.layout.b_fragment



}
