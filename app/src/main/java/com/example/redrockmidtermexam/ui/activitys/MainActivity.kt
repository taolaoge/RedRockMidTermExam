package com.example.redrockmidtermexam.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityMainBinding
import com.example.redrockmidtermexam.model.viewModels.MainViewModel

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private val viewModel:MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickView()
    }

    private fun initClickView() {
        binding.mainColor.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.main_color->{
                val intent = Intent(this, ColorActivity::class.java)
                startActivity(intent)
            }
        }
    }
}