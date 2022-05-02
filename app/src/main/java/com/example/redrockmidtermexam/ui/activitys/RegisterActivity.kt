package com.example.redrockmidtermexam.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityLoginBinding
import com.example.redrockmidtermexam.databinding.ActivityRegisterBinding
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.viewModels.LoginViewModel
import com.example.redrockmidtermexam.model.viewModels.RegisterViewModel
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private val viewModel: RegisterViewModel by viewModels()
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.code.observe(this){
            if (it == 114) finish() else  this.toast(viewModel.message)
        }
        binding.registerBtnRegister.setOnClickListener {
             BaseApp.scope.launch {
                 viewModel.postRegister(
                     binding.registerEdPhoneNumber.text.toString(),
                     binding.registerEdName.text.toString()
                 )
             }
        }
    }
}