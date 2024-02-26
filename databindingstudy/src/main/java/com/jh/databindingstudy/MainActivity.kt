package com.jh.databindingstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.jh.databindingstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels() {
        MainViewModelFactory(10)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        initView()
//        initViewModel()
    }

    private fun initView()=with(binding) {
        btnCount.setOnClickListener {
            viewModel.liveData.value = viewModel.liveData.value?.plus(10)
        }
    }

//    private fun initViewModel()=with(viewModel) {
//        liveData.observe(this@MainActivity) {
//            binding.tvCounter.text = it.toString()
//        }
//    }
}