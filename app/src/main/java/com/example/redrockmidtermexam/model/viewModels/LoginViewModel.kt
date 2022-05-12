package com.example.redrockmidtermexam.model.viewModels

import android.content.Context
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.network.NetWorkRepository
import com.example.redrockmidtermexam.model.response.LoginResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

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

    fun postLogin(phone_number:String) {
        try {
            NetWorkRepository.postLogin(phone_number)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    message = if (it.code == 114){
                        val token = it.data.token
                        //首先创造一个名为"header"的sp文件，必须要先创建
                        BaseApp.context.getSharedPreferences("header", Context.MODE_PRIVATE).edit {
                            putString("token", token)
                        }
                        "登录成功"
                    }else{
                        it.message
                    }
                    code.value = it.code
                }
        }catch (e:Exception){
            errorMsg.postValue(e.toString())
        }
    }
}