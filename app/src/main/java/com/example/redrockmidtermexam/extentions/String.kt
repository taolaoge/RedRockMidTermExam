package com.example.redrockmidtermexam.utils

import java.lang.StringBuilder

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/1
 */
fun String.filter() : String{
    val array = this.toCharArray()
    val arrayList = ArrayList<Char>()
    for(i in array.indices){
        if (i != 4) {
            arrayList.add(array[i])
        }
    }
    val stringBuilder = StringBuilder()
    for (j in arrayList){
        stringBuilder.append(j)
    }
    return stringBuilder.toString()
}