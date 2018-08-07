package wangfeixixi.github.com.wiget

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.drag_activity.*
import wangfeixixi.share.drag.DragLayout

class DragActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drag_activity)
        initPoiLayout()
    }


    private fun initPoiLayout() {

    }

}