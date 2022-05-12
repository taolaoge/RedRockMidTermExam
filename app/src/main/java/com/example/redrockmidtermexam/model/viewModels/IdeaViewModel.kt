package com.example.redrockmidtermexam.model.viewModels

import android.database.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.network.NetWorkRepository
import com.example.redrockmidtermexam.model.response.IdeaFirstResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.Exception

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/1
 */
class IdeaViewModel : ViewModel() {
    val imageList = ArrayList<String>()
    val ifFinish = MutableLiveData<Boolean>()
    val errorMsg = MutableLiveData<String>()

    fun getIdeaFirst() {
        try {
            NetWorkRepository.getIdeaFirst()
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap {
                    io.reactivex.rxjava3.core.Observable.create<IdeaFirstResponse> { b ->
                        if (it.code == 114)
                            b.onNext(it)
                    }
                }
                .subscribe {
                    dealIdeaFirstResponse(it)
                }
        } catch (e: Exception) {
            errorMsg.postValue(e.toString())
        }
    }

    private fun dealIdeaFirstResponse(response: IdeaFirstResponse) {
        for (data in response.data) {
            imageList.add(data.image)
        }
        ifFinish.value = true
    }
}