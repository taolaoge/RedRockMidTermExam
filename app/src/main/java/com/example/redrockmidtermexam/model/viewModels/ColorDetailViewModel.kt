package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.model.bean.Color
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.response.ColorDetailResponse

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
class ColorDetailViewModel :ViewModel() {
    var shadeIdList = ArrayList<Int>()
    var ifRefresh = true
    val colorsData = ArrayList<Color>()
    val shadeListData = ArrayList<List<Color>>()
    var message = ("")
    val code = MutableLiveData<Int>()

    suspend fun getColorDetail(id:Int){
        val response = DataNetwork.getColorDetail(id)
        if (response.code == 114) {
            dealColorDetailResponse(response)
        }
        code.postValue(response.code)
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
        for(i in 0..5){
            val arrayList = ArrayList<Color>()
            for (j in response.data.shades.shade_list[i].shade){
                j.color.run {
                    val color = Color(name, hex, r, g, b, c, m, k, y, id)
                    arrayList.add(color)
                }
            }
            shadeListData.add(arrayList)
            shadeIdList.add(response.data.shades.shade_list[i].id)
        }
    }
}