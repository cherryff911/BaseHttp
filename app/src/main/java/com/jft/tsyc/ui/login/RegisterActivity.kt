package com.jft.tsyc.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.backpacker.UtilsLibrary.java.CountdownUtil
import com.backpacker.UtilsLibrary.kotlin.T
import com.backpacker.UtilsLibrary.kotlin.Util
import com.jft.tsyc.R
import com.jft.tsyc.base.BaseActivity
import com.jft.tsyc.base.DataMessageVo
import com.jft.tsyc.db.UserDbHelp
import com.jft.tsyc.mvp.Contract.CodeContract
import com.jft.tsyc.mvp.Contract.RegisterContract
import com.jft.tsyc.mvp.Model.CodeModel
import com.jft.tsyc.mvp.Model.RegisterModel
import com.jft.tsyc.mvp.Presenter.CodePresenter
import com.jft.tsyc.mvp.Presenter.RegisterPresenter
import com.jft.tsyc.vo.LoginVo
import com.jft.tsyc.vo.RegisterVo
import kotlinx.android.synthetic.main.activity_register.*

/**
 * @Author : YFL  is Creating a porject in com.jft.tsyc.ui.login
 * @Package com.jft.tsyc.ui.login
 * @Email : yufeilong92@163.com
 * @Time :2019/7/8 20:07
 * @Purpose :注册界面
 */
class RegisterActivity : BaseActivity(), RegisterContract.View, CodeContract.View {


    private var mPresenter: RegisterPresenter? = null
    private var mCodePresenter: CodePresenter? = null

    override fun setInitContentView(): Int {
        return R.layout.activity_register
    }

    override fun onInitCreateView(savedInstanceState: Bundle?) {
        initRequest()
        initEvent()
    }

    fun initRequest() {
        mPresenter = RegisterPresenter()
        mPresenter!!.initMvp(this, RegisterModel())
        mCodePresenter = CodePresenter()
        mCodePresenter!!.initMvp(this, CodeModel())
    }

    fun initEvent() {
        btn_register_right.setOnClickListener {
            reqeustCode()
        }
        btn_register_reigster.setOnClickListener {
            submit()
        }
        iv_register_phone_right.setOnClickListener {
            et_register_phone.setText("")
        }
    }

    fun reqeustCode() {
        val phone = Util.getObjToStr(et_register_phone)
        if (Util.tShow(mContext, phone, getStringWithId(R.string.please_input_phone)))
            return
        showProgress()

        mCodePresenter!!.requestCode(mContext, DataMessageVo.Code_Register, phone)
    }

    fun submit() {
        val phone = Util.getObjToStr(et_register_phone)
        if (Util.tShow(mContext, phone, getStringWithId(R.string.please_input_phone)))
            return
        val code = Util.getObjToStr(et_register_code)
        if (Util.tShow(mContext, code, getStringWithId(R.string.please_input_code)))
            return
        val psw = Util.getObjToStr(et_register_psw)
        if (Util.tShow(mContext, psw, getStringWithId(R.string.please_input_psw)))
            return
        val invite = Util.getObjToStr(et_register_invite)
        if (Util.tShow(mContext, invite, getStringWithId(R.string.please_input_invte)))
            return
        showProgress()
        mPresenter!!.submitRegister(mContext, phone, code, psw, invite)
    }

    override fun RegisterSuccess(t: Any?) {
        val data = t as LoginVo
        DataMessageVo.UserInfom = data
        UserDbHelp.addUseInfomData(data.key, data.username, data.state,data.userid)
        mResultTo.toMainAc()
    }

    override fun RegisterError(ex: Throwable) {
        this.onError(ex)
    }

    override fun RegisterComplise() {
        this.onComplate()
    }

    override fun CodeSuccess(t: Any?) {
        CountdownUtil.getInstance().startTime(mContext, btn_register_right)
        toShowToasct(getString(R.string.code_send_success))
    }

    override fun CodeError(ex: Throwable) {
        this.onError(ex)
    }

    override fun CodeComplise() {
        this.onComplate()
    }

    override fun onDestroy() {
        super.onDestroy()
        CountdownUtil.getInstance().stop()
    }
}
