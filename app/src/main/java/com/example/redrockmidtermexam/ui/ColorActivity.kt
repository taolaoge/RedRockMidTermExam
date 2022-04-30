package com.example.redrockmidtermexam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityColorBinding
import com.example.redrockmidtermexam.model.viewModels.ColorViewModel
import com.example.redrockmidtermexam.ui.fragments.ColorFragment

class ColorActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel: ColorViewModel by viewModels()
    lateinit var binding: ActivityColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragmentsAdapter()
        initClickView()
    }

    private fun initFragmentsAdapter() {


        //取消vp2滑动到底滑不动时的动画
        val child: View = binding.colorVp2.getChildAt(0)
        if (child is RecyclerView) {
            child.setOverScrollMode(View.OVER_SCROLL_NEVER)
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