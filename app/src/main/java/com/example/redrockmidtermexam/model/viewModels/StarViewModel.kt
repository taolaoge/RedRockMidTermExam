package com.example.redrockmidtermexam.model.viewModels

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.network.NetWorkRepository
import com.example.redrockmidtermexam.model.response.StarResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.lang.Exception

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
    val errorMsg = MutableLiveData<String>()
    var page = 1
    var limit = 100

    fun getStarList() {
        try {
            NetWorkRepository.getStarList(page,limit
            ,"bearer ${BaseApp.header.getString("token","")}" )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("bbp", "getStarList:$it")
                    if (it.code == 114) dealStarListResponse(it) else message = it.message
                    code.value = it.code
                }
        }catch (e:Exception){
            errorMsg.postValue(e.toString())
        }
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
    }
}