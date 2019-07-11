package com.jft.tsyc.db

import android.content.Context
import com.jft.tsyc.base.DataMessageVo
import com.jft.tsyc.db.vo.DbKey
import com.tencent.wcdb.database.SQLiteDatabase
import com.tencent.wcdb.database.SQLiteOpenHelper

class GmDBHelp(
    context: Context?
) : SQLiteOpenHelper(context, DEFAULT_NAME, DataMessageVo.PASSWORD, null, null, DEFAULT_VERSION,
    null) {

    companion object {
        val DEFAULT_NAME: String = "skmd.db"
        val TABLE_NAME: String = "carinfom"
        var DEFAULT_VERSION: Int = 1;
        private var singletonInstance: GmDBHelp?= null
        @Synchronized fun getInstance(m:Context): GmDBHelp?{
            if (singletonInstance == null){
                singletonInstance = GmDBHelp(m)
            }
            return singletonInstance
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var carInfom = "create table " + TABLE_NAME + " (" +
                "${DbKey.id} integer primary key autoincrement," +
                "${DbKey.key} text," +//请求使用的key
                "${DbKey.userId} text," +
                "${DbKey.phone} text," +
                "${DbKey.state} text," +//实名认证 1/已经2未
                "${DbKey.ifDriver} text," +//驾驶员认证
                "${DbKey.ifCar} text," +//车辆认证
                "${DbKey.name} text," +//姓名
                "${DbKey.idnumber} text," +//身份证号码
                "${DbKey.hear} text," +//头像
                "${DbKey.plateNumber} text," +//车牌号
                "${DbKey.role} text," +//1为正驾2为副驾
                "${DbKey.guider} text," +//是否查看过启动界面
                "${DbKey.carPlateColourId} text," +//车牌颜色，蓝色-1，黄色-2，绿色-3，黄绿色-4
                "${DbKey.extend} text," +
                "${DbKey.extend_one} text," +
                "${DbKey.extend_two} text," +
                "${DbKey.extend_three} text," +
                "${DbKey.extend_four} text" +
                ");"
        db!!.execSQL(carInfom)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}