package com.example.redrockmidtermexam.model.response

import com.example.redrockmidtermexam.model.bean.Color

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
data class ColorDetailResponse(
    val code:Int,
    val message:String,
    val data:Data
) {
    data class Data(
        val intro:String,
        val colors:Colors,
        val shades:Shades
    )
    data class Shades(
    val shade_list:List<Shade>
    ){
        data class Shade(
            val id:Int,
            val shade:List<Color1>
        ){
            data class Color1(
                val color:Color
            )
        }
    }
    data class Colors(
        val color_1:Color,
        val color_2: Color,
        val color_3: Color,
        val color_4: Color,
        val color_5: Color,
        val color_6: Color,
        val color_7: Color,
    )
}