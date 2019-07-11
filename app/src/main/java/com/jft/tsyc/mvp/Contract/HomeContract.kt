package com.jft.tsyc.mvp.Contract

import android.content.Context
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Contract
 * @Email : yufeilong92@163.com
 * @Time :2019/7/11 17:01
 * @Purpose :首页数据
 */
interface HomeContract {
    interface View {
        fun HomeSuccess(t: Any?)
        fun HomeError(ex: Throwable)
        fun HomeComplise()
    }

    interface Model {
        fun requestHome(context: Context, request: RequestResultInterface)
    }

    interface Presenter {
        fun initMvp(view: View, model: Model)
        fun requestHome(context: Context)
    }
}