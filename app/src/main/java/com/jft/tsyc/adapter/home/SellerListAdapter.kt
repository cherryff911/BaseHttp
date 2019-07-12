package com.jft.tsyc.adapter.home

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jft.tsyc.R
import com.jft.tsyc.vo.Position
import com.jft.tsyc.vo.Store
import com.zzzh.akhalteke.utils.GlideUtil

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.adapter.home
 * @Email : yufeilong92@163.com
 * @Time :2019/7/12 9:56
 * @Purpose :商家列表
 */
class SellerListAdapter(var context: Context, var infoList: MutableList<Store>) :
    BaseQuickAdapter<Store, BaseViewHolder>(R.layout.item_home_seller_layout, infoList) {
    override fun convert(helper: BaseViewHolder?, item: Store?) {
        val position = helper!!.layoutPosition
        val ivOneStar = helper.getView<ImageView>(R.id.iv_item_home_seller_star_one)
        val ivTwoStar = helper.getView<ImageView>(R.id.iv_item_home_seller_star_two)
        val ivThreeStar = helper.getView<ImageView>(R.id.iv_item_home_seller_star_three)
        val ivfourStar = helper.getView<ImageView>(R.id.iv_item_home_seller_star_four)
        val ivfiveStar = helper.getView<ImageView>(R.id.iv_item_home_seller_star_five)
        val ivImg = helper.getView<ImageView>(R.id.iv_item_home_seller_img)
        val tvName = helper.getView<TextView>(R.id.tv_item_home_seller_name)
        val tvTag = helper.getView<TextView>(R.id.tv_item_home_seller_tag)
        val tvAddress = helper.getView<TextView>(R.id.tv_item_home_seller_address)
        val list = mutableListOf<ImageView>()
        list.add(ivOneStar)
        list.add(ivTwoStar)
        list.add(ivThreeStar)
        list.add(ivfourStar)
        list.add(ivfiveStar)
        showStart(list, item!!.store_grade)
        GlideUtil.loadQuadRangleImager(mContext, ivImg, item.image)
        tvName.text = item.store_name
        tvTag.text = item.share_info
        tvAddress.text = item.address


    }

    /**
     * @param mImags 展示的集合
     * @param number 显示几个
     */
    private fun showStart(mImags: MutableList<ImageView>, number: Int) {
        for (index in 0 until mImags.size) {
            if (index <= number - 1) {
                showOrHine(mImags[index], true)
            } else {
                showOrHine(mImags[index], false)
            }
        }
    }

    private fun showOrHine(iv: ImageView, show: Boolean) {
        iv.visibility = if (show) View.VISIBLE else View.GONE

    }
}