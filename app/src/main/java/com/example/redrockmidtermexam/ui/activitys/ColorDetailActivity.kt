package com.example.redrockmidtermexam.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityColorBinding
import com.example.redrockmidtermexam.databinding.ActivityColorDetailBinding
import com.example.redrockmidtermexam.model.bean.Color
import com.example.redrockmidtermexam.model.viewModels.ColorDetailViewModel
import com.example.redrockmidtermexam.model.viewModels.ColorViewModel
import kotlinx.coroutines.launch

class ColorDetailActivity : AppCompatActivity(),View.OnClickListener {
    private val viewModel: ColorDetailViewModel by viewModels()
    lateinit var binding: ActivityColorDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("id", 1)
        initClickView()
        viewModel.isFinish.observe(this) {
            if (it) {
                initView()
            }
        }
        BaseApp.scope.launch {
            viewModel.getColorDetail(id)
        }
    }

    private fun initClickView() {
        binding.colorToolbarVector.setOnClickListener(this)
    }

    private fun initView() {
        val colorsData = viewModel.colorsData
        val shadeListData = viewModel.shadeListData
        colorsData.run {
            Log.d("bbp", "initView:${colorsData[0].name} ")
            binding.colorDetailToolbarTitle.text = this[0].name
            binding.colorDetailName.text = this[0].name
            binding.colorDetailA.setBackgroundColor(android.graphics.Color.parseColor("#${this[0].hex}"))
            binding.colorDetailB.setBackgroundColor(android.graphics.Color.parseColor("#${this[1].hex}"))
            binding.colorDetailC.setBackgroundColor(android.graphics.Color.parseColor("#${this[2].hex}"))
            binding.colorDetailD.setBackgroundColor(android.graphics.Color.parseColor("#${this[3].hex}"))
            binding.colorDetailE.setBackgroundColor(android.graphics.Color.parseColor("#${this[4].hex}"))
            binding.colorDetailF.setBackgroundColor(android.graphics.Color.parseColor("#${this[5].hex}"))
            binding.colorDetailG.setBackgroundColor(android.graphics.Color.parseColor("#${this[6].hex}"))
            binding.colorDetailTvHex.text = this[0].hex
            binding.colorDetailTvRgb.text = "${this[0].r},${this[0].g},${this[0].b}"
            binding.colorDetailTvCmyk.text = "${this[0].c},${this[0].m},${this[0].y},${this[0].k}"
            binding.colorDetailTvB.text = "#${this[1].hex}"
            binding.colorDetailTvC.text = "#${this[2].hex}"
            binding.colorDetailTvD.text = "#${this[3].hex}"
            binding.colorDetailTvE.text = "#${this[4].hex}"
            binding.colorDetailTvF.text = "#${this[5].hex}"
            binding.colorDetailTvG.text = "#${this[6].hex}"
        }
        shadeListData[0].run {
            val shade = ArrayList<Int>()
            for (i in this){
                shade.add(android.graphics.Color.parseColor("#${i.hex}"))
            }

        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.color_toolbar_vector->finish()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        finish()
        return super.onKeyDown(keyCode, event)
    }
}