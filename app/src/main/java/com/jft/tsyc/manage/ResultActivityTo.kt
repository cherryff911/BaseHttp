package com.jft.tsyc.manage

import android.app.Activity
import com.backpacker.UtilsLibrary.base.StartActivityManger
import com.jft.tsyc.MainActivity
import com.jft.tsyc.SelectImagerActivity
import com.jft.tsyc.ui.login.ForgetActivity
import com.jft.tsyc.ui.login.LoginActivity
import com.jft.tsyc.ui.login.RegisterActivity

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.manage
 * @Email : yufeilong92@163.com
 * @Time :2019/7/5 10:33
 * @Purpose :跳转管理
 */
open class ResultActivityTo(var context: Activity) : StartActivityManger(context) {
    fun toSelectCammer() {
        jumpTo(SelectImagerActivity::class.java)
    }

    fun toRegisterAc() {
        jumpTo(RegisterActivity::class.java)
    }

    fun toMainAc() {
        jumpTo(MainActivity::class.java)
    }

    fun toLoginAc() {
        jumpTo(LoginActivity::class.java)

    }

    fun toForgetAc(title:String) {
        jumpTo(ForgetActivity::class.java,title)

    }
}