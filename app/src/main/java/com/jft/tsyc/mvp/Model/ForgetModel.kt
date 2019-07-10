package com.jft.tsyc.mvp.Model

import android.content.Context
import com.jft.tsyc.mvp.Contract.ForgetContract
import com.jft.tsyc.mvp.ResultView.RequestResultInterface
import com.jft.tsyc.mvp.ResultView.StringResultInterface
import com.jft.tsyc.netserver.NetServer

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Model
 * @Email : yufeilong92@163.com
 * @Time :2019/7/10 16:28
 * @Purpose :
 */
class ForgetModel : ForgetContract.Model {
    override fun submiteChangerPsw(
        context: Context,
        phone: String,
        code: String,
        psw: String,
        request: RequestResultInterface
    ) {

        NetServer.submiteRegister(context, phone, code, psw, object : StringResultInterface {
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