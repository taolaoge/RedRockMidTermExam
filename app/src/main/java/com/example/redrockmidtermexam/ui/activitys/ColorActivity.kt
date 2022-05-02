package com.example.redrockmidtermexam.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
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
        viewModel.code.observe(this){
            if (it != 114)
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

        /*//监听vp2的滑动，对应的bottomNavigation也选中，绑定vp2和bottomNavigation
        binding.colorVp2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("bbp", "onPageSelected:$position ")
                //判断是否需要重新请求数据
                if ((position + 1) in viewModel.observeIfGet) {

                } else {
                    viewModel.observeIfGet.add(position + 1)
                    BaseApp.scope.launch {
                        viewModel.getColorList(position + 1)
                    }
                }
            }
        })*/
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