package wangfeixixi.github.com.wiget

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.main_activity.*
import wangfeixixi.share.bottomtimedialog.BottomTimeDialog
import java.util.*

class MainActivity : AppCompatActivity() {

    private val iamgeUrl = "http://p3tnh1dg6.bkt.clouddn.com/ca1349540923dd548b8a28fbda09b3de9d8248ac.jpg"

    var mPower: Int = 0
    val mHandler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                0 -> {
                    mPower = mPower + 5
                    horizontalBattery.power = (mPower)
                    if (mPower == 50) {
                        mPower = 0
                    }
                }
                else -> {
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        verticalBattery!!.setColor(Color.GRAY)
        verticalBattery!!.setPower(90)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                mHandler.sendEmptyMessage(0)
            }
        }, 0, 100)
    }

    fun pop() {
        val bottomTimeDialog = BottomTimeDialog(this@MainActivity)
        bottomTimeDialog.setOnItemClickListener { text -> Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show() }
        bottomTimeDialog.show()
    }


}
