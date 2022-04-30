package com.example.redrockmidtermexam.model.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redrockmidtermexam.R


/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
class ColorViewPagerAdapter() :
    RecyclerView.Adapter<ColorViewPagerAdapter.InnerHolder>() {

    inner class InnerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recycleView: RecyclerView = view.findViewById(R.id.color_vp2_rv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.color_vp2_item,parent,false)
        return InnerHolder(view)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 7
    }
}