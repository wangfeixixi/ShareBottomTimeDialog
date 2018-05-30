package wangfeixixi.github.com.wiget

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.drag_activity.*
import wangfeixixi.share.drag.DragLayout

/**
 * Created by Fei.Wang20 on 2018/5/30.
 */
class DragActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drag_activity)
        initPoiLayout()
    }


    private fun initPoiLayout() {
        poi_layout!!.setOnChangeListener(object : DragLayout.OnChangeListener {
            override fun onChange(status: Int) {
                tv_bottom!!.visibility = if (status == DragLayout.STATUS_CLOSE) View.VISIBLE else View.GONE
            }

            override fun onScroll(offset: Float) {
                tv_bottom!!.visibility = if (offset == 1f) View.VISIBLE else View.GONE
            }
        })
        tv_bottom!!.setOnTikListener { poi_layout!!.toggle(DragLayout.STATUS_EXTEND) }
    }

}