package com.example.redrockmidtermexam.model.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.model.response.IdeaDetailResponse
import com.example.redrockmidtermexam.ui.view.LinearGradientCircleView
import com.example.redrockmidtermexam.utils.filter

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/1
 */
class IdeaDetailViewPagerAdapter(private val responseList:ArrayList<IdeaDetailResponse>) :
    RecyclerView.Adapter<IdeaDetailViewPagerAdapter.InnerHolder>() {
    lateinit var parent: ViewGroup

    inner class InnerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mImg0: ImageView = view.findViewById(R.id.image30)
        val mImg1: LinearGradientCircleView = view.findViewById(R.id.idea_detail_img1)
        val mImg2: LinearGradientCircleView = view.findViewById(R.id.idea_detail_img2)
        val mImg3: LinearGradientCircleView = view.findViewById(R.id.idea_detail_img3)
        val mLayout1:ConstraintLayout = view.findViewById(R.id.idea_detail_color1)
        val mLayout2:ConstraintLayout = view.findViewById(R.id.idea_detail_color2)
        val mLayout3:ConstraintLayout = view.findViewById(R.id.idea_detail_color3)
        val mLayout4:ConstraintLayout = view.findViewById(R.id.idea_detail_color4)
        val mLayout5:ConstraintLayout = view.findViewById(R.id.idea_detail_color5)
        val mLayout6:ConstraintLayout = view.findViewById(R.id.idea_detail_color6)
        val mTv1:TextView = view.findViewById(R.id.idea_detail_tv1)
        val mTv2:TextView = view.findViewById(R.id.idea_detail_tv2)
        val mTv3:TextView = view.findViewById(R.id.idea_detail_tv3)
        val mTv4:TextView = view.findViewById(R.id.idea_detail_tv4)
        val mTv5:TextView = view.findViewById(R.id.idea_detail_tv5)
        val mTv6:TextView = view.findViewById(R.id.idea_detail_tv6)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        this.parent = parent
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.idea_detai_vp2_item, parent, false)
        return InnerHolder(view)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        val colorList = responseList[position].data.colors
        val shadeList = responseList[position].data.shades
        holder.run {
            Glide.with(parent).load(responseList[position].data.image.filter()).into(mImg0)
            mTv1.text = "#${colorList.color_1.hex}"
            mTv2.text = "#${colorList.color_2.hex}"
            mTv3.text = "#${colorList.color_3.hex}"
            mTv4.text = "#${colorList.color_4.hex}"
            mTv5.text = "#${colorList.color_5.hex}"
            mTv6.text = "#${colorList.color_6.hex}"
            mLayout1.setBackgroundColor(Color.parseColor("#${colorList.color_1.hex}"))
            mLayout2.setBackgroundColor(Color.parseColor("#${colorList.color_2.hex}"))
            mLayout3.setBackgroundColor(Color.parseColor("#${colorList.color_3.hex}"))
            mLayout4.setBackgroundColor(Color.parseColor("#${colorList.color_4.hex}"))
            mLayout5.setBackgroundColor(Color.parseColor("#${colorList.color_5.hex}"))
            mLayout6.setBackgroundColor(Color.parseColor("#${colorList.color_6.hex}"))
            for (i in 0..2) {
                val array = IntArray(shadeList.shade_list[i].shade.size)
                var index = 0
                for (j in shadeList.shade_list[i].shade){
                    array[index++] = Color.parseColor("#${j.color.hex}")
                }
                when (i) {
                    0 -> mImg1.run {
                        colorArray = array
                    }
                    1 -> mImg2.run {
                        colorArray = array
                    }
                    2 -> mImg3.run {
                        colorArray = array
                    }
                }
            }
        }
    }


    override fun getItemCount(): Int = 7
}