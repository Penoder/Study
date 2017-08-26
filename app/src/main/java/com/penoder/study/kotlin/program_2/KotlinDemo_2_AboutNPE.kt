package com.penoder.study.kotlin.program_2

import android.R.attr.x
import java.lang.Integer.parseInt

/**
 * Kotlin 中关于 null 造成的 空指针异常(NPE)的情况
 * Created by dell on 2017/8/24.
 */
class KotlinDemo_2_AboutNPE {

    constructor() {
        ternaryOperator(null)
    }

    /**
     * 三目运算符
     */
    fun ternaryOperator(a: String?): Int {
//        val x = parseInt(a)
        return a?.length ?: -1
    }


}