package com.jft.tsyc.retrofit

import com.jft.tsyc.vo.LoginVo
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.retrofit
 * @Email : yufeilong92@163.com
 * @Time :2019/7/8 15:29
 * @Purpose :
 */
interface MainRequest {

    @POST("index.php/api/Login/index.html")
    fun Login(
        @Field("username") username: String,
        @Field("password") password: String
    )
            : Call<LoginVo>


}