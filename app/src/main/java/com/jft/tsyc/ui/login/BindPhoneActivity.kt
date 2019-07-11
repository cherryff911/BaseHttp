package com.jft.tsyc.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.backpacker.UtilsLibrary.kotlin.Util
import com.jft.tsyc.R
import com.jft.tsyc.base.BaseActivity
import kotlinx.android.synthetic.main.activity_bind_phone.*

/**
 * @Author : YFL  is Creating a porject in com.jft.tsyc.ui.login
 * @Package com.jft.tsyc.ui.login
 * @Email : yufeilong92@163.com
 * @Time :2019/7/11 9:10
 * @Purpose : 绑定手机号
 */
class BindPhoneActivity : BaseActivity() {


    override fun setInitContentView(): Int {
        return R.layout.activity_bind_phone
    }

    override fun onInitCreateView(savedInstanceState: Bundle?) {
        ininRequest()
        initEvent()
    }

    fun ininRequest() {

    }

    fun initEvent() {
        btn_bind_send_code.setOnClickListener {

        }
        btn_bind_submit.setOnClickListener {
            submit()
        }

    }

    fun submit() {
        val phone = Util.getObjToStr(et_bind_phone)
        if (Util.tShow(mContext, phone, getStringWithId(R.string.please_input_phone)))
            return
        val code = Util.getObjToStr(et_bind_code)
        if (Util.tShow(mContext, code, getStringWithId(R.string.please_input_phone_code)))
            return
        val psw = Util.getObjToStr(et_bind_psw)
        if (Util.tShow(mContext, psw, getStringWithId(R.string.please_set_psw)))
            return
    }


}
