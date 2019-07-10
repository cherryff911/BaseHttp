package com.jft.tsyc.fragment.home

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jft.tsyc.R
import com.jft.tsyc.base.BaseFragment


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * @Author : YFL  is Creating a porject in com.jft.tsyc.fragment.home
 * @Package com.jft.tsyc.fragment.home
 * @Email : yufeilong92@163.com
 * @Time :2019/7/10 17:02
 * @Purpose :消息
 */
class InformationFragment : BaseFragment() {


    private var param1: String? = null
    private var param2: String? = null

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InformationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun setContentView(): Int {
        return R.layout.fragment_information
    }

    override fun setInitCreatedContentView(view: View, savedInstanceState: Bundle?) {
    }


}
