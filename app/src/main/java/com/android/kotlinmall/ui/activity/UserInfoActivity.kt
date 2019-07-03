package com.android.kotlinmall.ui.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build.VERSION
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.android.kotlinmall.presenter.UserInfoPresenter
import com.android.kotlinmall.repository.UserRepority
import com.android.kotlinmall.utils.DateUtils
import com.android.mvp.impl.BaseActivity
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.TResult
import com.orhanobut.logger.Logger
import com.qiniu.android.storage.UploadManager
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_user_info.*
import kotlinx.android.synthetic.main.layout_header_bar.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import java.io.File


/***
 *      var intent: Intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
 *      intent.setData(Uri.parse("package:${getPackageName()}")) // 根据包名打开对应的设置界面
 *       startActivity(intent)
 */
class UserInfoActivity : BaseActivity<UserInfoPresenter>(), TakePhoto.TakeResultListener {


    private lateinit var mTakePhoto: TakePhoto
    private lateinit var mTempFile: File
    private lateinit var mPxPermissions: RxPermissions

    private var mLocalFile: String? = null
    private var mRemoteFile: String? = null
    private var mUserIcon: String? = null
    private var mUserName: String? = null
    private var mUserGender: String? = null
    private var mUserSigin: String? = null
    private var mUserMobile: String? = null


    private val mUploadManager: UploadManager by lazy {
        UploadManager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.android.kotlinmall.R.layout.activity_user_info)


        mTakePhoto = TakePhotoImpl(this, this)
        mPxPermissions = RxPermissions(this)
        mTakePhoto.onCreate(savedInstanceState)

        initData()
        mHeaderBar.mRightTv.onClick {
            presenter.editUser(
                mUserNameEt.text?.toString() ?: "",
                "",
                if (mGenderMaleRb.isChecked) "0" else "1",
                mUserSignEt.text?.toString() ?: ""
            )
        }

        mUserIconIv.onClick {
            mPxPermissions.requestEachCombined(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ).subscribe({
                Logger.e("$it")
                when {
                    it.granted -> showAlertView()
                    it.shouldShowRequestPermissionRationale -> toast("Denied permission without ask never again")
                    else -> toast("Permission denied, can't enable the camera")
                }
            }, {
                Logger.e("$it.message")
            }, {

            })
        }


    }


    private fun initData() {
        mUserName = UserRepority.currentUser?.userName
        mUserMobile = UserRepority.currentUser?.userMobile
        mUserIcon = UserRepority.currentUser?.userIcon
        mUserSigin = UserRepority.currentUser?.userSign
        mUserGender = UserRepority.currentUser?.userGender
        mUserNameEt.setText(mUserName)
        mUserMobileTv.text = mUserMobile
        mUserSignEt.setText(mUserSigin)
        if (mUserGender == "0") {
            mGenderMaleRb.isChecked = true
        } else {
            mGenderFemaleRb.isChecked = true
        }
    }


    fun editUserSuccess() {
        toast("修改成功")
    }

    fun editUserError() {
        toast("修改失败")
    }

    private fun showAlertView() {
        AlertView(
            "", "",
            "取消",
            null,
            arrayOf("拍照", "相机"),
            this,
            AlertView.Style.ActionSheet,
            OnItemClickListener { _, position ->
                mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(), false)
                when (position) {
                    0 -> {
                        createTempFile()
                        checkCameraPermission()
                    }
                    1 -> mTakePhoto.onPickFromGallery()
                }
            }).show()
    }

    private fun checkCameraPermission() {
        if (VERSION.SDK_INT >= 23) {
            val checkCallPhonePermission =
                ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    1// 1:OPEN_CANMER
                )
                return
            } else {
                capture()
            }
        } else {
            capture()
        }
    }


    override fun takeSuccess(result: TResult?) {
        Logger.d(result?.image?.originalPath)
        Logger.d(result?.image?.compressPath)

        mLocalFile = result?.image?.compressPath

        presenter.getUploadtoken()
    }

    override fun takeCancel() {
    }

    override fun takeFail(result: TResult?, msg: String?) {
        msg?.let { Logger.e(it) }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode, resultCode, data)
    }

    fun createTempFile() {
        val tempFile = "${DateUtils.curTime}.png"

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            this.mTempFile = File(Environment.getExternalStorageDirectory(), tempFile)
            return
        }

        this.mTempFile = File(filesDir, tempFile)
    }

    fun capture() {
        mTakePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
    }


    /*
       获取上传凭证回调
    */
    fun onGetUploadTokenResult(result: String) {


    }


}
