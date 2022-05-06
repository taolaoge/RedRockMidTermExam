package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.response.IdeaDetailResponse
import java.lang.Exception

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/1
 */
class IdeaDetailViewModel : ViewModel() {
    val titleList = ArrayList<String>()
    val responseList = ArrayList<IdeaDetailResponse>()
    val isFinish = MutableLiveData(false)
    var message = ("")
    val code = MutableLiveData<Int>()
    val errorMsg = MutableLiveData<String>()

    suspend fun getIdeaDetail(id: Int) {
        try {
            val response = DataNetwork.getIdeaDetail(id)
            if (response.code == 114) {
                responseList.add(response)
                titleList.add(response.data.title)
                if (id == 7) {
                    isFinish.postValue(true)
                }
            } else {
                code.postValue(response.code)
                message = response.message
            }
        }catch (e:Exception){
            errorMsg.postValue(e.toString())
        }
    }
}