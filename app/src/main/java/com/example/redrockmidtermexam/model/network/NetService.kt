package com.example.wanandroid_mvvm.model.network

import com.example.redrockmidtermexam.model.response.*
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/3/10
 */
interface NetService {

   @GET("color/page")
   fun getColorPageId():retrofit2.Call<ColorPageResponse>

   @GET("color/color_list")
   fun getColorList(@Query("theme_id") id:Int):retrofit2.Call<ColorListResponse>

   @GET("color/color_detail")
   fun getColorDetail(@Query("color_detail_id") id:Int):retrofit2.Call<ColorDetailResponse>

   @GET("idea/idea")
   fun getIdeaFirst():retrofit2.Call<IdeaFirstResponse>

   @GET("idea/idea_detail")
   fun getIdeaDetail(@Query("idea_detail_id") id:Int):retrofit2.Call<IdeaDetailResponse>
}