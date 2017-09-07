package com.penoder.study.kotlin.loop

/**
 * Created by dell on 2017/9/7.
 */

class WhenLoop {

    constructor(x: Int) {
        methodOne(x)
    }

    fun methodOne(x: Int): String {
//        switch(x)   // 果然，Kotlin中没有了类C语言中的switch操作符，而采用when来替代

        var str: String = ""

        /**
         * 感觉这个比 Java 中的switch-case好用
         */
        when (x) {
            1 -> {  // 类似lambda表达式
                str = "switch - case 1:"
                println(str)
            }   // 相当于执行到某个分支自动break
            2 -> {  // 满足 x == 2 时执行
                str = "switch - case 2:"
                println(str)
            }
            3, 4 -> {   // 满足 x == 3 或者 4 时执行，相当于前后两个case没有用到break
                str = "switch - case 3:"
                println(str)
            }
        /**
         * 语法说 When 表达式必须要 有 else分支，或者
         * 编译器能够检测出所有的可能情况都已经覆盖了。
         *
         * 但是前面调用该方法，传入的参数还有-1，
         * 666 等其他的值，此处去除else竟然没有报错
         */

//            else -> {
//                str = "x is not 1、 2、 3 or 4"
//                println(str)
//            }
        }
        return str
    }

    /**
     * when 表达式中的分支条件除了可以是上面的1、2等常量，可以是任意的表达式
     */
}