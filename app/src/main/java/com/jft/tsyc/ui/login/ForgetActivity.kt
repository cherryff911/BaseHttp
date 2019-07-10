package com.jft.tsyc.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.backpacker.UtilsLibrary.kotlin.T
import com.backpacker.UtilsLibrary.kotlin.Util
import com.jft.tsyc.R
import com.jft.tsyc.base.BaseActivity
import com.jft.tsyc.base.DataMessageVo
import com.jft.tsyc.mvp.Contract.CodeContract
import com.jft.tsyc.mvp.Contract.ForgetContract
import com.jft.tsyc.mvp.Model.CodeModel
import com.jft.tsyc.mvp.Model.ForgetModel
import com.jft.tsyc.mvp.Presenter.CodePresenter
import com.jft.tsyc.mvp.Presenter.ForgetPresenter
import kotlinx.android.synthetic.main.activity_forget.*

/**
 * @Author : YFL  is Creating a porject in com.jft.tsyc.ui.login
 * @Package com.jft.tsyc.ui.login
 * @Email : yufeilong92@163.com
 * @Time :2019/7/9 17:49
 * @Purpose :忘记秘密
 */
class ForgetActivity : BaseActivity(), ForgetContract.View, CodeContract.View {

    private var mCodePresenter: CodePresenter? = null
    private var mForgerPresenter: ForgetPresenter? = null
    override fun setInitContentView(): Int {
        return R.layout.activity_forget
    }

    override fun onInitCreateView(savedInstanceState: Bundle?) {
        initRequest()
        initEvent()
    }

    fun initRequest() {
        mCodePresenter = CodePresenter()
        mCodePresenter!!.initMvp(this, CodeModel())
        mForgerPresenter = ForgetPresenter()
        mForgerPresenter!!.initMvp(this, ForgetModel())
    }

    fun initEvent() {
        btn_forget_send_code.setOnClickListener {
            //发送验证码
            val phone = Util.getObjToStr(et_forget_phone)
            if (Util.tShow(mContext, phone, getStringWithId(R.string.please_input_phone)))
                return@setOnClickListener
            showProgress()
            mCodePresenter!!.requestCode(mContext, DataMessageVo.Code_Retrieve, phone)
        }
        btn_froget_sure_submit.setOnClickListener {
            //提交
            submit()
        }

    }

    private fun submit() {
        val phone = Util.getObjToStr(et_forget_phone)
        if (Util.tShow(mContext, phone, getStringWithId(R.string.please_input_phone)))
            return
        val code = Util.getObjToStr(et_forget_code)
        if (Util.tShow(mContext, code, getStringWithId(R.string.please_input_phone_code)))
            return
        val psw = Util.getObjToStr(et_forget_psw)
        if (Util.tShow(mContext, psw, getStringWithId(R.string.please_input_new_psw)))
            return
        val newSure = Util.getObjToStr(et_forget_sure_psw)
        if (Util.tShow(mContext, newSure, getStringWithId(R.string.please_input_new_psw)))
            return
        if (psw != newSure) {
            toShowToasct(getString(R.string.please_psw_no))
            return
        }
        showProgress()
        mForgerPresenter!!.submiteChangerPsw(mContext, phone, code, psw)

    }

    override fun ForgetSuccess(t: Any?) {
        toShowToasct(getString(R.string.psw_changer_success))
        mResultTo.finishBase()
    }

    override fun ForgetError(ex: Throwable) {
        this.onError(ex)
    }

    override fun ForgetComplise() {
        this.onComplate()
    }

    override fun CodeSuccess(t: Any?) {
        toShowToasct(getStringWithId(R.string.code_send_success))
    }

    override fun CodeError(ex: Throwable) {
        this.onError(ex)
    }

    override fun CodeComplise() {
        this.onComplate()
    }
}
