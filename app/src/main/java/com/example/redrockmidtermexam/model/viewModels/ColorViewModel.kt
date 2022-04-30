package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.ViewModel
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
    val viewPagerData = ArrayList<List<ColorListResponse.Data.Color>>()

    suspend fun getColorPageId() {
        val response = DataNetwork.getColorPageId()
        dealColorPageIdResponse(response)
    }

    private fun dealColorPageIdResponse(response: ColorPageResponse) {
        val message = response.message
    }

    suspend fun getColorList(id: Int) {
        val response = DataNetwork.getColorList(id)
        dealColorListResponse(response)
    }

    private fun dealColorListResponse(response:ColorListResponse) {
        val arrayList = ArrayList<ColorListResponse.Data.Color>()
        for(i in response.data.color_list){
            arrayList.add(i)
        }
        viewPagerData.add(arrayList)
    }
}