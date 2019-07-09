package com.jft.tsyc.mvp.Presenter

import android.content.Context
import com.jft.tsyc.mvp.Contract.LoginContract
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.mvp.Presenter
 * @Email : yufeilong92@163.com
 * @Time :2019/7/8 16:17
 * @Purpose :管理类型
 */
class LoginPresenter : LoginContract.Presenter {
    var view: LoginContract.View? = null
    var model: LoginContract.Model? = null
    override fun initMvp(view: LoginContract.View, model: LoginContract.Model) {
        this.view = view
        this.model = model
    }

    override fun submitLogin(context: Context, phone: String, psw: String) {
        model!!.submitLogin(context, phone, psw,object : RequestResultInterface {
            override fun onError(ex: Throwable) {
                view!!.LoginError(ex)
            }

            override fun onComplise() {
                view!!.LoginComplise()
            }

            override fun <T> Success(t: T){
                view!!.LoginSuccess(t)
            }
        })
    }

}