package com.backpacker.UtilsLibrary.java;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: kotlin_androidone
 * @Package com.backpacker.UtilsLibrary.java
 * @Description: $todo
 * @author: L-BackPacker
 * @date: 2019/3/31 21:32
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019
 */
public class StringUtil {
    public static boolean isEmpty(String str) {
        if (str == null || str.equals(""))
            return true;
        return false;
    }

}
