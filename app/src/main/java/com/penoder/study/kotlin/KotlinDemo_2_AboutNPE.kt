package com.penoder.study.kotlin

/**
 * Kotlin 中关于 null 造成的 空指针异常(NPE)的情况
 * Created by dell on 2017/8/24.
 */
class KotlinDemo_2_AboutNPE {

    constructor() {
        System.out.println(elvisMethod(null))
    }


    fun elvisMethod(str: String?): String {
        val value: String = str?.plus("666") ?: "2333"
        return value
    }
}