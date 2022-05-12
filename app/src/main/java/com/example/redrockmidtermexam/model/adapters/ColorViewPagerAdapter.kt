package com.example.redrockmidtermexam.model.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.model.bean.Color
import com.example.redrockmidtermexam.model.response.ColorListResponse
import java.lang.Exception


/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
class ColorViewPagerAdapter(
    private val count: Int,
    private val data: ArrayList<List<Color>>
) :
    RecyclerView.Adapter<ColorViewPagerAdapter.InnerHolder>() {
    lateinit var parent: ViewGroup

    inner class InnerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recycleView: RecyclerView = view.findViewById(R.id.color_vp2_rv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        this.parent = parent

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.color_vp2_item, parent, false)
        return InnerHolder(view)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        lateinit var layoutManager1: RecyclerView.LayoutManager
        lateinit var adapter1: ColorRecycleViewAdapter
        try {
            val data = data[position]
            val recycleViewData = ArrayList<Color>()
            for (element in data) {
                val color = element.run {
                    Color(name, hex, r, g, b, c, m, k, y, id)
                }
                recycleViewData.add(color)
            }
            layoutManager1 = LinearLayoutManager(parent.context)
            adapter1 = ColorRecycleViewAdapter(recycleViewData)
            holder.recycleView.run {
                adapter = adapter1
                layoutManager = layoutManager1
            }
        }catch (e:Exception){ }
    }

    override fun getItemCount(): Int = count
}