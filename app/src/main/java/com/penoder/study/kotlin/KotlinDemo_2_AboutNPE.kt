package com.penoder.study.kotlin

/**
 * Kotlin 中关于 null 造成的 空指针异常(NPE)的情况
 * Created by dell on 2017/8/24.
 */
class KotlinDemo_2_AboutNPE {

    constructor() {
        System.out.println(elvisMethod(null))
    }

    /**
     * Elvis 表达式 ?:
     *
     * 下面的例子表示的是传入的参数str如果不为空，那么追加666输出，如果是null，追加输出2333
     * 感觉这样输出有局限性啊！不为空输出的内容好像是要该对象的方法或属性,而不能是其他想输出的内容
     */
    fun elvisMethod(str: String?): String {  // 如果参数设置不能为null，调用方法时会检测参数是不是null
        val value: String = str?.plus("666") ?: str.plus("2333")    // 此处问题？ str如果为null，那还调用.plus()方法不是会报NullPointerException吗？
        return value
    }

    /**
     * 因为 throw 和 return 在 Kotlin 中都是表达式，所以它们也可以⽤在 elvis 操作符右侧
     * 下面方法表示 不为空返回参数str，为 null 直接返回 null，当然下面只是一个例子，直接返回str就是该效果
     */
    fun elvisMethod(str: String?, a: Int): String? { // 由于返回值可能为null，所以返回的类型处必须写成String?
        return str ?: return null
    }

    /**
     * 和上面 return 类似，throw可以在数据为null的情况下抛出异常
     * Java 代码中需要 new 一个对象，Kotlin 中是可以省略掉(本身也没有) new 关键字吗？
     */
    fun elvisMethod2(str: String?, a: Boolean): String? {
//        val exception = Exception("Str May Be Cause NullPointException")
        return str ?: throw NullPointerException("Str May Be Cause NullPointException")
    }
}