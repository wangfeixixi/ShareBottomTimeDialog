package wangfeixixi.github.com.wiget

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.bottom_dialog_activity.*
import wangfeixixi.share.bottomtimedialog.BottomCaptureDialog
import wangfeixixi.share.picture.CameraUtils

class BottomDialogActivity : AppCompatActivity() {

    private var imageUri: Uri? = null
    private var mCtx: Activity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_dialog_activity)
        mCtx = this
        findViewById(R.id.btn).setOnClickListener {
            val bottomCaptureDialog = BottomCaptureDialog(mCtx as BottomDialogActivity)
            bottomCaptureDialog.setOnItemClickListener { text ->
                when (text) {
                    "拍照" -> imageUri = CameraUtils.startCamera(mCtx as BottomDialogActivity)
                    "从手机相册选择" -> CameraUtils.startPictures(mCtx as BottomDialogActivity)
                }
            }
            bottomCaptureDialog.show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            var bitmap: Bitmap? = null
            when (requestCode) {
                CameraUtils.CAMERA -> bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                CameraUtils.PICTURE -> bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data?.data)
            }
            iv_head.setImageBitmap(bitmap)
        }
    }
}
