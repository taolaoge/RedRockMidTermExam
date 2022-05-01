package com.example.redrockmidtermexam.ui.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.redrockmidtermexam.BaseApp
import com.example.redrockmidtermexam.R
import com.example.redrockmidtermexam.databinding.ActivityIdeaDetailBinding
import com.example.redrockmidtermexam.model.adapters.IdeaDetailViewPagerAdapter
import com.example.redrockmidtermexam.model.viewModels.IdeaDetailViewModel
import kotlinx.coroutines.launch

class IdeaDetailActivity : AppCompatActivity(),View.OnClickListener {

    private val viewModel: IdeaDetailViewModel by viewModels()
    lateinit var binding: ActivityIdeaDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdeaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.isFinish.observe(this){
            if (it){
                initAdapter()
            }
        }
        BaseApp.scope.launch {
            repeat(7) {
                viewModel.getIdeaDetail(it + 1)
            }
        }
        //取消vp2滑动到底滑不动时的动画
        val child: View = binding.ideaDetailVp2.getChildAt(0)
        if (child is RecyclerView) {
            child.setOverScrollMode(View.OVER_SCROLL_NEVER)
        }
        binding.ideaDetailVp2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.ideaDetailToolbarTitle.text = viewModel.titleList[position]
            }
        })

        binding.ideaDetailToolbarVector.setOnClickListener(this)
    }

    private fun initAdapter() {
        runOnUiThread{
            binding.ideaDetailVp2.adapter = IdeaDetailViewPagerAdapter(viewModel.responseList)
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.idea_detail_toolbar_vector->finish()
        }
    }
}