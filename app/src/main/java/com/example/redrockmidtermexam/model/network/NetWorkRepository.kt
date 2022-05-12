package com.example.redrockmidtermexam.model.network


import android.util.Log
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.model.network.NetWorkRepository.get
import com.example.wanandroid_mvvm.model.network.NetService
import com.example.wanandroid_mvvm.utils.ServiceCreator
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/11
 */
object NetWorkRepository {
    private val netService: NetService = ServiceCreator.create<NetService>()

    fun getColorList(id: Int) = netService.getColorList(id).get()

    fun getColorDetail(id: Int) = netService.getColorDetail(id).get()

    fun getIdeaFirst() = netService.getIdeaFirst().get()

    fun getIdeaDetail(id: Int) = netService.getIdeaDetail(id).get()

    fun postLogin(phone_number: String) = netService.postLogin(phone_number).get()

    fun postRegister(phone_number: String, name: String) =
        netService.postRegister(phone_number, name).get()

    fun getStarList(page: Int, limit: Int, token: String) =
        netService.getStarList(page, limit, token).get()

    fun postStarColor(shade_id: Int, name: String, token: String) =
        netService.postStarColor(shade_id, name, token).get()


    private fun <T : Any> Call<T>.get(): Observable<T> {
        return Observable.create<T> {
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    it.onNext(response.body()!!)
                }

                override fun onFailure(call: Call<T>, t: Throwable) {

                }
            })
        }
    }
}