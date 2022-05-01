package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.response.IdeaFirstResponse

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/1
 */
class IdeaViewModel:ViewModel() {
    val imageList = ArrayList<String>()
    val isFinish = MutableLiveData(false)

    suspend fun getIdeaFirst(){
        val response = DataNetwork.getIdeaFirst()
        dealIdeaFirstResponse(response)
    }

    private fun dealIdeaFirstResponse(response:IdeaFirstResponse) {
        for (data in response.data){
            imageList.add(data.image)
        }
        isFinish.postValue(true)
    }
}