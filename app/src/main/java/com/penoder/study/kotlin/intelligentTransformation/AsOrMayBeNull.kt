package com.penoder.study.kotlin.intelligentTransformation

/**
 * Created by dell on 2017/9/8.
 */
class AsOrMayBeNull {

    constructor() {

    }

    /**
     * 也就是 as 并不能将某个类型 转换成 想要的类型，
     * 因此有点像Java中的向下转型等的需要可以转换过来的才行，
     * 为了避免报类型转换异常的错，需要有开发者自己控制是不是可以相互之间转换
     */
    fun methodOne(str: String): String {
        val a: Int = str as Int // Caused by: java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        println(a)

        return "" + a   // 这个追加有趣， { a + "" = 报错}、{"" + a = a 的字符串形式}
    }
}