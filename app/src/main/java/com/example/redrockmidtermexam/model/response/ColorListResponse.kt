package com.example.redrockmidtermexam.model.response

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
    ){
        data class Color(
            val id:Int,
            val name:String,
            val hex:String,
            val r:Int,
            val g:Int,
            val b:Int,
            val c:Int,
            val m:Int,
            val k:Int,
            val y:Int
        )
    }
}
