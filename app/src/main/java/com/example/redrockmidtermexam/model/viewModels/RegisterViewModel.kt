package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.network.DataNetwork

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/2
 */
class RegisterViewModel : ViewModel() {
    val code = MutableLiveData<Int>()
    var message = ""
    val errorMsg = MutableLiveData<String>()

    suspend fun postRegister(phone_number:String,name:String){
        try {
            val response = DataNetwork.postRegister(phone_number, name)
            if (response.code != 114) {
                message = response.message
            }
            code.postValue(response.code)
        }catch (e:Exception){
            errorMsg.postValue(e.toString())
        }
    }
}