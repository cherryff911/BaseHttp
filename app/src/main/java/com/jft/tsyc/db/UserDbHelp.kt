package com.jft.tsyc.db


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.backpacker.UtilsLibrary.kotlin.DbQueryUtil
import com.backpacker.UtilsLibrary.kotlin.StringUtil
import com.jft.tsyc.base.db.GmDBHelp
import com.jft.tsyc.base.db.vo.UserDbVo
import com.jft.tsyc.db.vo.DbKey
import com.tencent.wcdb.database.SQLiteDatabase
import java.lang.Exception

/**
 * @Author : YFL  is Creating a porject in Lenovo
 * @Email : yufeilong92@163.com
 * @Time :2019/3/8 14:31
 * @Purpose :用户信息帮助类、
 */

@SuppressLint("StaticFieldLeak")
object UserDbHelp {

    @Volatile
    private var _singleton: UserDbHelp? = null
    var mContext: Context? = null
    var mSqLiteDatabase: SQLiteDatabase? = null
    var mDbQueryUtil: DbQueryUtil? = null;
    fun UserDbHelp(context: Context): UserDbHelp? {
        mContext = context
        mSqLiteDatabase = createtable();
        mDbQueryUtil = DbQueryUtil()
        return this
    }

    fun get_Instance(context: Context): UserDbHelp? {
        if (_singleton == null) {
            synchronized(UserDbHelp::class.java) {
                if (_singleton == null) {
                    _singleton = UserDbHelp(context)
                }
            }
        }
        return _singleton
    }

    fun createtable(): SQLiteDatabase {
        var userHelp = GmDBHelp.getInstance(mContext!!)
        return userHelp!!.writableDatabase
    }


    //保存用户信息
    fun addUseInfom(
            id: String?, token: String?, phone: String?,
            ifReal: String?, ifDriver: String?,
            ifcar: String?, name: String?, number: String?, hear: String?,
            plateNumber: String?, role: String?, carPlateColourId: String?
    ) {
        isRead()
        mSqLiteDatabase!!.delete(GmDBHelp.TABLE_NAME, null, null)
        mSqLiteDatabase!!.beginTransaction()
        try {
            val conVal = ContentValues()
            conVal.put(DbKey.userId, id)
            conVal.put(DbKey.key, token)
            conVal.put(DbKey.phone, phone)
            conVal.put(DbKey.state, ifReal)
            conVal.put(DbKey.ifDriver, ifDriver)
            conVal.put(DbKey.ifCar, ifcar)
            conVal.put(DbKey.name, name)
            conVal.put(DbKey.idnumber, number)
            conVal.put(DbKey.hear, hear)
            conVal.put(DbKey.plateNumber, plateNumber)
            conVal.put(DbKey.role, role)
            conVal.put(DbKey.carPlateColourId, carPlateColourId)
            mSqLiteDatabase!!.insert(GmDBHelp.TABLE_NAME, null, conVal)
            mSqLiteDatabase!!.setTransactionSuccessful()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mSqLiteDatabase!!.endTransaction()
        }

    }

    /**
     * 更新头像
     */
    fun upHearInfom(hear: String?){
        isRead()
        val userInfom = getUserInfom()
        if (userInfom==null||StringUtil.isEmpty(userInfom.key)){
            return
        }
        mSqLiteDatabase!!.beginTransaction()
        try {
            val conVal = ContentValues()
            conVal.put(DbKey.hear, hear)
            mSqLiteDatabase!!.update(GmDBHelp.TABLE_NAME, conVal, "${DbKey.userId}=?",
                    arrayOf(userInfom.userId))
            mSqLiteDatabase!!.setTransactionSuccessful()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mSqLiteDatabase!!.endTransaction()
        }
    }
    //保存用户信息
    fun updateUserInfom(
        id: String?, phone: String?,
        ifReal: String?, ifDriver: String?,
        ifcar: String?, name: String?, number: String?, hear: String?,
        plateNumber: String?, role: String?, carPlateColourId: String?, ifVert: String?
    ) {
        isRead()
        val userInfom = getUserInfom()
        if (userInfom == null || StringUtil.isEmpty(userInfom.key)) {
            return
        }
        mSqLiteDatabase!!.beginTransaction()
        try {
            val conVal = ContentValues()
            conVal.put(DbKey.userId, id)
            conVal.put(DbKey.phone, phone)
            conVal.put(DbKey.state, ifReal)
            conVal.put(DbKey.ifDriver, ifDriver)
            conVal.put(DbKey.ifCar, ifcar)
            conVal.put(DbKey.name, name)
            conVal.put(DbKey.idnumber, number)
            conVal.put(DbKey.hear, hear)
            conVal.put(DbKey.plateNumber, plateNumber)
            conVal.put(DbKey.role, role)
            conVal.put(DbKey.extend, ifVert)
            conVal.put(DbKey.carPlateColourId, carPlateColourId)
            mSqLiteDatabase!!.update(GmDBHelp.TABLE_NAME, conVal, "${DbKey.userId}=?",
                    arrayOf(userInfom.userId))
            mSqLiteDatabase!!.setTransactionSuccessful()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mSqLiteDatabase!!.endTransaction()
        }

    }

