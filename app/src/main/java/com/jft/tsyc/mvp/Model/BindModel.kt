package com.jft.tsyc.mvp.Model

import android.content.Context
import com.jft.tsyc.mvp.Contract.BindContract
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Model
 * @Email : yufeilong92@163.com
 * @Time :2019/7/11 11:57
 * @Purpose :绑定手机
 */
class BindModel:BindContract.Model {
    override fun submitBind(
        context: Context,
        phone: String,
        code: String,
        psw: String,
        request: RequestResultInterface
    ) {

    }
}