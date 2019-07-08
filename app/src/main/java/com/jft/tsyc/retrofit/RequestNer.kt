package com.jft.tsyc.retrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Part

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.retrofit
 * @Email : yufeilong92@163.com
 * @Time :2019/7/8 14:48
 * @Purpose :
 */
interface RequestNer {
    @POST("index.php/api/Login/index.html")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("client") client: String
    )
            : Call<String>
}