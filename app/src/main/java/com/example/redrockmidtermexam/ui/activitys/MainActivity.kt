package com.example.redrockmidtermexam.ui.activitys

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityMainBinding
import com.example.redrockmidtermexam.model.viewModels.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel: MainViewModel by viewModels()
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
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.main_color,R.id.textView_color -> {
                val intent = Intent(this, ColorActivity::class.java)
                startActivity(intent)
            }
            R.id.main_idea,R.id.textView_idea->{
                val intent = Intent(this, IdeaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}