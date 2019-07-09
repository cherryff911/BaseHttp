package com.jft.tsyc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.backpacker.UtilsLibrary.kotlin.PermissionUtils
import com.jft.tsyc.base.BaseActivity
import com.jft.tsyc.R
import com.jft.tsyc.base.adapter.GuideAdapter
import com.jft.tsyc.db.UserDbHelp
import com.jft.tsyc.db.UserDbHelp.mContext
import com.jft.tsyc.db.fragment.GuideFragment
import com.yanzhenjie.permission.Permission
import kotlinx.android.synthetic.main.activity_guide.*

/**
 * @Title:
 * @Package
 * @Description: todo
 * @author: L-BackPacker
 * @date:   2019/7/6 12:41
 * @version V 1.0 xxxxxxxx
 * @verdescript  版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019/7/6
 */
class GuideActivity : BaseActivity() {
    override fun setInitContentView(): Int {
        return R.layout.activity_guide
    }

    override fun onInitCreateView(savedInstanceState: Bundle?) {
        if (isStartApp()) {
            finish()
            mResultTo.toLoginAc()
            return
        }
        initFragment()
        initEvent()
    }

    fun initEvent() {
        tv_start_login.setOnClickListener {
            upDataIsStartAppMake()
            finish()
            mResultTo.toLoginAc()
        }
    }

    fun isStartApp(): Boolean {
        val help = UserDbHelp.get_Instance(mContext)
        val infom = help!!.getUserInfom()
        if (infom == null || infom!!.guider != "1") {
            return false
        }
        return true
    }

    fun initFragment() {
        val listFragment = mutableListOf<Fragment>()
        for (postion in 0 until 3) {
            val fragment = GuideFragment.newInstance("$postion", "")
            listFragment.add(fragment)
        }
        val adapter = GuideAdapter(fm = supportFragmentManager, list = listFragment)
        viewpager_content.adapter = adapter
    }

    fun upDataIsStartAppMake() {
        val help = UserDbHelp.get_Instance(mContext)
        help!!.upDateGuiderStatus("1")
    }

}
