package com.example.redrockmidtermexam.model.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.model.bean.Color
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.network.NetWorkRepository
import com.example.redrockmidtermexam.model.response.ColorDetailResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

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
    val errorMsg = MutableLiveData<String>()
    var shade_id = 1
    var position = 1

    fun postStarColor() {
        try {
            /*val response = DataNetwork.postStarColor(
                shade_id, "颜色",
                "bearer ${BaseApp.header.getString("token", "")}"
            )*/
            NetWorkRepository.postStarColor(
                shade_id, "颜色",
                "bearer ${BaseApp.header.getString("token", "")}"
            )
                .subscribe {

                }
        } catch (e: Exception) {
            errorMsg.postValue(e.toString())
        }
    }

    fun getColorDetail() {
        try {
            /*val response = DataNetwork.getColorDetail(id)
            if (response.code == 114) {
                dealColorDetailResponse(response, position)
            }
            code.postValue(response.code)*/
            NetWorkRepository.getColorDetail(shade_id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.code == 114) dealColorDetailResponse(it, position)
                    code.value = it.code
                }
        } catch (e: Exception) {
            errorMsg.postValue(e.toString())
        }
    }

    private fun dealColorDetailResponse(response: ColorDetailResponse, position: Int) {
        for (color in response.data.shades.shade_list[position].shade) {
            colorList.add(color.color)
        }
    }
}