package com.example.redrockmidtermexam.extentions

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.redrockmidtermexam.BaseApp
import com.example.wanandroid_mvvm.utils.ServiceCreator

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/2
 */
fun Context.toast(message:String){
    Toast.makeText(BaseApp.context,"$message",Toast.LENGTH_LONG).show()
}

inline fun <reified T> Context.intent() {
    //使用inline函数实例化泛型对象，调用create方法返回一个Intent对象
    val intent = create(this,T::class.java)
    startActivity(intent)
}

fun <T> create(context:Context,serviceClass: Class<T>):Intent = Intent(context,serviceClass)

