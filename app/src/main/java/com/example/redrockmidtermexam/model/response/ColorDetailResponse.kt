package com.example.redrockmidtermexam.model.response

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
data class ColorDetailResponse(
    val data:Colors
) {
    data class Colors(
        val color_2: Color1,
        val color_3: Color1,
        val color_4: Color1,
        val color_5: Color1,
        val color_6: Color1,
        val color_7: Color1,
    ) {
        data class Color1(
            val id: Int,
            val name: String,
            val hex: String,
            val r: Int,
            val g: Int,
            val b: Int,
            val c: Int,
            val m: Int,
            val k: Int,
            val y: Int
        )
    }
}