package com.penoder.study.kotlin.loop

/**
 * Created by dell on 2017/9/6.
 */
class ForLoop {

    constructor() {

        var datas : ArrayList<String> = ArrayList()
        datas.add("6666")
        datas.add("2333")
        datas.add("5555")
        datas.add("8602")
        datas.add("7189")
        datas.add("0000")
        forIterator(datas)
    }

    fun forIterator(datas : ArrayList<String>) {
        /**
         * kotlin 没有new一个对象，那么怎么实例化这个集合对象【直接去掉 new 关键字就行了？】
         *
         * 可恶的是List集合连add()方法都没有！怎么添加对象进去啊？
         * 但是创建一个ArrayList的对象及其引用却有add()方法！！WTF
         */

        for (str in datas) {    // 对任何提供迭代器（iterator）的对象进行遍历
            System.out.println(str)
        }

        System.out.println("-------------- 分隔符 --------------")

        for (index in datas.indices) {  // 通过索引遍历
            System.out.println(index)
            System.out.println(datas[index])    // 明明是集合，为什么建议我使用数组的格式，而不是采用get(index)
        }

        System.out.println("-------------- 倒着输出 --------------")

        for (index in datas.indices) {  // 通过索引遍历
            System.out.println(datas[datas.size - index - 1])
        }

        System.out.println("-------------- 分隔线 --------------")

        for ((index, value) in datas.withIndex()) { // 使用库函数 withIndex()
            System.out.println(value .plus("  ----  " + index))
        }
    }
}