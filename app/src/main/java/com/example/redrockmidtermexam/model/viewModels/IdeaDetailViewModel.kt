package com.example.redrockmidtermexam.model.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.network.DataNetwork
import com.example.redrockmidtermexam.model.network.NetWorkRepository
import com.example.redrockmidtermexam.model.response.IdeaDetailResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
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
    val errorMsg = MutableLiveData<String>()
    val id = MutableLiveData(1)

    fun getIdeaDetail() {
        try {
            NetWorkRepository.getIdeaDetail(id.value!!)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap {
                    Observable.create<IdeaDetailResponse> { b ->
                        if (it.code == 114)
                            b.onNext(it)
                    }
                }
                .subscribe {
                    responseList.add(it)
                    titleList.add(it.data.title)
                    if (id.value!! < 7)
                        id.value = id.value!!.plus(1)
                    else
                        isFinish.value = true
                }
        } catch (e: Exception) {
            errorMsg.value = e.toString()
        }
    }
}