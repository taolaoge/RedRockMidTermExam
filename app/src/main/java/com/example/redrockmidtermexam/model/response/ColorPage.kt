package com.example.redrockmidtermexam.model.response

import android.provider.ContactsContract

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
data class ColorPage(
    val code: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val count: Int,
        val list: List<Color>
    ) {
        data class Color(
            val id: Int,
            val theme: String
        )
    }
}

