package wangfeixixi.github.com.wiget

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_activity.*
import wangfeixixi.github.com.bottomtimedialog.BottomTimeDialog

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val iamgeUrl = "http://p3tnh1dg6.bkt.clouddn.com/ca1349540923dd548b8a28fbda09b3de9d8248ac.jpg"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Glide.with(this).load(iamgeUrl).into(iv)

        findViewById(R.id.btn_timepicker).setOnClickListener { pop() }
    }

    fun pop() {
        val bottomTimeDialog = BottomTimeDialog(this@MainActivity)
        bottomTimeDialog.setOnItemClickListener { text -> Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show() }
        bottomTimeDialog.show()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_timepicker -> startActivity(Intent(this, TimePikerActivity::class.java))
            R.id.btn_editview -> startActivity(Intent(this, EditViewActivity::class.java))
            R.id.btn_calendar -> startActivity(Intent(this, CalendarActivity::class.java))
            R.id.btn_sweet_dialog -> startActivity(Intent(this, SweetDialogActivity::class.java))
        }
    }

}
