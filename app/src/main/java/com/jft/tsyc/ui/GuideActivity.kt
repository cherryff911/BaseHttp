package com.jft.tsyc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.backpacker.UtilsLibrary.java.StringUtil
import com.jft.tsyc.base.BaseActivity
import com.jft.tsyc.R
import com.jft.tsyc.adapter.GuideAdapter
import com.jft.tsyc.db.UserDbHelp
import com.jft.tsyc.fragment.GuideFragment
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
       when(isStartApp()){
           0->{
               initFragment()
               initEvent()
           }
           1->{
               finish()
               mResultTo.toLoginAc()
           }
           2->{
               finish()
               mResultTo.toMainAc()
           }
       }


    }

    fun initEvent() {
        tv_start_login.setOnClickListener {
            upDataIsStartAppMake()
            finish()
            mResultTo.toLoginAc()
        }
    }

    /**
     * @return 0 启动引导页 1 登陆 2 主界面
     */
    fun isStartApp(): Int {
        val help = UserDbHelp.get_Instance(mContext)
        val infom = help!!.getUserInfom()
        if (infom == null || infom!!.guider != "1") {
            if (StringUtil.isEmpty(infom!!.key)){
                return 2
            }else{
                return 1
            }

        }
        return 0
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
