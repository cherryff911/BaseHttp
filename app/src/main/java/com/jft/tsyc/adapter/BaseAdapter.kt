package com.jft.tsyc.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jft.tsyc.R

class BaseAdapter(var context: Context, var infoList: MutableList<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_test, infoList) {

    override fun convert(helper: BaseViewHolder?, item: String?) {
        val position = helper!!.layoutPosition
    }

}