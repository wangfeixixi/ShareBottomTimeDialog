package wangfeixixi.github.com.mosbysample.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

open class BaseP<V : MvpView> : MvpBasePresenter<V>()
