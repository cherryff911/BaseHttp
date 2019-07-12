package com.jft.tsyc.adapter.home

import android.content.Context
import android.os.Build.VERSION_CODES.M
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.backpacker.UtilsLibrary.kotlin.RecyclerUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.jft.tsyc.R
import com.jft.tsyc.db.UserDbHelp.mContext
import com.jft.tsyc.vo.HomeDataVo
import com.tencent.bugly.proguard.m
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import com.youth.banner.loader.ImageLoaderInterface
import com.zzzh.akhalteke.utils.GlideUtil
import java.util.ArrayList

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.adapter.home
 * @Email : yufeilong92@163.com
 * @Time :2019/7/10 17:12
 * @Purpose :首页适配器
 */
class HomeAdapter(val mContext: Context, var mData: HomeDataVo) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BannerViewHodle -> {
                initBanner(holder as BannerViewHodle)
            }
            is WAREViewHodle -> {
                initWare(holder as WAREViewHodle)
            }
            is SELLERViewHodle -> {
                initSellerv(holder as SELLERViewHodle)
            }
            is JOBViewHodle -> {
                initJob(holder as JOBViewHodle)
            }
            is COMPETITIVEViewHodle -> {
                initCompetitive(holder as COMPETITIVEViewHodle)
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


    /**
     * 轮播图
     */
    inner class BannerViewHodle(var item: View) : RecyclerView.ViewHolder(item) {
        val mViewFlipper = item.findViewById<ViewFlipper>(R.id.viewflipper)
        val mBanner = item.findViewById<Banner>(R.id.item_main_home_banner)
        val mIvSearch = item.findViewById<ImageView>(R.id.iv_home_search)
        val mIvScan = item.findViewById<ImageView>(R.id.iv_home_scan)
        val mEtInput = item.findViewById<EditText>(R.id.et_home_input)


    }

    fun initBanner(holder: BannerViewHodle) {
        setFlipper(holder)
        setBanner(holder)
    }

    private fun setBanner(holder: BannerViewHodle) {
        val imgs = ArrayList<String>()
        val banner = mData.banner
        if (!banner.isNullOrEmpty()) {
            for (item in banner) {
                imgs.add(item.url)
            }
        }
        holder.mBanner.setBannerStyle(BannerConfig.NOT_INDICATOR)
        holder.mBanner.setIndicatorGravity(BannerConfig.CENTER)
        holder.mBanner.setDelayTime(2000)
        holder.mBanner.setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context, path: Any, imageView: ImageView) {
                imageView.scaleType = ImageView.ScaleType.FIT_XY
                GlideUtil.loadQuadRangleImager(context, imageView, path.toString())
            }
        })
        holder.mBanner.setImages(imgs)
        holder.mBanner.start()
        holder.mBanner.setOnBannerListener {

        }
    }

    //字体轮播
    private fun setFlipper(holder: BannerViewHodle) {
        val childView = View.inflate(mContext, R.layout.item_viewflipper, null)
        val tv_content = childView.findViewById<TextView>(R.id.tv_advertisingone)
        tv_content.text = "222222222222222222"
        holder.mViewFlipper.addView(childView)
        holder.mViewFlipper.startFlipping()
    }

    /**
     * 商品
     */
    inner class WAREViewHodle(var item: View) : RecyclerView.ViewHolder(item) {
        val mTvRightTitle = item.findViewById<TextView>(R.id.tv_item_home_right_title)
        val mTvRightType = item.findViewById<TextView>(R.id.tv_item_home_right_type)
        val mTvRightContent = item.findViewById<TextView>(R.id.tv_item_home_right_content)
        val mIvRightContent = item.findViewById<ImageView>(R.id.iv_item_right_content)
        val mTvLiftOneTitle = item.findViewById<TextView>(R.id.tv_item_home_lift_one_title)
        val mTvLiftOneContent = item.findViewById<TextView>(R.id.tv_item_home_lift_one_content)
        val mTvLiftOneType = item.findViewById<TextView>(R.id.tv_item_home_lift_one_type)
        val mIvLiftOne = item.findViewById<ImageView>(R.id.iv_home_lift_one)
        val mTvLiftTwoTitle = item.findViewById<TextView>(R.id.tv_item_home_lift_two_title)
        val mTvLiftTwoContent = item.findViewById<TextView>(R.id.tv_item_home_lift_two_content)
        val mTvLiftTwoType = item.findViewById<TextView>(R.id.tv_item_home_lift_two_type)
        val mIvLiftTwo = item.findViewById<ImageView>(R.id.iv_item_home_lift_two)
        val mIvSellerGo = item.findViewById<ImageView>(R.id.iv_home_seller_go)
        val mIvMoneyGo = item.findViewById<ImageView>(R.id.iv_home_money_go)
    }

    fun initWare(holde: WAREViewHodle) {
        val recommend = mData.recommend
        val rightItem = recommend!![0]
        holde.mTvRightTitle.text = rightItem.name
        holde.mTvRightContent.text = rightItem.note
        holde.mTvRightType.text = rightItem.types
        GlideUtil.LoadImager(mContext, holde.mIvRightContent, rightItem.image)
        val liftItem = recommend!![1]
        holde.mTvLiftOneTitle.text = liftItem.name
        holde.mTvLiftOneContent.text = liftItem.note
        holde.mTvLiftOneType.text = liftItem.types
        GlideUtil.LoadImager(mContext, holde.mIvLiftOne, liftItem.image)
        val liftTwoItem = recommend!![2]
        holde.mTvLiftTwoTitle.text = liftTwoItem.name
        holde.mTvLiftTwoContent.text = liftTwoItem.note
        holde.mTvLiftTwoType.text = liftTwoItem.types
        GlideUtil.LoadImager(mContext, holde.mIvLiftTwo, liftTwoItem.image)
    }


    /***
     * 商家
     */
    inner class SELLERViewHodle(var item: View) : RecyclerView.ViewHolder(item) {
        val mRlvItemContent = item.findViewById<RecyclerView>(R.id.rlv_item_home_seller_content)
    }

    fun initSellerv(holder: SELLERViewHodle) {
        val store = mData.store
        RecyclerUtils.setMangager(mContext, holder.mRlvItemContent)
        val adapter = SellerListAdapter(mContext, store!!)
        holder.mRlvItemContent.adapter = adapter
    }

    /***
     * 职位
     */
    inner class JOBViewHodle(var item: View) : RecyclerView.ViewHolder(item) {
        val mRlvItemContent = item.findViewById<RecyclerView>(R.id.rlv_item_home_job_content)
    }

    fun initJob(holder: JOBViewHodle) {
        val store = mData.position
        RecyclerUtils.setMangager(mContext, holder.mRlvItemContent)
        val adapter = PositionListAdapter(mContext, store!!)
        holder.mRlvItemContent.adapter = adapter
    }

    /**
     * 精品
     */
    inner class COMPETITIVEViewHodle(var item: View) : RecyclerView.ViewHolder(item) {
        val mRlvItemContent = item.findViewById<RecyclerView>(R.id.rlv_competitive_content)
    }

    fun initCompetitive(holder: COMPETITIVEViewHodle) {
        val store = mData.goods
        RecyclerUtils.setMangager(mContext, holder.mRlvItemContent, 2, GridLayoutManager.VERTICAL)
        val adapter = GoodListAdapter(mContext, store!!)
        holder.mRlvItemContent.adapter = adapter

    }


}


