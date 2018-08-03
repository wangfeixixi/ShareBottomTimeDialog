package wangfeixixi.github.com.wiget

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.SurfaceTexture
import android.hardware.Camera
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.TextureView
import android.view.View
import kotlinx.android.synthetic.main.mine_camera_scan_activity.*
import kotlinx.android.synthetic.main.mine_camera_scan_result_include.*
import org.jetbrains.anko.toast
import wangfeixixi.share.camera.ConUtil
import wangfeixixi.share.camera.ICamera
import wangfeixixi.share.camera.Screen


class CameraActivity : AppCompatActivity(), TextureView.SurfaceTextureListener, Camera.PreviewCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_camera_scan_activity)

        Screen.initialize(this)

        iCamera = ICamera(false)
        //
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        tv_idcard_scan!!.surfaceTextureListener = this

        tv_idcard_scan.setOnClickListener { iCamera!!.autoFocus() }
        idcard_indicator.setOnClickListener { iCamera!!.autoFocus() }
        iv_paizhao.setOnClickListener { isPaizhao = true }
        iv_close.setOnClickListener { finish() }
    }

    private var iCamera: ICamera? = null

    private var mHasSurface = false
    private val setClear = 0.8f
    private val setIdcard = 0.1f
    private val setBound = 0.8f
    private val faculaPass = 0.3f


    private var isPaizhao = false

    override fun onResume() {
        super.onResume()
        val mCamera = iCamera!!.openCamera(this)
        if (mCamera != null) {
            val layoutParam = iCamera!!.getLayoutParam(this)
            tv_idcard_scan!!.layoutParams = layoutParam
            idcard_indicator!!.layoutParams = layoutParam
            idcard_indicator_backgraou!!.layoutParams = layoutParam
        } else {
            toast("打开摄像头失败")
        }
    }

    override fun onPause() {
        super.onPause()
        iCamera!!.closeCamera()
    }

    override fun onStop() {
        super.onStop()
        //        idCard.release();
    }

    override fun onDestroy() {
        super.onDestroy()
        //        mHandler.removeCallbacksAndMessages(null);
        //        mHandler.getLooper().quit();
    }

    override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
        mHasSurface = true
//        Log.d(FragmentActivity.TAG, "onSurfaceTextureAvailable: ")
        //        runOnUiThread(new Runnable() {
        //            @Override
        //            public void run() {
        //                Log.d(TAG, "onSurfaceTextureAvailable: ");
        //            }
        //        });
        doPreview()
        iCamera!!.actionDetect(this)
    }

    //    private int width;
    //    private int height;
    //    private boolean isSuccess = false;

    private fun doPreview() {
        if (!mHasSurface) return

        iCamera!!.startPreview(tv_idcard_scan!!.surfaceTexture)
    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {
//        Log.d(FragmentActivity.TAG, "onSurfaceTextureSizeChanged: ")
    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
//        Log.d(FragmentActivity.TAG, "onSurfaceTextureDestroyed: ")
        mHasSurface = false
        return false
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {

    }


    override fun onPreviewFrame(data: ByteArray, camera: Camera) {
        if (isPaizhao) {
            runOnUiThread {
                isPaizhao = false
                rl_result!!.visibility = View.VISIBLE

                val bitmap = ConUtil.cutImage(idcard_indicator!!.position, data, iCamera!!.mCamera,
                        false)
                iv_camera_result!!.setImageBitmap(bitmap)
                tv_ok!!.setOnClickListener {
                    rl_result!!.visibility = View.GONE
                    val path = ConUtil.saveBitmap(this@CameraActivity, bitmap)
                    val intent = Intent()
                    intent.putExtra("imgeUrl", path)
                    setResult(10000, intent)
                    finish()
                }
                tv_reset!!.setOnClickListener { rl_result!!.visibility = View.GONE }
            }

            //            Bitmap bitmap = ConUtil.cutImage(idcard_indicator.getPosition(), data, iCamera.mCamera,
            //                    false);
            //            String path = ConUtil.saveBitmap(CameraScanActivity.this, bitmap);
            //            Intent intent = new Intent();
            //            intent.putExtra("imgeUrl", path);
            //            setResult(10000, intent);
            //            isPaizhao = false;
            //            finish();
        }
    }
}
