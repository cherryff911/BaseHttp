package com.jft.tsyc.mvp.Presenter

import android.content.Context
import com.jft.tsyc.mvp.Contract.CodeContract
import com.jft.tsyc.mvp.ResultView.RequestResultInterface

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.mvp.Presenter
 * @Email : yufeilong92@163.com
 * @Time :2019/7/9 10:58
 * @Purpose :
 */
class CodePresenter : CodeContract.Presenter {
    var view: CodeContract.View? = null
    var model: CodeContract.Model? = null
    override fun initMvp(view: CodeContract.View, model: CodeContract.Model) {
        this.view = view
        this.model = model
    }

    override fun requestCode(context: Context, type: String, phone: String) {
        model!!.requestCode(context, type, phone,object :RequestResultInterface{
            override fun onError(ex: Throwable) {
                view!!.CodeError(ex)
            }

            override fun onComplise() {
                view!!.CodeComplise()
            }

            override fun <T> Success(t: T){
                view!!.CodeSuccess(t)
            }
        })
    }

}