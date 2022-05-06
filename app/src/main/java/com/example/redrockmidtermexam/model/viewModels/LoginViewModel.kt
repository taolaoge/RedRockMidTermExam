package com.example.redrockmidtermexam.model.viewModels

import android.content.Context
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.model.network.DataNetwork

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/2
 */
class LoginViewModel : ViewModel() {
    val code = MutableLiveData<Int>()
    var message = ""
    val errorMsg = MutableLiveData<String>()

    suspend fun postLogin(phone_number:String) {
        try {
            val response = DataNetwork.postLogin(phone_number)
            if (response.code == 114) {
                val token = response.data.token
                //首先创造一个名为"header"的sp文件，必须要先创建
                BaseApp.context.getSharedPreferences("header", Context.MODE_PRIVATE).edit {
                    putString("token", token)
                }
            } else {
                message = response.message
            }
            code.postValue(response.code)
        }catch (e:Exception){
            errorMsg.postValue(e.toString())
        }
    }
}