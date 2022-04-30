package com.example.redrockmidtermexam.model.response

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
data class ColorList(
    val code:Int,
    val message:String,

){
    data class Data(
        val has_more:Boolean,
        val color_list:List<com.example.redrockmidtermexam.model.response.ColorList>
    ){
        data class ColorList(
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
