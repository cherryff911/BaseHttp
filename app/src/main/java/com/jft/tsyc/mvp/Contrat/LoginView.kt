package com.jft.tsyc.mvp.Contrat

import android.content.Context
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.mvp.Contrat
 * @Email : yufeilong92@163.com
 * @Time :2019/7/8 16:09
 * @Purpose :登录界面
 */
interface LoginView {
    interface View {
        fun LoginSuccess(t: Any?)
        fun LoginError(ex: Throwable)
        fun LoginComplise()
    }

    interface Model {
        fun submitLogin(context: Context, phone: String, psw: String, request: RequestResultInterface)
    }

    interface Presenter {
        fun initMvp(view: View, model: Model)
        fun submitLogin(context: Context, phone: String, psw: String)
    }
}