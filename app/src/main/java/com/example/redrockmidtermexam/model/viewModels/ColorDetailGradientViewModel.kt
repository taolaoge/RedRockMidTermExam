package com.example.redrockmidtermexam.model.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.model.bean.Color
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.response.ColorDetailResponse

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/2
 */
class ColorDetailGradientViewModel : ViewModel() {
    val code = MutableLiveData<Int>()
    val message = ""
    val colorList = ArrayList<Color>()
    var ifFresh = true

    suspend fun postStarColor(shade_id:Int){
        val response = DataNetwork.postStarColor(shade_id,"颜色",
            "bearer ${BaseApp.header.getString("token","")}")
        Log.d("bbp", "postStarColor:${response.message} ")
    }

    suspend fun getColorDetail(id:Int,position:Int){
        val response = DataNetwork.getColorDetail(id)
        if (response.code == 114){
            dealColorDetailResponse(response,position)
        }
        code.postValue(response.code)
    }

    private fun dealColorDetailResponse(response:ColorDetailResponse,position:Int) {
        for (color in response.data.shades.shade_list[position].shade){
            colorList.add(color.color)
        }
    }
}