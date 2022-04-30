package com.example.wanandroid_mvvm.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/3/10
 */
object ServiceCreator {
    private const val BASE_URL = "http://redrock.udday.cn:8888/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>):T= retrofit.create(serviceClass)

    //内联函数的应用
    inline fun <reified T> create():T = create(T::class.java)
}