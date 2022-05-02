package com.example.redrockmidtermexam.extentions

import android.content.Context
import android.widget.Toast
import com.example.redrockmidtermexam.BaseApp

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/2
 */
fun Context.toast(message:String){
    Toast.makeText(BaseApp.context,"$message",Toast.LENGTH_LONG).show()
}