package com.jft.tsyc.mvp.Presenter

import android.content.Context
import com.jft.tsyc.mvp.Contract.HomeContract
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Presenter
 * @Email : yufeilong92@163.com
 * @Time :2019/7/11 17:09
 * @Purpose :
 */
class HomePresenter : HomeContract.Presenter {
    var view: HomeContract.View? = null
    var model: HomeContract.Model? = null
    override fun initMvp(view: HomeContract.View, model: HomeContract.Model) {
        this.view = view
        this.model = model
    }

    override fun requestHome(context: Context) {
        model!!.requestHome(context, object : RequestResultInterface {
            override fun onError(ex: Throwable) {
                view!!.HomeError(ex)
            }

            override fun onComplise() {
                view!!.HomeComplise()
            }

            override fun <T> Success(t: T) {
                view!!.HomeSuccess(t)
            }
        })
    }
}