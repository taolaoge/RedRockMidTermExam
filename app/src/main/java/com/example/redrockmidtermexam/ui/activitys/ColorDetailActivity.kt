package com.example.redrockmidtermexam.ui.activitys

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityColorDetailBinding
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.viewModels.ColorDetailViewModel
import com.example.redrockmidtermexam.ui.view.LinearGradientView
import kotlinx.coroutines.launch

class ColorDetailActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel: ColorDetailViewModel by viewModels()
    lateinit var binding: ActivityColorDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("id", 1)
        viewModel.code.observe(this){
            if (it != 114)
                this.toast(viewModel.message)
        }
        viewModel.isFinish.observe(this) {
            if (it) {
                initView()
            }
        }
        if (viewModel.ifRefresh) {
            BaseApp.scope.launch {
                viewModel.getColorDetail(id)
            }
        }
        initClickView()
    }

    private fun initClickView() {
        binding.colorToolbarVector.setOnClickListener(this)
    }

    private fun initView() {
        val colorsData = viewModel.colorsData
        val shadeListData = viewModel.shadeListData
        colorsData.run {
            binding.colorDetailToolbarTitle.text = this[0].name
            binding.colorDetailName.text = this[0].name
            binding.colorDetailA.setBackgroundColor(android.graphics.Color.parseColor("#${this[0].hex}"))
            binding.colorDetailB.setBackgroundColor(android.graphics.Color.parseColor("#${this[1].hex}"))
            binding.colorDetailC.setBackgroundColor(android.graphics.Color.parseColor("#${this[2].hex}"))
            binding.colorDetailD.setBackgroundColor(android.graphics.Color.parseColor("#${this[3].hex}"))
            binding.colorDetailE.setBackgroundColor(android.graphics.Color.parseColor("#${this[4].hex}"))
            binding.colorDetailF.setBackgroundColor(android.graphics.Color.parseColor("#${this[5].hex}"))
            binding.colorDetailG.setBackgroundColor(android.graphics.Color.parseColor("#${this[6].hex}"))
            binding.colorDetailTvHex.text = "#${this[0].hex}"
            binding.colorDetailTvRgb.text = "${this[0].r},${this[0].g},${this[0].b}"
            binding.colorDetailTvCmyk.text = "${this[0].c},${this[0].m},${this[0].y},${this[0].k}"
            binding.colorDetailTvB.text = "#${this[1].hex}"
            binding.colorDetailTvC.text = "#${this[2].hex}"
            binding.colorDetailTvD.text = "#${this[3].hex}"
            binding.colorDetailTvE.text = "#${this[4].hex}"
            binding.colorDetailTvF.text = "#${this[5].hex}"
            binding.colorDetailTvG.text = "#${this[6].hex}"
        }
        //为渐变示例添加渐变数组
        for (i in 0..5) {
            shadeListData[i].run {
                val array = IntArray(this.size)
                for ((index, color) in this.withIndex()) {
                    array[index] = Color.parseColor("#${color.hex}")
                }
                when (i) {
                    0 -> binding.colorDetailImg1.run {
                        colorArray = array
                    }
                    1 -> binding.colorDetailImg2.run {
                        colorArray = array
                    }
                    2 -> binding.colorDetailImg3.run {
                        colorArray = array
                    }
                    3 -> binding.colorDetailImg4.run {
                        colorArray = array
                    }
                    4 -> binding.colorDetailImg5.run {
                        colorArray = array
                    }
                    5 -> binding.colorDetailImg6.run {
                        colorArray = array
                    }
                }
            }
        }
        if (viewModel.ifRefresh) {
            //请求到了color后需要重绘来为view增加渐变的效果，但是无法重绘view，只能重新绘制整个activity了，绷不住了

            recreate()
            viewModel.ifRefresh = false
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.color_toolbar_vector -> finish()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        finish()
        return super.onKeyDown(keyCode, event)
    }
}