package com.jft.tsyc.adapter.home

import android.content.Context
import android.os.Build.VERSION_CODES.M
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.jft.tsyc.R
import com.tencent.bugly.proguard.m

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.adapter.home
 * @Email : yufeilong92@163.com
 * @Time :2019/7/10 17:12
 * @Purpose :首页适配器
 */
class homeAdapter(val mContext: Context, mlist: MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val MAIN_BANNER: Int = 1001//轮播图
    private val MAIN_WARE: Int = 1002//商品
    private val MAIN_SELLER: Int = 1003//商家
    private val MAIN_JOB: Int = 1004//职位
    private val MAIN_COMPETITIVE: Int = 1005//精品
    private var MAIN_COMMON: Int = MAIN_BANNER
    private var mInflater: LayoutInflater? = null

    init {
        mInflater = LayoutInflater.from(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            MAIN_BANNER -> {
                return BannerViewHodle(mInflater!!.inflate(R.layout.item_home_banner, null))
            }
            MAIN_WARE -> {
                return WAREViewHodle(mInflater!!.inflate(R.layout.item_home_ware, null))
            }
            MAIN_SELLER -> {
                return SELLERViewHodle(mInflater!!.inflate(R.layout.item_home_seller, null))
            }
            MAIN_JOB -> {
                return JOBViewHodle(mInflater!!.inflate(R.layout.item_home_job, null))
            }
            MAIN_COMPETITIVE -> {
                return COMPETITIVEViewHodle(mInflater!!.inflate(R.layout.item_home_competitive, null))
            }
            else -> {
                return COMPETITIVEViewHodle(mInflater!!.inflate(R.layout.item_home_competitive, null))
            }
        }

    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
            0 -> {
                MAIN_COMMON = MAIN_BANNER
            }
            1 -> {
                MAIN_COMMON = MAIN_WARE
            }
            2 -> {
                MAIN_COMMON = MAIN_SELLER
            }
            3 -> {
                MAIN_COMMON = MAIN_JOB
            }
            4 -> {
                MAIN_COMMON = MAIN_COMPETITIVE
            }
            else -> {
                MAIN_COMMON = MAIN_COMPETITIVE
            }
        }
        return MAIN_COMMON

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    /**
     * 轮播图
     */
    inner class BannerViewHodle(var item: View) : RecyclerView.ViewHolder(item) {

    }

    fun initBanner(holder: BannerViewHodle) {

    }

    /**
     * 商品
     */
    inner class WAREViewHodle(var item: View) : RecyclerView.ViewHolder(item) {

    }

    fun initWare(holde: WAREViewHodle) {

    }

    /***
     * 商家
     */
    inner class SELLERViewHodle(var item: View) : RecyclerView.ViewHolder(item) {

    }

    fun initSellerv(holder: SELLERViewHodle) {

    }

    /***
     * 职位
     */
    inner class JOBViewHodle(var item: View) : RecyclerView.ViewHolder(item) {

    }

    fun initJob(holder: JOBViewHodle) {

    }

    /**
     * 精品
     */
    inner class COMPETITIVEViewHodle(var item: View) : RecyclerView.ViewHolder(item) {

    }

    fun initCompetitive(holder: COMPETITIVEViewHodle) {

    }


}


