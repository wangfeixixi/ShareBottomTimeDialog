package wangfeixixi.github.com.mosbysample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import wangfeixixi.github.com.mosbysample.R

abstract class BaseF<V : MvpView, P : MvpPresenter<V>> : MvpFragment<V, P>() {

    @BindView(R.id.tv_name)
    var tv_name: TextView? = null

    private var isPrepared = false
    private var firstLoad = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = LayoutInflater.from(context).inflate(initContentRes(), null)
        ButterKnife.bind(this, inflate)
        isPrepared = true
        initView()

        lazyLoad()
        return inflate
    }

    protected abstract fun initContentRes(): Int

    protected abstract fun initView()

    protected abstract fun initData(firstLoad: Boolean, isVisibleToUser: Boolean)

    abstract override fun createPresenter(): P

    private fun lazyLoad() {
        if (isPrepared) {
            if (userVisibleHint && firstLoad) {
                initData(firstLoad, userVisibleHint)
                firstLoad = false
                return
            }
            initData(false, userVisibleHint)
        }
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        lazyLoad()
    }


}
