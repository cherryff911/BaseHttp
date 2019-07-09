package com.jft.tsyc.mvp.Contract

import android.content.Context
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Contract
 * @Email : yufeilong92@163.com
 * @Time :2019/7/9 10:00
 * @Purpose :注册界面
 */
interface RegisterContract {
    interface View {
        fun RegisterSuccess(t: Any?)
        fun RegisterError(ex: Throwable)
        fun RegisterComplise()
    }

    interface Model {
        fun submitRegister(context: Context,phone:String,code:String,psw:String,inviteCode:String, request: RequestResultInterface)
    }

    interface Presenter {
        fun initMvp(view: View, model: Model)
        fun submitRegister(context: Context,phone:String,code:String,psw:String,inviteCode:String)
    }
}