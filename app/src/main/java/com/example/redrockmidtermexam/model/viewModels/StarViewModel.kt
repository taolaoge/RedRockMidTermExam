package com.example.redrockmidtermexam.model.viewModels

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.response.StarResponse

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/2
 */
class StarViewModel : ViewModel() {
    val code = MutableLiveData<Int>()
    var message = ""
    val shadeList = ArrayList<IntArray>()


    suspend fun getStarList(page: Int, limit: Int) {
        val response = DataNetwork.getStarList(
            page, limit,
            "bearer ${BaseApp.header.getString("token", "")}"
        )
        if (response.code == 114) dealStarListResponse(response) else message = response.message
    }

    private fun dealStarListResponse(response: StarResponse) {
        for (star in response.data.star_list) {
            val shadeArray = IntArray(star.colorShade.size)
            var index = 0
            for (shade in star.colorShade) {
                shadeArray[index++] = Color.parseColor("#${shade.color.hex}")
            }
            shadeList.add(shadeArray)
        }
        code.postValue(response.code)
    }
}