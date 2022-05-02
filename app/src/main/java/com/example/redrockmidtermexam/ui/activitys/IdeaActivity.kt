package com.example.redrockmidtermexam.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityIdeaBinding
import com.example.redrockmidtermexam.extentions.intent
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.viewModels.IdeaViewModel
import com.example.redrockmidtermexam.utils.filter
import kotlinx.coroutines.launch

class IdeaActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel: IdeaViewModel by viewModels()
    lateinit var binding: ActivityIdeaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdeaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.code.observe(this) {
            if (it != 114) this.toast(viewModel.message)
            else{
                for (i in 0 until viewModel.imageList.size) {
                    when (i) {
                        0 -> Glide.with(this).load(viewModel.imageList[0].filter())
                            .into(binding.ideaImg1)
                        1 -> Glide.with(this).load(viewModel.imageList[1].filter())
                            .into(binding.ideaImg2)
                        2 -> Glide.with(this).load(viewModel.imageList[2].filter())
                            .into(binding.ideaImage3)
                        3 -> Glide.with(this).load(viewModel.imageList[3].filter())
                            .into(binding.ideaImage4)
                    }
                }
            }
        }
        BaseApp.scope.launch {
            viewModel.getIdeaFirst()
        }
        initClickView()
    }

    private fun initClickView() {
        binding.ideaImage4.setOnClickListener(this)
        binding.ideaImage3.setOnClickListener(this)
        binding.ideaImg2.setOnClickListener(this)
        binding.ideaImg1.setOnClickListener(this)
        binding.ideaToolbarVector.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.idea_img1 -> {
                this.intent<IdeaDetailActivity>()
            }
            R.id.idea_toolbar_vector -> finish()
        }
    }
}