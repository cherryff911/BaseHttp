package com.jft.tsyc.vo

import com.jft.tsyc.base.BaseVo

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.vo
 * @Email : yufeilong92@163.com
 * @Time :2019/7/8 14:59
 * @Purpose :登录vo
 */
data class LoginVo(
    val key: String="",
    val userid: Int=0,
    val username: String="",
    val state:Int=0
)

