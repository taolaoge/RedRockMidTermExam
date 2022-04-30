package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.response.ColorPage

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
class ColorViewModel:ViewModel() {

    suspend fun getColorPageId(){
        val response =  DataNetwork.getColorPageId()
        dealColorPageIdResponse(response)
    }

    private fun dealColorPageIdResponse(response : ColorPage) {
        val message = response.message

    }
}