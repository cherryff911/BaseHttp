package com.jft.tsyc.application

import android.app.Application
import com.backpacker.UtilsLibrary.kotlin.AppBarUtil
import com.jft.tsyc.R
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.tencent.bugly.crashreport.CrashReport

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.example.tsyc.Application
 * @Email : yufeilong92@163.com
 * @Time :2019/7/5 16:44
 * @Purpose :
 */
class MyApplication : Application() {
    companion object{
        private var instance: MyApplication? = null
        fun toInstance(): MyApplication {
            return instance!!
        }

        init {
            SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
                layout.setPrimaryColorsId(R.color.main_bg, R.color.main_text9)
                return@setDefaultRefreshHeaderCreator ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate)
            }

            SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
                return@setDefaultRefreshFooterCreator ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate)
            }
        }

    }

    override fun onCreate() {
        super.onCreate()
        initbug()
        initData()
    }

    fun initbug() {
        CrashReport.initCrashReport(applicationContext)
    }
    fun initData(){
        AppBarUtil.obtainScreenWH(this)
    }
}