package com.example.redrockmidtermexam.ui.activitys

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityColorDetailGradientBinding
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.viewModels.ColorDetailGradientViewModel
import kotlinx.coroutines.launch

class ColorDetailGradientActivity : AppCompatActivity(),View.OnClickListener {
    private val viewModel: ColorDetailGradientViewModel by viewModels()
    lateinit var binding: ActivityColorDetailGradientBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorDetailGradientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.colorDetailGradientStarFinish.visibility = View.GONE
        viewModel.code.observe(this) {
            if (it != 114) {
                this.toast(viewModel.message)
            }
            else {
                //请求到了数据后就立即重绘
                if (viewModel.ifFresh) {
                    recreate()
                    viewModel.ifFresh = false
                }
                //请求到了数据后设置，因为是recreate了活动，所以数据需要重新设置
                //不能一开始设置的原因是数据还没请求到，重绘活动时数据请求到了，数据用vm保存的
                val colorArray = IntArray(viewModel.colorList.size)
                var index = 0
                for (color in viewModel.colorList) {
                    colorArray[index++] = Color.parseColor("#${color.hex}")
                }
                binding.colorDetailGradient.colorArray = colorArray
            }
        }
        BaseApp.scope.launch {
            if (viewModel.ifFresh) {
                viewModel.getColorDetail(
                    intent.getIntExtra("id", 1), intent.getIntExtra("position", 1)
                )
            }
        }
        initViewClick()
    }

    private fun initViewClick() {
        binding.colorDetailGradientStarFinish.setOnClickListener(this)
        binding.colorDetailGradientStar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.color_detail_gradient_star -> starColor()
            R.id.color_detail_gradient_star_finish -> deleteStarColor()
        }
    }

    private fun deleteStarColor() {

    }

    private fun starColor() {
        val shadeId = intent.getIntExtra("shadeId",1)
        BaseApp.scope.launch {
            viewModel.postStarColor(shadeId)
        }
        binding.colorDetailGradientStarFinish.visibility = View.VISIBLE
    }
}