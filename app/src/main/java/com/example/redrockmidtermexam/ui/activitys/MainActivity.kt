package com.example.redrockmidtermexam.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.edit
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityMainBinding
import com.example.redrockmidtermexam.extentions.intent
import com.example.redrockmidtermexam.extentions.toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickView()
    }

    private fun initClickView() {
        binding.mainColor.setOnClickListener(this)
        binding.mainIdea.setOnClickListener(this)
        binding.mainStar.setOnClickListener(this)
        binding.mainBtnOut.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.main_color, R.id.textView_color -> {
                this.intent<ColorActivity>()
            }
            R.id.main_idea, R.id.textView_idea -> {
                this.intent<IdeaActivity>()
            }
            R.id.main_star -> {
                val token = BaseApp.header.getString("token","false")
                if (token == "false"){
                    this.intent<LoginActivity>()
                }else{
                    this.intent<StarActivity>()
                }
            }
            R.id.main_btn_out -> {
                //清除token数据
                if (BaseApp.header.getString("token","false") == "false")
                    this.toast("还未登录")
                else{
                    BaseApp.header.edit{
                        clear()
                    }
                }
            }
        }
    }
}