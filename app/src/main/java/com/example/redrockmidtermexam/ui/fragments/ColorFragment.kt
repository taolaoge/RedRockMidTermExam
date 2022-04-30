package com.example.redrockmidtermexam.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.databinding.FragmentColorBinding
import com.example.redrockmidtermexam.model.bean.Color
import com.example.redrockmidtermexam.model.viewModels.ColorFragmentViewModel
import kotlinx.coroutines.launch

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/4/30
 */
class ColorFragment() :Fragment() {
    private val data = ArrayList<Color>()
    private val viewModel by viewModels<ColorFragmentViewModel>()
    private lateinit var binding:FragmentColorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentColorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}