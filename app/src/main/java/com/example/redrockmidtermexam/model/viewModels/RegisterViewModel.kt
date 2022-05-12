package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.network.NetWorkRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

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

    fun postRegister(phone_number:String,name:String){
        try {
            NetWorkRepository.postRegister(phone_number, name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    message = it.message
                    code.value = it.code
                }

        }catch (e:Exception){
            errorMsg.postValue(e.toString())
        }
    }
}