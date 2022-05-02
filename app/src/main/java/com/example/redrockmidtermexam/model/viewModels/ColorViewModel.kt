package com.example.redrockmidtermexam.model.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.bean.Color
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.response.ColorListResponse
import com.example.redrockmidtermexam.model.response.ColorPageResponse

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
class ColorViewModel : ViewModel() {
    val observeIfGet = ArrayList<Int>()
    val viewPagerData = ArrayList<List<Color>>()
    var message = ("")
    val code = MutableLiveData(0)

    /*suspend fun getColorPageId() {
        val response = DataNetwork.getColorPageId()
        dealColorPageIdResponse(response)
    }

    private fun dealColorPageIdResponse(response: ColorPageResponse) {
        val message = response.message
    }*/

    suspend fun getColorList(id: Int) {
        val response = DataNetwork.getColorList(id)
        code.postValue(response.code)
        message = response.message
        if (code.value == 114) {
            dealColorListResponse(response)
        }
    }

    private fun dealColorListResponse(response:ColorListResponse) {
        val arrayList = ArrayList<Color>()
        for(i in response.data.color_list){
            arrayList.add(i)
        }
        viewPagerData.add(arrayList)
    }
}