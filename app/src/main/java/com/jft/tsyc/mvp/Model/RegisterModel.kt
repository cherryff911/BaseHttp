package com.jft.tsyc.mvp.Model

import android.content.Context
import com.jft.tsyc.mvp.Contract.RegisterContract
import com.jft.tsyc.mvp.ResultView.RequestResultInterface
import com.jft.tsyc.mvp.ResultView.StringResultInterface
import com.jft.tsyc.netserver.NetServer

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Model
 * @Email : yufeilong92@163.com
 * @Time :2019/7/9 10:02
 * @Purpose :注册model
 */
class RegisterModel : RegisterContract.Model {

    /***
     * @param code 验证码
     * @param inviteCode 邀请码
     */
    override fun submitRegister(
        context: Context,
        phone: String,
        code: String,
        psw: String,
        inviteCode: String,
        request: RequestResultInterface
    ) {
        NetServer.submiteRegister(context, phone, code, psw, inviteCode, object : StringResultInterface {
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