package com.jft.tsyc.mvp.Model

import android.content.Context
import com.jft.tsyc.mvp.Contrat.LoginView
import com.jft.tsyc.netserver.NetServer
import com.jft.tsyc.mvp.ResultView.RequestResultInterface
import com.jft.tsyc.mvp.ResultView.StringResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.mvp.Model
 * @Email : yufeilong92@163.com
 * @Time :2019/7/8 16:09
 * @Purpose :登录
 */
class LoginModel : LoginView.Model {
    override fun submitLogin(context: Context, phone: String, psw: String, request: RequestResultInterface) {
        val net = NetServer.Login(context, phone, psw, object : StringResultInterface {
            override fun onError(ex: Throwable) {
                request.onError(ex)
            }

            override fun onComplise() {
                request.onComplise()
            }
            override fun <T> Success(t: T) {
                request.Success(t)
            }
        })
    }

}