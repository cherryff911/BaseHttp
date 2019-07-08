package com.jft.tsyc.netserver

import android.content.Context
import com.backpacker.UtilsLibrary.net.BaseServiceUtil
import com.jft.tsyc.base.BaseHttp
import com.jft.tsyc.base.DataMessageVo
import com.jft.tsyc.mvp.ResultView.StringResultInterface
import com.jft.tsyc.retrofit.MainRequest

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.netserver
 * @Email : yufeilong92@163.com
 * @Time :2019/7/8 16:12
 * @Purpose :
 */
object NetServer : BaseHttp() {
    /***
     * 登录接口
     * @param phone  手机号
     * @param psw   密码
     */
    fun Login(mContext: Context, phone: String, psw: String, respone: StringResultInterface) {
        requestHttpRxjava(mContext = mContext, request = {
            val service = BaseServiceUtil.createService(MainRequest::class.java, DataMessageVo.mHttp)
            val call = service.Login(phone, psw)
            call
        }, success = {
            respone.Success(it)
        }, error = {
            respone.onError(it)
        }, complate = {
            respone.onComplise()
        })

    }
}