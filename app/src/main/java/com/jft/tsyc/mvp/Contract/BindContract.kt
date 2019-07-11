package com.jft.tsyc.mvp.Contract

import android.content.Context
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Contract
 * @Email : yufeilong92@163.com
 * @Time :2019/7/11 11:56
 * @Purpose :绑定手机号
 */
interface BindContract {
    interface View {
        fun BindSuccess(t: Any?)
        fun BindError(ex: Throwable)
        fun BindComplise()
    }

    interface Model {
        fun submitBind(context: Context,phone:String,code:String,psw:String, request: RequestResultInterface)
    }

    interface Presenter {
        fun initMvp(view: View, model: Model)
        fun submitBind(context: Context,phone:String,code:String,psw:String)
    }
}