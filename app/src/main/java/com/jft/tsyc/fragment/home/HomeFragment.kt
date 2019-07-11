package com.jft.tsyc.fragment.home

import android.os.Bundle
import android.view.View
import com.backpacker.UtilsLibrary.kotlin.RecyclerUtils

import com.jft.tsyc.R
import com.jft.tsyc.adapter.home.HomeAdapter
import com.jft.tsyc.base.BaseFragment
import com.jft.tsyc.mvp.Contract.HomeContract
import com.jft.tsyc.mvp.Model.HomeModel
import com.jft.tsyc.mvp.Presenter.HomePresenter
import com.jft.tsyc.vo.HomeDataVo
import kotlinx.android.synthetic.main.gm_refresh_layout.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * @Author : YFL  is Creating a porject in com.jft.tsyc.fragment.home
 * @Package com.jft.tsyc.fragment.home
 * @Email : yufeilong92@163.com
 * @Time :2019/7/10 16:59
 * @Purpose :首页
 */
class HomeFragment : BaseFragment(), HomeContract.View {

    private var param1: String? = null
    private var param2: String? = null
    private var mPresenter: HomePresenter? = null

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
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
        return R.layout.fragment_home
    }

    override fun setInitCreatedContentView(view: View, savedInstanceState: Bundle?) {
        initRequest()
        initRefresh()
        gm_SmartRefreshLayout.autoRefresh()
    }

    private fun initRequest() {
        mPresenter = HomePresenter()
        mPresenter!!.initMvp(this, HomeModel())
    }

    private fun initRefresh() {
        gm_SmartRefreshLayout.setEnableLoadMore(false)
        gm_SmartRefreshLayout.setEnableAutoLoadMore(false)
        gm_SmartRefreshLayout.apply {
            setOnRefreshListener {
                loadNewData()
            }
            setOnLoadMoreListener {
            }
        }
    }

    private fun loadNewData() {
        mPresenter!!.requestHome(mContext)
    }

    override fun HomeSuccess(t: Any?) {
        val data = t as HomeDataVo
        if (gm_SmartRefreshLayout != null)
            gm_SmartRefreshLayout.finishRefresh()
        gm_SmartRefreshLayout.setEnableRefresh(true)
        gm_SmartRefreshLayout.setEnableAutoLoadMore(false)
        gm_SmartRefreshLayout.setEnableLoadMore(false)
        initAdapter(data)
    }

    private fun initAdapter(data: HomeDataVo) {
        val adapter = HomeAdapter(mContext, data)
        RecyclerUtils.setMangager(mContext, gm_rlv_content)
        gm_rlv_content.adapter = adapter
    }

    override fun HomeError(ex: Throwable) {
        this.onError(ex)
        if (gm_SmartRefreshLayout != null)
            gm_SmartRefreshLayout.finishRefresh()
    }

    override fun HomeComplise() {
        this.onComplate()
        if (gm_SmartRefreshLayout != null)
            gm_SmartRefreshLayout.finishRefresh()

    }

}
