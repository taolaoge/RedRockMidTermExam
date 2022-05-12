package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.model.bean.Color
import com.example.redrockmidtermexam.model.network.NetWorkRepository
import com.example.redrockmidtermexam.model.response.ColorListResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.collections.ArrayList

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
    val id = MutableLiveData(1)

    fun getColorList() {
        try {
            NetWorkRepository.getColorList(id.value!!)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    dealColorListResponse(it)
                }
        }catch (t:Exception){}
    }

    private fun dealColorListResponse(response: ColorListResponse) {
        val arrayList = ArrayList<Color>()
        for (color in response.data.color_list) {
            arrayList.add(color)
        }
        viewPagerData.add(arrayList)
        if (id.value!! < 7)
//            id.postValue(id.value!!.plus(1))
            id.value = id.value!!.plus(1)
    }
}