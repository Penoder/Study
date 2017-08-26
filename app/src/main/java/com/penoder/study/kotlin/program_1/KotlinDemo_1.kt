package com.penoder.study.kotlin.program_1

import com.penoder.study.rxJava2.RxDemo_1 as rx_demo    // 导入的类如果名字相同，可以使用 as 设置别名

/**
 * Created by dell on 2017/8/23.
 */
class KotlinDemo_1 {

    /**
     * 构造方法采用 constructor表示
     */
    constructor() {
        System.out.println("父类的无参的构造方法")
    }

    constructor(a: Int) {
        System.out.println("父类的带参的构造方法")
    }

    /**
     * 函数的声明，fun关键字表示定义一个方法， methodOne 为方法名；方法中有两个 int 型的参数 a 和 b
     * 然后该方法返回一个 int 类型的数字
     */
    fun methodOne(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 方法可以重载，利用等式的写法，可以自动辨别返回值的类型为 int
     */
    fun methodOne(a: Int, b: Int, c: Int) = a + b

    /**
     * 没有返回值 后面就不要 写 : Void 了；无返回值可以写 : Unit 也可以不写
     */
    fun methodTwo(str: String) /*: Unit*/ {
        /**
         * 定义局部变量(采用 val 关键字来声明变量)时需要明确类型或者初始化
         * 在使用 局部变量之前 要初始化数据
         * 同 Java, 但是局部变量赋值之后，不能再次赋值
         */
        val a: Int = 1 // ⽴即赋值
        val b = 2 // ⾃动推断出 `Int` 类型
        val c: Int // 如果没有初始值类型不能省略
        c = 3 // 明确赋值

        /**
         * 采用 var 声明变量可以再次的改变变量的值
         * 另外 Kotlin 可以在注释里面/*嵌套注释*/，握草，这也可以？
         */
        var d: Int
        d = 1
        System.out.print(d)     // print可以输出 int，但是不能输出String
        d = 2
        System.out.println(d)

        System.out.printf(str)   // 这里 String 不能采用 print 输出; printf可以，不换行
    }

    fun update() {
        var a = 1
        // 模板中的简单名称：
        val s1 = "a is $a"  // 美元符号后面表示的是变量？
        a = 2
        // 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a"    // 如果 美元符号 后面要接表达式，采用 花括号{} 括起来

        println(s1)  // a is 1
        println(s2)   // a was 1, but now is 2
    }

//    fun maxValue(a: Int, b: Int): Int {
//        if (a > b)
//            return a
//        else
//            return b
//    }
    /**
     * 上下两个采用 条件表达式 要判断ab大小的写法是一致的，但是好像是不支持Java中的三目运算符
     */
        fun maxValue(a: Int, b: Int) = if (a > b) a else b

//    fun maxValue(a: Int, b: Int): Int {
//        return (a > b) ? a : b  // 没有三目运算符？
//    }
}
