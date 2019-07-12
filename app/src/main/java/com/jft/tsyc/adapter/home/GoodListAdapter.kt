package com.jft.tsyc.adapter.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.backpacker.UtilsLibrary.java.StringUtil
import com.backpacker.UtilsLibrary.view.FlowLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jft.tsyc.R
import com.jft.tsyc.vo.Good
import com.jft.tsyc.vo.Position
import com.jft.tsyc.vo.Store
import com.zzzh.akhalteke.utils.GlideUtil
import org.w3c.dom.Text

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.adapter.home
 * @Email : yufeilong92@163.com
 * @Time :2019/7/12 9:56
 * @Purpose :商家列表
 */
class GoodListAdapter(var context: Context, var infoList: MutableList<Good>) :
    BaseQuickAdapter<Good, BaseViewHolder>(R.layout.item_home_good_layout, infoList) {
    override fun convert(helper: BaseViewHolder?, item: Good?) {
        val position = helper!!.layoutPosition
        val ivGoodImg = helper.getView<ImageView>(R.id.iv_item_home_good_img)
        val tvGoodTitle = helper.getView<TextView>(R.id.tv_item_home_good_title)
        val tvGoodType = helper.getView<TextView>(R.id.tv_item_home_good_type)
        val tvGoodNumber = helper.getView<TextView>(R.id.tv_item_home_good_number)
        val tvGoodTag = helper.getView<TextView>(R.id.tv_item_home_good_tag)
        val tvGoodMoney = helper.getView<TextView>(R.id.tv_item_home_good_money)
        val tvGoodMoneyTag = helper.getView<TextView>(R.id.tv_item_home_good_money_tag)
        val tvGoodMoneyMoney = helper.getView<TextView>(R.id.tv_item_home_good_money_money)
        val tvGoodMoneyType = helper.getView<TextView>(R.id.tv_item_home_good_money_type)
        item.let {
            GlideUtil.LoadImager(mContext, ivGoodImg, it!!.goods_image)
            tvGoodTitle.text = it.goods_name
            tvGoodMoney.text = "￥${it.goods_promotion_price}"
            tvGoodMoneyMoney.text = it.commission_money
            tvGoodMoneyTag.text = it.commission_type
            tvGoodMoneyType.text = it.commission_text
            tvGoodType.text = it.salenum_text
            tvGoodNumber.text = it.goods_salenum.toString()
            tvGoodTag.text = it.share_text
        }

    }


}