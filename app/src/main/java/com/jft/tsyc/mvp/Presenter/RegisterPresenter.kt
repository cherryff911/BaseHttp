package com.jft.tsyc.mvp.Presenter

import android.content.Context
import com.jft.tsyc.mvp.Contract.RegisterContract
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Presenter
 * @Email : yufeilong92@163.com
 * @Time :2019/7/9 10:03
 * @Purpose :
 */
class RegisterPresenter : RegisterContract.Presenter {


    var view: RegisterContract.View? = null
    var model: RegisterContract.Model? = null
    override fun initMvp(view: RegisterContract.View, model: RegisterContract.Model) {
        this.view = view
        this.model = model
    }

    override fun submitRegister(context: Context, phone: String, code: String, psw: String, inviteCode: String) {
        model!!.submitRegister(context, phone, code, psw, inviteCode, object : RequestResultInterface {
            override fun onError(ex: Throwable) {
                view!!.RegisterError(ex)
            }

            override fun onComplise() {
                view!!.RegisterComplise()
            }

            override fun <T> Success(t: T) {
                view!!.RegisterSuccess(t)
            }
        })

    }

}