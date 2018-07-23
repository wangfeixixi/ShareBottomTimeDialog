package wangfeixixi.share.picture

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.widget.Toast
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.functions.Consumer
import java.io.File
import java.lang.Exception

object CameraUtils {

    val PICTURE = 1234
    val CAMERA = 2234

    fun startPictures(context: Activity) {
        RxPermissions(context).request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(object : Consumer<Boolean> {
                    override fun accept(aBoolean: Boolean) {
                        if (aBoolean) {
                            val intent = Intent(Intent.ACTION_PICK)
                            intent.type = "image/*"//相片类型
                            context.startActivityForResult(intent, PICTURE)
                        } else {
                            Toast.makeText(context, "请打开图片权限,否则无法使用图片", Toast.LENGTH_SHORT).show()
                        }
                    }
                })

    }

    fun startCamera(context: Activity): Uri? {
        var uri: Uri? = null
        RxPermissions(context).request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .subscribe(object : Consumer<Boolean> {
                    override fun accept(aBoolean: Boolean) {
                        if (aBoolean) {
                            uri = pickCameraPicture(context)
                        } else {
                            Toast.makeText(context, "请打开相机权限,否则无法使用相机", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
        return uri
    }

    fun pickCameraPicture(context: Activity): Uri? {
        var imageUri: Uri? = null
        //先验证手机是否有sdcard
        val status = Environment.getExternalStorageState()
        if (status == Environment.MEDIA_MOUNTED) {
            //创建File对象，用于存储拍照后的照片
            val outputImage = File(context.externalCacheDir, "out_image.jpg")//SD卡的应用关联缓存目录
            try {
                if (outputImage.exists()) {
                    outputImage.delete()
                }
                outputImage.createNewFile()
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    imageUri = FileProvider.getUriForFile(context, context.getPackageName(), outputImage)//添加这一句表示对目标应用临时授权该Uri所代表的文件
                } else {
                    imageUri = Uri.fromFile(outputImage)
                }
                //启动相机程序
                intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0)
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
                context.startActivityForResult(intent, CAMERA)
            } catch (e: Exception) {
                // TODO Auto-generated catch block
                Toast.makeText(context, "没有找到储存目录", Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(context, "没有储存卡", Toast.LENGTH_LONG).show()
        }
        return imageUri
    }
}
