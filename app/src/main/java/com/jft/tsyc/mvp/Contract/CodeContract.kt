package com.jft.tsyc.mvp.Contract

import android.content.Context
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Contract
 * @Email : yufeilong92@163.com
 * @Time :2019/7/9 10:57
 * @Purpose :请求验证码
 */
interface CodeContract {
    interface View {
        fun CodeSuccess(t: Any?)
        fun CodeError(ex: Throwable)
        fun CodeComplise()
    }

    interface Model {
        fun requestCode(context: Context,type:String,phone:String, request: RequestResultInterface)
    }

    interface Presenter {
        fun initMvp(view: View, model: Model)
        fun requestCode(context: Context,type:String,phone:String)
    }
}