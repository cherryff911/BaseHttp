package com.jft.tsyc.mvp.Presenter

import android.content.Context
import com.jft.tsyc.mvp.Contract.ForgetContract
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Presenter
 * @Email : yufeilong92@163.com
 * @Time :2019/7/10 16:38
 * @Purpose :忘记密码
 */
class ForgetPresenter : ForgetContract.Presenter {
    var view: ForgetContract.View? = null
    var model: ForgetContract.Model? = null
    override fun initMvp(view: ForgetContract.View, model: ForgetContract.Model) {
        this.view = view
        this.model = model
    }

    override fun submiteChangerPsw(context: Context, phone: String, code: String, psw: String) {
        model!!.submiteChangerPsw(context, phone, code, psw, object : RequestResultInterface {
            override fun onError(ex: Throwable) {
                view!!.ForgetError(ex)
            }

            override fun onComplise() {
                view!!.ForgetComplise()
            }

            override fun <T> Success(t: T) {
                view!!.ForgetSuccess(t)
            }
        })
    }
}