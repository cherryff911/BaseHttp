package com.jft.tsyc.netserver

import android.content.Context
import com.backpacker.UtilsLibrary.net.BaseServiceUtil
import com.jft.tsyc.base.BaseHttp
import com.jft.tsyc.base.DataMessageVo
import com.jft.tsyc.mvp.ResultView.StringResultInterface
import com.jft.tsyc.retrofit.MainRequest
import com.jft.tsyc.retrofit.RetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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

        if (RetrofitFactory.judgmentNetWork(mContext)) {
            RetrofitFactory.createMainRetrofit().Login(
                username = phone,
                password = psw
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(RxJaveObserver({
                    respone.Success(it.data)
                }, {
                    respone.onError(it)
                }, {
                    respone.onComplise()
                }))

        }
    }

    /***
     * 提交注册
     */
    fun submiteRegister(
        mContext: Context,
        phone: String,
        code: String,
        psw: String,
        invrteCode: String,
        respone: StringResultInterface
    ) {

        if (RetrofitFactory.judgmentNetWork(mContext)) {
            RetrofitFactory.createMainRetrofit().register(
                phone = phone,
                password = psw,
                captcha = code
                , invite = invrteCode
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(RxJaveObserver({
                    respone.Success(it.data)
                }, {
                    respone.onError(it)
                }, {
                    respone.onComplise()
                }))

        }
    }

    /***
     * 请求验证码
     */
    fun requestCode(mContext: Context, type: String, phone: String, respone: StringResultInterface) {

        if (RetrofitFactory.judgmentNetWork(mContext)) {

        RetrofitFactory.createMainRetrofit().reqeustCode(
            type = type,
            phone = phone
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(RxJaveObserver({
                respone.Success(it.data)
            }, {
                respone.onError(it)
            }, {
                respone.onComplise()
            }))
        }

    }

}