    //更新实名认证状态
    fun upReal(str: String, name: String?, phone: String?, number: String?, portrait: String?) {
        isRead()
        val userInfom = getUserInfom()
        if (userInfom == null || StringUtil.isEmpty(userInfom.key)) {
            return
        }
        mSqLiteDatabase!!.beginTransaction()
        try {
            val contvalue = ContentValues()
            contvalue.put(DbKey.state, str)
            contvalue.put(DbKey.name, name)
            contvalue.put(DbKey.phone, phone)
            contvalue.put(DbKey.idnumber, number)
            contvalue.put(DbKey.hear, portrait)
            mSqLiteDatabase!!.update(
                    GmDBHelp.TABLE_NAME, contvalue, "${DbKey.userId}=?"
                    , arrayOf(userInfom.userId)
            )
            mSqLiteDatabase!!.setTransactionSuccessful()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mSqLiteDatabase!!.endTransaction()

        }

//        val newInfom = UserDbVo()
//        newInfom.ifReal = str
//        mSqLiteDatabase!!.delete(GmDBHelp.TABLE_NAME, null, null)
//        val copyVo = copyVo(userInfom, newInfom)
//        mSqLiteDatabase!!.insert(GmDBHelp.TABLE_NAME, null, copyVo)
    }

    //更新驾驶员证状态
    fun upDriver(str: String, role: String) {
        isRead()
        val userInfom = getUserInfom()
        if (userInfom == null || StringUtil.isEmpty(userInfom.key)) {
            return
        }
        mSqLiteDatabase!!.beginTransaction()
        try {
            val contvalue = ContentValues()
            contvalue.put(DbKey.ifDriver, str)
            contvalue.put(DbKey.role, role)
            mSqLiteDatabase!!.update(
                    GmDBHelp.TABLE_NAME, contvalue, "${DbKey.userId}=?"
                    , arrayOf(userInfom.userId)
            )
            mSqLiteDatabase!!.setTransactionSuccessful()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mSqLiteDatabase!!.endTransaction()
        }


    }

    //更新车辆任证状态
    fun upCar(str: String, plateNumber: String, carPlateColourId: String) {
        isRead()
        val userInfom = getUserInfom()
        if (userInfom == null || StringUtil.isEmpty(userInfom.key)) {
            return
        }
        mSqLiteDatabase!!.beginTransaction()
        try {
            val contvalue = ContentValues()
            contvalue.put(DbKey.ifCar, str)
            contvalue.put(DbKey.plateNumber, plateNumber)
            contvalue.put(DbKey.carPlateColourId, carPlateColourId)
            mSqLiteDatabase!!.update(
                    GmDBHelp.TABLE_NAME, contvalue, "${DbKey.userId}=?"
                    , arrayOf(userInfom.userId)
            )
            mSqLiteDatabase!!.setTransactionSuccessful()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mSqLiteDatabase!!.endTransaction()
        }

//        val newInfom = UserDbVo()
//        newInfom.ifCar = str
//        mSqLiteDatabase!!.delete(GmDBHelp.TABLE_NAME, null, null)
//        val copyVo = copyVo(userInfom, newInfom)
//        mSqLiteDatabase!!.insert(GmDBHelp.TABLE_NAME, null, copyVo)
    }

    fun clear() {
        isRead()
        mSqLiteDatabase!!.delete(GmDBHelp.TABLE_NAME, null, null)
    }


    fun getUserInfom(): UserDbVo? {
        isRead()
        val cursor = mSqLiteDatabase!!.query(GmDBHelp.TABLE_NAME, null, null, null, null, null, null)
        mDbQueryUtil!!.initCursor(cursor)

        while (cursor.moveToNext()) {
            val vo = getContentValue(mDbQueryUtil!!)
            cursor.close()
            return vo;
        }
        cursor.close()
        return null;

    }

    fun upDateGuiderStatus(look: String) {
        isRead()
        val content = ContentValues()
        content.put(DbKey.guider, look)
        val userInfom = getUserInfom()
        if (userInfom == null || StringUtil.isEmpty(userInfom.userId))
            mSqLiteDatabase!!.insert(GmDBHelp.TABLE_NAME, null, content)
        else {
            mSqLiteDatabase!!.update(GmDBHelp.TABLE_NAME, content, "${DbKey.userId}=?",
                    arrayOf(userInfom.userId))
        }
    }

