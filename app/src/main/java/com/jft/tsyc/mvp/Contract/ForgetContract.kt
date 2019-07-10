package com.jft.tsyc.mvp.Contract

import android.content.Context
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Contract
 * @Email : yufeilong92@163.com
 * @Time :2019/7/10 16:27
 * @Purpose :忘记密码
 */
interface ForgetContract {
    interface View {
        fun ForgetSuccess(t: Any?)
        fun ForgetError(ex: Throwable)
        fun ForgetComplise()
    }

    interface Model {
        fun submiteChangerPsw(context: Context,phone:String,code:String,psw:String, request: RequestResultInterface)
    }

    interface Presenter {
        fun initMvp(view: View, model: Model)
        fun submiteChangerPsw(context: Context,phone:String,code:String,psw:String)
    }
}