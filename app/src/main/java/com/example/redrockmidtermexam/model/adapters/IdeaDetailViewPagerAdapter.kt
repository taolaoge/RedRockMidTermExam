package com.example.redrockmidtermexam.model.adapters

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
import com.example.redrockmidtermexam.utils.filter

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/1
 */
class IdeaDetailViewPagerAdapter(private val responseList:List<IdeaDetailResponse>) :
    RecyclerView.Adapter<IdeaDetailViewPagerAdapter.InnerHolder>() {
    lateinit var parent: ViewGroup

    inner class InnerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mImg0: ImageView = view.findViewById(R.id.idea_detail_img0)
        val mImg1: ImageView = view.findViewById(R.id.idea_detail_img1)
        val mImg2: ImageView = view.findViewById(R.id.idea_detail_img2)
        val mImg3: ImageView = view.findViewById(R.id.idea_detail_img3)
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
            .inflate(R.layout.color_vp2_item, parent, false)
        return InnerHolder(view)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        val colorList = responseList[position].data.colors
        val shadeList = responseList[position].data.shades
        holder.run {
            Glide.with(parent).load(responseList[position].data.image.filter()).into(mImg0)
        }
    }

    override fun getItemCount(): Int = 7
}