package com.example.redrockmidtermexam.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityColorBinding
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.adapters.ColorViewPagerAdapter
import com.example.redrockmidtermexam.model.viewModels.ColorViewModel
import kotlinx.coroutines.launch

class ColorActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel: ColorViewModel by viewModels()
    lateinit var binding: ActivityColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.code.observe(this) {
            this.toast(viewModel.message)
        }
        BaseApp.scope.launch {
            repeat(7) {
                viewModel.getColorList(it + 1)
            }
            initViewPager()
        }
        initClickView()

        //取消vp2滑动到底滑不动时的动画
        val child: View = binding.colorVp2.getChildAt(0)
        if (child is RecyclerView) {
            child.setOverScrollMode(View.OVER_SCROLL_NEVER)
        }

        binding.colorVp2.registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
              //首先隐藏全部的选中的黑色的圆点
              hideCircle()
              //当选中的哪个vp2的时候将那个圆点填充为黑色
              when(position){
                  0 -> binding.colorVpSelect1.visibility = View.VISIBLE
                  1 -> binding.colorVpSelect2.visibility = View.VISIBLE
                  2 -> binding.colorVpSelect3.visibility = View.VISIBLE
                  3 -> binding.colorVpSelect4.visibility = View.VISIBLE
                  4 -> binding.colorVpSelect5.visibility = View.VISIBLE
                  5 -> binding.colorVpSelect6.visibility = View.VISIBLE
                  6 -> binding.colorVpSelect7.visibility = View.VISIBLE
              }
            }
        })
    }

    fun hideCircle(){
        binding.colorVpSelect1.visibility = View.INVISIBLE
        binding.colorVpSelect2.visibility = View.INVISIBLE
        binding.colorVpSelect3.visibility = View.INVISIBLE
        binding.colorVpSelect4.visibility = View.INVISIBLE
        binding.colorVpSelect5.visibility = View.INVISIBLE
        binding.colorVpSelect6.visibility = View.INVISIBLE
        binding.colorVpSelect7.visibility = View.INVISIBLE
    }

    private fun initViewPager() {
        runOnUiThread {
            binding.colorVp2.adapter = ColorViewPagerAdapter(7, viewModel.viewPagerData)
        }
    }


    private fun initClickView() {
        binding.colorToolbarTitle.setOnClickListener(this)
        binding.colorToolbarVector.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.color_toolbar_title -> {
                TODO()
            }
            R.id.color_toolbar_vector -> finish()
        }
    }

}