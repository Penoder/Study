package com.penoder.study.kotlin.intelligentTransformation

/**
 * Is 和 !Is 用来检查对象是否符合指定类型；例如：
 * a is String 表示的是 对象 a 是不是 String 类型的
 *
 * Created by dell on 2017/9/8.
 */
class IsOrNot {
    constructor() {

    }

    /**
     * 这个方法有问题啊！参数就是String类型的，传递的参数应该是 类似 Java 中的 Object，所有类的父类
     * 可惜我暂时还不知道 该类存不存在，以及是什么
     */
    fun methodOne(str: String): Boolean {  // Kotlin 中没有 Object 类是所有类的父类吗？
        if (str is String) {
            println("检测到 str 参数就是 String 类型的，那么属于String 类型的属性和方法就能直接调用")
            println("-----------" + str.length) // 字符串追加，之前怎么遇到了不让用加号的，需要我用plus()方法
            return true
        } else {
            println(str.equals(""))
            return false
        }
    }

    /**
     * 请注意，当编译器  不能保证变量在检查和使⽤之间不可改变时，智能转换不能⽤。 更具体地，智能转换能否适⽤根据以下规则：
     *      val 局部变量⸺总是可以；
     *      val 属性⸺如果属性是 private 或 internal，或者该检查在声明属性的同⼀模块中执⾏。智能转换不适⽤于 open 的属性或者具有⾃定义 getter 的属性；
     *      var 局部变量⸺如果变量在检查和使⽤之间没有修改、并且没有在会修改它的 lambda 中捕获；
     *      var 属性⸺决不可能（因为该变量可以随时被其他代码修改）。
     */
    fun methodTwo() {

    }

}