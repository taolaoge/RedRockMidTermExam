package com.example.redrockmidtermexam.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityIdeaBinding
import com.example.redrockmidtermexam.model.viewModels.IdeaViewModel

class IdeaDetailActivity : AppCompatActivity() {

    private val viewModel: IdeaViewModel by viewModels()
    lateinit var binding: ActivityIdeaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdeaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}