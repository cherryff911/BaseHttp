package com.jft.tsyc.ui.login

import android.os.Bundle
import com.backpacker.UtilsLibrary.kotlin.Util
import com.jft.tsyc.base.BaseActivity
import com.jft.tsyc.mvp.Contract.LoginContract
import com.jft.tsyc.mvp.Model.LoginModel
import com.jft.tsyc.mvp.Presenter.LoginPresenter
import com.jft.tsyc.R
import com.jft.tsyc.vo.LoginVo
import kotlinx.android.synthetic.main.activity_login.*

/**
 * @Package com.example.tsyc.ui.login
 * @Description:  登陆界面
 * @author: L-BackPacker
 * @date:   2019/7/6 15:04
 * @version V 1.0 xxxxxxxx
 * @verdescript  版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019/7/6
 */
class LoginActivity : BaseActivity(), LoginContract.View {

    private var mPresenter: LoginPresenter? = null
    override fun setInitContentView(): Int {
        return R.layout.activity_login
    }

    override fun onInitCreateView(savedInstanceState: Bundle?) {
        initRequest()
        initEvent()
    }

    fun initRequest() {
        mPresenter = LoginPresenter()
        mPresenter!!.initMvp(this, LoginModel())
    }

    fun initEvent() {
        //显示密码
        iv_login_psw_right.setOnClickListener {
            Util.etShowOrHine(et_login_psw, true)
        }
        //提交
        btn_login.setOnClickListener {
            submit()
        }
        //清楚号码
        iv_login_phone_right.setOnClickListener {
            et_login_phone.setText("")
        }
        //注册
        tv_login_register.setOnClickListener {
            mResultTo.toRegisterAc()
        }
        //忘记密码
        tv_login_no_psw.setOnClickListener {

        }
        //微信登录
        ll_weixin_login.setOnClickListener {

        }
    }

    fun submit() {
        val phone = Util.getObjToStr(et_login_phone)
        if (Util.tShow(mContext, phone, getStringWithId(R.string.please_input_phone)))
            return
        val psw = Util.getObjToStr(et_login_psw)
        if (Util.tShow(mContext, psw, getStringWithId(R.string.please_input_psw)))
            return
        showProgress()
        mPresenter!!.submitLogin(mContext, phone, psw)
    }

    override fun LoginSuccess(t: Any?) {
        val data = t as LoginVo
        mResultTo.toRegisterAc()
    }

    override fun LoginError(ex: Throwable) {
        this.onError(ex)
    }

    override fun LoginComplise() {
        this.onComplate()
    }
}
