package com.example.redrockmidtermexam.model.response

import com.example.redrockmidtermexam.model.bean.Color

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
data class ColorListResponse(
    val code:Int,
    val message:String,
    val data:Data
){
    data class Data(
        val has_more:Boolean,
        val color_list:List<Color>
    )
}


