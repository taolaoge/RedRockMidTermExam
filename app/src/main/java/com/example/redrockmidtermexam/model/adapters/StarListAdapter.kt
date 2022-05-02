package com.example.redrockmidtermexam.model.adapters

import android.graphics.Color
import android.graphics.RectF
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.ui.view.LinearGradientRectView

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/3
 */
class StarListAdapter(private val shadeList:ArrayList<IntArray>)
    : RecyclerView.Adapter<StarListAdapter.InnerHolder>() {

    lateinit var parent: ViewGroup

    inner class InnerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mImg1:ConstraintLayout = view.findViewById(R.id.star_rv_item_img1)
        val mImg2:ConstraintLayout = view.findViewById(R.id.star_rv_item_img2)
        val mRect:LinearGradientRectView = view.findViewById(R.id.star_rv_item_rect)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        this.parent = parent
        Log.d("bbp", "onCreateViewHolder:$shadeList ")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.star_rv_item, parent, false)
        return InnerHolder(view)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        val shade = shadeList[position]
        Log.d("bbp", "onBindViewHolder:${shade[0]} ")
        holder.apply {
            mImg1.setBackgroundColor(shade[0])
            mImg2.setBackgroundColor(shade[1])
            mRect.run {
                mRectF = RectF(0F,0F,700F,410F)
                colorArray = shade
            }
        }
    }

    override fun getItemCount(): Int = shadeList.size

}