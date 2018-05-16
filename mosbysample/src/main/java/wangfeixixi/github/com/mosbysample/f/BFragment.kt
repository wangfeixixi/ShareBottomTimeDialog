package wangfeixixi.github.com.mosbysample.f

import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.b_fragment.*
import kotlinx.android.synthetic.main.vs_test.view.*
import wangfeixixi.github.com.mosbysample.R
import wangfeixixi.github.com.mosbysample.base.BaseF

class BFragment : BaseF<BView, BPresent>(), BView, View.OnClickListener {
    var isShow = false;

    override fun onClick(v: View?) {
        isShow = !isShow
        showNoNet(isShow)
        showToste(null)
    }

    private fun showToste(msg: String?) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }

    private var TAG = "BFragment"


    override fun initView() {
        tv_name.text = TAG
        tv_name.setOnClickListener(this)

        btn_test.setOnClickListener{ showToste("lalalala") }
    }

    var v_no_net: View? = null

    fun showNoNet(isShow: Boolean) {
        v_no_net = vs_test?.inflate() ?: v_no_net
        v_no_net?.tv_test_test?.setOnClickListener(View.OnClickListener {
            TAG += "1";
            tv_name.text = TAG
        })
        v_no_net?.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    override fun initData(firstLoad: Boolean, isVisibleToUser: Boolean) {
//        Log.d(TAG, "firstLoad" + firstLoad + "isVisibleToUser" + isVisibleToUser)
    }

    override fun createPresenter(): BPresent {
        return BPresent()
    }

    override fun initContentRes(): Int = R.layout.b_fragment


}
