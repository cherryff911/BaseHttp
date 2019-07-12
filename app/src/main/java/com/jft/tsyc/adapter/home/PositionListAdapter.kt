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
class PositionListAdapter(var context: Context, var infoList: MutableList<Position>) :
    BaseQuickAdapter<Position, BaseViewHolder>(R.layout.item_home_job_layout, infoList) {
    override fun convert(helper: BaseViewHolder?, item: Position?) {
        val position = helper!!.layoutPosition
        val tvTitle = helper.getView<TextView>(R.id.tv_item_home_job_title)
        val tvMoney = helper.getView<TextView>(R.id.tv_item_home_job_money)
        val tvCompany = helper.getView<TextView>(R.id.tv_item_home_job_company)
        val flTag = helper.getView<FlowLayout>(R.id.fl_item_home_job_tag)
        val ivHear = helper.getView<ImageView>(R.id.iv_item_home_job_hear)
        val tvName = helper.getView<TextView>(R.id.tv_item_home_job_name)

        item.let {
            tvTitle.text = it!!.name
            tvCompany.text = it.detail
            tvMoney.text = it.salary
            tvName.text = it.contact
            GlideUtil.LoadImager(mContext, ivHear, it.logo)
            val data = mutableListOf<String>()
            if (!StringUtil.isEmpty(it.address)) {
                data.add(it.address)
            }
            if (!StringUtil.isEmpty(it.experience)) {
                data.add(it.experience)
            }
            if (!StringUtil.isEmpty(it.educational)) {
                data.add(it.educational)
            }
            setFlayout(data, flTag)
        }

    }

    private fun setFlayout(mdata: MutableList<String>, fl: FlowLayout) {
        if (mdata.isNullOrEmpty()) return
        fl.removeAllViews()
        for (item in mdata) {
            val view = LayoutInflater.from(mContext).inflate(R.layout.item_home_postion_flaout, null)
            val tvContent = view.findViewById<TextView>(R.id.tv_item_flayout_content)
            tvContent.text = item
            fl.addView(view)
        }
    }

}