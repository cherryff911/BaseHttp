package com.jft.tsyc.retrofit

import com.backpacker.UtilsLibrary.kotlin.BaseEntity
import com.jft.tsyc.vo.CodeVo
import com.jft.tsyc.vo.HomeDataVo
import com.jft.tsyc.vo.LoginVo
import com.jft.tsyc.vo.RegisterVo
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.retrofit
 * @Email : yufeilong92@163.com
 * @Time :2019/7/8 15:29
 * @Purpose :
 */
interface MainRequest {
    //登录
    @FormUrlEncoded
    @POST("index.php/api/Login/index.html")
    fun Login(
        @Field("username") username: String,
        @Field("password") password: String
    )
            : Observable<BaseEntity<LoginVo>>

    //注册
    @FormUrlEncoded
    @POST("api/Connect/sms_register.html")
    fun register(
        @Field("phone") phone: String,
        @Field("captcha") captcha: String,//验证码
        @Field("password") password: String,
        @Field("invite") invite: String//邀请码
    ): Observable<BaseEntity<LoginVo>>

    //请求验证码
    @FormUrlEncoded
    @POST("index.php/api/Connect/get_sms_captcha.html")
    fun reqeustCode(
        @Field("type") type: String,
        @Field("phone") phone: String
    ): Observable<BaseEntity<CodeVo>>

    //忘记密码
    @FormUrlEncoded
    @POST("api/Connect/find_password")
    fun submitForgetPsw(
        @Field("phone") phone: String,
        @Field("captcha") captcha: String,
        @Field("password") password: String
    ): Observable<BaseEntity<String>>

    //首页
    @POST("api/index")
    fun requestHomeData(): Observable<BaseEntity<HomeDataVo>>

}