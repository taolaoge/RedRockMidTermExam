package com.example.redrockmidtermexam

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    //这是kt的一个静态方法，可以通过 类.方法 直接调用
    companion object{
        //防止context内存泄漏
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        val job = Job()
        val scope = CoroutineScope(job)
    }
}