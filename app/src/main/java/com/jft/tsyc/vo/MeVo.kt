package com.jft.tsyc.vo

/**
 * @Author : YFL  is Creating a porject in tsyc
 * @Package com.jft.tsyc.vo
 * @Email : yufeilong92@163.com
 * @Time :2019/7/12 17:56
 * @Purpose :
 */
data class MeVo(
    val avatar: String="",
    val bindAliPayStatus: Int=0,
    val bindBankStatus: Int=0,
    val bindWeChatStatus: Int=0,
    val grade_status: Int=0,
    val invite_code: String="",
    val invite_qrcode: String="",
    val is_store: Int=0,
    val member_id: Int=0,
    val member_points: Int=0,
    val my_balance: Int=0,
    val my_grade: String="",
    val myvoucher: Int=0,
    val phone: String="",
    val share_link: String="",
    val user_name: String=""
)

