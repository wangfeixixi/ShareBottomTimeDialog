package wangfeixixi.github.com.mosbysample.base

import android.app.Activity
import android.os.Bundle

import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

import butterknife.ButterKnife
import butterknife.Unbinder

abstract class BaseA<V : MvpView, P : MvpPresenter<V>> : MvpActivity<V, P>() {

    private var bind: Unbinder? = null
    lateinit var mCtx: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCtx = this
        setContentView(onCreateView())
        bind = ButterKnife.bind(this)
        init(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        bind!!.unbind()
    }

    protected abstract fun onCreateView(): Int

    protected abstract fun init(savedInstanceState: Bundle?)
}
