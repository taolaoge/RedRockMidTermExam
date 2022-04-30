package com.example.redrockmidtermexam.model.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.model.bean.Color
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.response.ColorDetailResponse
import com.example.redrockmidtermexam.model.response.ColorListResponse

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
class ColorDetailViewModel :ViewModel() {
    val isFinish = MutableLiveData(false)
    val colorsData = ArrayList<Color>()
    val shadeListData = ArrayList<List<Color>>()

    suspend fun getColorDetail(id:Int){
        val response = DataNetwork.getColorDetail(id)
        dealColorDetailResponse(response)
    }

    private fun dealColorDetailResponse(response:ColorDetailResponse) {
        colorsData.run {
            add(response.data.colors.color_1)
            add(response.data.colors.color_2)
            add(response.data.colors.color_3)
            add(response.data.colors.color_4)
            add(response.data.colors.color_5)
            add(response.data.colors.color_6)
            add(response.data.colors.color_7)
        }
        for(i in 1..6){
            val arrayList = ArrayList<Color>()
            for (j in response.data.shades.shade_list[i].shade){
                j.color.run {
                    val color = Color(name, hex, r, g, b, c, m, k, y, id)
                    arrayList.add(color)
                }
            }
            shadeListData.add(arrayList)
        }
        isFinish.postValue(true)
        Log.d("bbp", "dealColorDetailResponse:${shadeListData} ")
    }
}