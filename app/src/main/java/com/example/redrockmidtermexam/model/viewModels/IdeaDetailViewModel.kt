package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.response.IdeaDetailResponse

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/1
 */
class IdeaDetailViewModel : ViewModel() {
    val responseList = ArrayList<IdeaDetailResponse>()
    val isFinish = MutableLiveData(false)
    suspend fun getIdeaDetail(id: Int) {
        val response = DataNetwork.getIdeaDetail(id)
        responseList.add(response)
        if (id == 7){
            isFinish.postValue(true)
        }
    }
}