    private fun isRead() {
        if (mSqLiteDatabase == null || mSqLiteDatabase!!.isReadOnly) {
            return
        }
    }

    private fun copyVo(old: UserDbVo, new: UserDbVo): ContentValues {
        val values: ContentValues = ContentValues()
        if (StringUtil.isEmpty(new.key)) {
            values.put(DbKey.key, old.key)
        } else {
            values.put(DbKey.key, new.key)
        }
        if (StringUtil.isEmpty(new.userId)) {
            values.put(DbKey.userId, old.userId)
        } else {
            values.put(DbKey.userId, new.userId)
        }
        if (StringUtil.isEmpty(new.phone)) {
            values.put(DbKey.phone, old.phone)
        } else {
            values.put(DbKey.phone, new.phone)
        }
        if (StringUtil.isEmpty(new.state)) {
            values.put(DbKey.state, old.state)
        } else {
            values.put(DbKey.state, new.state)
        }
        if (StringUtil.isEmpty(new.ifDriver)) {
            values.put(DbKey.ifDriver, old.ifDriver)
        } else {
            values.put(DbKey.ifDriver, new.ifDriver)
        }
        if (StringUtil.isEmpty(new.ifCar)) {
            values.put(DbKey.ifCar, old.ifCar)
        } else {
            values.put(DbKey.ifCar, new.ifCar)
        }
        if (StringUtil.isEmpty(new.extend)) {
            values.put(DbKey.extend, old.extend)
        } else {
            values.put(DbKey.extend, new.extend)
        }
        if (StringUtil.isEmpty(new.extend_one)) {
            values.put(DbKey.extend_one, old.extend_one)
        } else {
            values.put(DbKey.extend_one, new.extend_one)
        }
        if (StringUtil.isEmpty(new.extend_two)) {
            values.put(DbKey.extend_two, old.extend_two)
        } else {
            values.put(DbKey.extend_two, new.extend_two)
        }
        if (StringUtil.isEmpty(new.extend_three)) {
            values.put(DbKey.extend_three, old.extend_three)
        } else {
            values.put(DbKey.extend_three, new.extend_three)
        }
        if (StringUtil.isEmpty(new.extend_four)) {
            values.put(DbKey.extend_four, old.extend_four)
        } else {
            values.put(DbKey.extend_four, new.extend_four)
        }
        return values;

    }

    private fun getContentValue(mDbQueryUtil: DbQueryUtil): UserDbVo {
        val vo: UserDbVo = UserDbVo()
        val id = mDbQueryUtil.queryInt(DbKey.id)
        val userId = mDbQueryUtil.queryString(DbKey.userId)
        val token = mDbQueryUtil.queryString(DbKey.key)
        val phone = mDbQueryUtil.queryString(DbKey.phone)
        val ifReal = mDbQueryUtil.queryString(DbKey.state)
        val ifDriver = mDbQueryUtil.queryString(DbKey.ifDriver)
        val ifCar = mDbQueryUtil.queryString(DbKey.ifCar)
        val name = mDbQueryUtil.queryString(DbKey.name)
        val idnumber = mDbQueryUtil.queryString(DbKey.idnumber)
        val hear = mDbQueryUtil.queryString(DbKey.hear)
        val plateNumber = mDbQueryUtil.queryString(DbKey.plateNumber)
        val role = mDbQueryUtil.queryString(DbKey.role)
        val extend = mDbQueryUtil.queryString(DbKey.extend)
        val extent_one = mDbQueryUtil.queryString(DbKey.extend_one)
        val extend_two = mDbQueryUtil.queryString(DbKey.extend_two)
        val extend_three = mDbQueryUtil.queryString(DbKey.extend_three)
        val extend_four = mDbQueryUtil.queryString(DbKey.extend_four)
        val guider = mDbQueryUtil.queryString(DbKey.guider)
        val carPlateColourId = mDbQueryUtil.queryString(DbKey.carPlateColourId)
        vo.id = id ?: 0
        vo.guider = guider ?: "0"
        vo.carPlateColourId = carPlateColourId ?: "0"
        vo.key = token ?: ""
        vo.userId = userId ?: ""
        vo.phone = phone ?: ""
        vo.ifCar = ifCar ?: ""
        vo.ifDriver = ifDriver ?: ""
        vo.state = ifReal ?: ""
        vo.extend = extend ?: ""
        vo.extend_one = extent_one ?: ""
        vo.extend_two = extend_two ?: ""
        vo.extend_three = extend_three ?: ""
        vo.extend_four = extend_four ?: ""
        vo.name = name ?: ""
        vo.hear = hear ?: ""
        vo.idnumber = idnumber ?: ""
        vo.plateNumber = plateNumber ?: ""
        vo.role = role ?: ""
        return vo;
    }


}