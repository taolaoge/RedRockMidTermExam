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
import java.lang.Exception

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
class ColorViewModel : ViewModel() {
    val viewPagerData = ArrayList<List<Color>>()
    var message = ("")
    val code = MutableLiveData<Int>()
    val errorMsg = MutableLiveData<String>()

    suspend fun getColorList(id: Int) {
        try {
            val response = DataNetwork.getColorList(id)
            message = response.message
            if (response.code == 114) {
                dealColorListResponse(response)
            } else {
                code.postValue(response.code)
            }
        }catch (e:Exception){
            errorMsg.postValue(e.toString())
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