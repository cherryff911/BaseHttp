package com.jft.tsyc

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.backpacker.UtilsLibrary.kotlin.FragmentUtil
import com.jft.tsyc.base.BaseActivity
import com.jft.tsyc.R
import com.jft.tsyc.adapter.GuideAdapter
import com.jft.tsyc.fragment.home.FindFragment
import com.jft.tsyc.fragment.home.HomeFragment
import com.jft.tsyc.fragment.home.InformationFragment
import com.jft.tsyc.fragment.home.MeFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @Title:  主界面
 * @Package com.example.tsyc
 * @Description: 主界面
 * @author: L-BackPacker
 * @date:   2019/7/6 15:01
 * @version V 1.0 xxxxxxxx
 * @verdescript  版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019/7/6
 */

class MainActivity : BaseActivity() {

    override fun setInitContentView(): Int {
        return R.layout.activity_main
    }

    override fun onInitCreateView(savedInstanceState: Bundle?) {
        initFragment()
    }

    fun initFragment() {
        val mFragmentList = mutableListOf<Fragment>()
        val home = HomeFragment.newInstance("", "")
        val find = FindFragment.newInstance("", "")
        val information = InformationFragment.newInstance("", "")
        val me = MeFragment.newInstance("", "")
        mFragmentList.add(home)
        mFragmentList.add(find)
        mFragmentList.add(information)
        mFragmentList.add(me)
        val mSfm = supportFragmentManager
        for (fragment in mFragmentList) {
            val transcation = mSfm.beginTransaction()
            transcation.add(R.id.fragment_main_content, fragment).hide(fragment).commit()
        }
        mSfm.beginTransaction().show(mFragmentList[0]).commit()
        rdg_layout.setOnCheckedChangeListener { radioGroup, i ->
            val mSfm = supportFragmentManager
            when (i) {
                R.id.rdb_select_home -> {
                    FragmentUtil.showSelectFragment(mSfm, mFragmentList, R.id.fragment_main_content, 0)
                }
                R.id.rdb_select_find -> {
                    FragmentUtil.showSelectFragment(mSfm, mFragmentList, R.id.fragment_main_content, 1)
                }
                R.id.rdb_select_infom -> {
                    FragmentUtil.showSelectFragment(mSfm, mFragmentList, R.id.fragment_main_content, 2)
                }
                R.id.rdb_select_me -> {
                    FragmentUtil.showSelectFragment(mSfm, mFragmentList, R.id.fragment_main_content, 3)
                }
            }
        }


    }
}
