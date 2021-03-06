package com.example.redrockmidtermexam.ui.activitys

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityColorDetailBinding
import com.example.redrockmidtermexam.extentions.getIntent
import com.example.redrockmidtermexam.extentions.intent
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.viewModels.ColorDetailViewModel
import kotlinx.coroutines.launch

class ColorDetailActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel: ColorDetailViewModel by viewModels()
    lateinit var binding: ActivityColorDetailBinding
    var id = 1
    val colorArrayList = ArrayList<IntArray>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.id = intent.getIntExtra("id", 1)
        viewModel.errorMsg.observe(this){
            this.toast(it)
        }
        viewModel.code.observe(this) {
            if (it != 114) this.toast(viewModel.message) else initView()
        }
        viewModel.getColorDetail()
        initClickView()
    }

    private fun initClickView() {
        binding.colorToolbarVector.setOnClickListener(this)
        binding.colorDetailImg1.setOnClickListener(this)
        binding.colorDetailImg2.setOnClickListener(this)
        binding.colorDetailImg3.setOnClickListener(this)
        binding.colorDetailImg4.setOnClickListener(this)
        binding.colorDetailImg5.setOnClickListener(this)
        binding.colorDetailImg6.setOnClickListener(this)
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
        //?????????????????????????????????
        for (i in 0..5) {
            shadeListData[i].run {
                val array = IntArray(this.size)
                for ((index, color) in this.withIndex()) {
                    array[index] = Color.parseColor("#${color.hex}")
                }
                colorArrayList.add(array)
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
            //????????????color?????????????????????view??????????????????????????????????????????view???????????????????????????activity??????????????????
            recreate()
            viewModel.ifRefresh = false
        }
    }

    override fun onClick(v: View) {
        //??????????????????????????????????????????????????????????????????????????????????????????
        when (v.id) {
            R.id.color_toolbar_vector -> finish()
            R.id.color_detail_img1 -> intentGradientActivity(1)
            R.id.color_detail_img2 -> intentGradientActivity(2)
            R.id.color_detail_img3 -> intentGradientActivity(3)
            R.id.color_detail_img4 -> intentGradientActivity(4)
            R.id.color_detail_img5 -> intentGradientActivity(5)
            R.id.color_detail_img6 -> intentGradientActivity(6)
        }
    }

    private fun intentGradientActivity(position: Int) {
        val intent = this.getIntent<ColorDetailGradientActivity>()
        intent.putExtra("shadeId",viewModel.shadeIdList[position-1])
        intent.putExtra("id", id)
        intent.putExtra("position", position-1)
        startActivity(intent)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        finish()
        return super.onKeyDown(keyCode, event)
    }
}