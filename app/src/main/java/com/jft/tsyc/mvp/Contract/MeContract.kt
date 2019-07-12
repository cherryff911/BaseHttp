package com.jft.tsyc.mvp.Contract

import android.content.Context
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Contract
 * @Email : yufeilong92@163.com
 * @Time :2019/7/12 17:54
 * @Purpose :我的
 */
interface MeContract {
    interface View {
        fun MeSuccess(t: Any?)
        fun MeError(ex: Throwable)
        fun MeComplise()
    }

    interface Model {
        fun requestMe(context: Context, request: RequestResultInterface)
    }

    interface Presenter {
        fun initMvp(view: View, model: Model)
        fun requestMe(context: Context)
    }
}