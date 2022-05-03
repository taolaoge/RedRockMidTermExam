package com.example.redrockmidtermexam.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityRegisterBinding
import com.example.redrockmidtermexam.databinding.ActivityStarBinding
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.adapters.ColorRecycleViewAdapter
import com.example.redrockmidtermexam.model.adapters.StarListAdapter
import com.example.redrockmidtermexam.model.viewModels.RegisterViewModel
import com.example.redrockmidtermexam.model.viewModels.StarViewModel
import kotlinx.coroutines.launch

class StarActivity : AppCompatActivity() {
    private val viewModel: StarViewModel by viewModels()
    lateinit var binding: ActivityStarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.code.observe(this){
            if (it != 114) this.toast(viewModel.message)
            else{
             initRecycleView()
            }
        }
        BaseApp.scope.launch {
            viewModel.getStarList(1,100)
        }
        binding.starToolbarVector.setOnClickListener {
            finish()
        }
    }

    private fun initRecycleView() {
        val layoutManager1 = LinearLayoutManager(this)
        binding.starRv.run {
            adapter = StarListAdapter(viewModel.shadeList)
            layoutManager = layoutManager1
        }
    }
}