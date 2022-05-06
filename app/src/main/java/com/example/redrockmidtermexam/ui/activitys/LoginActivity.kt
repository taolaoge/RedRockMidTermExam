package com.example.redrockmidtermexam.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityLoginBinding
import com.example.redrockmidtermexam.extentions.intent
import com.example.redrockmidtermexam.extentions.toast
import com.example.redrockmidtermexam.model.viewModels.LoginViewModel
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    private val viewModel: LoginViewModel by viewModels()
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.code.observe(this){
            if (it == 114) finish() else this.toast(viewModel.message?:"")
        }
        viewModel.errorMsg.observe(this){
            this.toast(it)
        }
        initClickView()
    }

    private fun initClickView() {
        binding.loginToolbar.setOnClickListener(this)
        binding.loginBtnLogin.setOnClickListener(this)
        binding.loginTvGoRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.login_toolbar -> finish()
            R.id.login_btn_login -> login()
            R.id.login_tv_go_register ->toRegister()
        }
    }

    private fun toRegister() {
        this.intent<RegisterActivity>()
    }

    private fun login() {
        BaseApp.scope.launch {
            viewModel.postLogin(binding.loginEdPhoneNumber.text.toString())
        }
    }
}