package com.example.redrockmidtermexam.model.network

import com.example.wanandroid_mvvm.model.network.NetService
import com.example.wanandroid_mvvm.utils.ServiceCreator
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/11
 */
object DataNetwork {

    private val netService: NetService = ServiceCreator.create<NetService>()

    suspend fun getColorPageId() = netService.getColorPageId().await()

    suspend fun getColorList(id: Int) = netService.getColorList(id).await()

    suspend fun getColorDetail(id: Int) = netService.getColorDetail(id).await()

    suspend fun getIdeaFirst() = netService.getIdeaFirst().await()

    suspend fun getIdeaDetail(id: Int) = netService.getIdeaDetail(id).await()

    suspend fun postLogin(phone_number: String) = netService.postLogin(phone_number).await()

    suspend fun postRegister(phone_number: String, name: String) =
        netService.postRegister(phone_number, name).await()

    suspend fun getStarList(page: Int, limit: Int, token: String) =
        netService.getStarList(page, limit, token).await()

    suspend fun postStarColor(shade_id: Int, name: String, token: String) =
        netService.postStarColor(shade_id, name, token).await()

    private suspend fun <T> retrofit2.Call<T>.await(): T {
        return suspendCoroutine {
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) it.resume(body)
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }
            })
        }
    }
}