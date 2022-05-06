package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.response.IdeaFirstResponse
import java.lang.Exception

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/1
 */
class IdeaViewModel:ViewModel() {
    val imageList = ArrayList<String>()
    var message = ("")
    val code = MutableLiveData<Int>()
    val errorMsg = MutableLiveData<String>()

    suspend fun getIdeaFirst() {
        try {
            val response = DataNetwork.getIdeaFirst()
            message = response.message
            if (response.code == 114) {
                dealIdeaFirstResponse(response)
            }
            code.postValue(response.code)
        }catch (e:Exception){
            errorMsg.postValue(e.toString())
        }
    }

    private fun dealIdeaFirstResponse(response:IdeaFirstResponse) {
        for (data in response.data){
            imageList.add(data.image)
        }
    }
}