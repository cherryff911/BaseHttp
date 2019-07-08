package com.jft.tsyc.mvp.Presenter

import android.content.Context
import com.jft.tsyc.mvp.Contrat.LoginView
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.mvp.Presenter
 * @Email : yufeilong92@163.com
 * @Time :2019/7/8 16:17
 * @Purpose :管理类型
 */
class LoginPresenter : LoginView.Presenter {
    var view: LoginView.View? = null
    var model: LoginView.Model? = null
    override fun initMvp(view: LoginView.View, model: LoginView.Model) {
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