package com.example.redrockmidtermexam.model.adapters

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.ui.activitys.ColorDetailActivity

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
class ColorRecycleViewAdapter(
    private val data: ArrayList<com.example.redrockmidtermexam.model.bean.Color>
) : RecyclerView.Adapter<ColorRecycleViewAdapter.InnerHolder>() {

    lateinit var parent: ViewGroup

    inner class InnerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mTvName: TextView = view.findViewById(R.id.color_rv_tv_name)
        val mTvHex: TextView = view.findViewById(R.id.color_rv_tv_hex_detail)
        val mTvRgb: TextView = view.findViewById(R.id.color_rv_tv_rgb_detail)
        val mTvCmyk: TextView = view.findViewById(R.id.color_rv_tv_cmyk_detail)
        val mLayoutBackground: ConstraintLayout = view.findViewById(R.id.color_rv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        this.parent = parent
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.color_rv_item, parent, false)
        return InnerHolder(view)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        val color = data[position]
        holder.run {
            //调用布局，更改布局颜色。使用系统中的color工具类parseColor设置
            mLayoutBackground.setBackgroundColor(Color.parseColor("#${color.hex}"))
            mTvHex.text = "#${color.hex}"
            mTvRgb.text = "${color.r},${color.g},${color.b}"
            mTvCmyk.text = "${color.c},${color.m},${color.y},${color.k}"
            mTvName.text = color.name
            itemView.setOnClickListener {
                val intent = Intent(parent.context, ColorDetailActivity::class.java)
                intent.putExtra("id", color.id)
                parent.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = data.size

}