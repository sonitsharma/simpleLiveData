package com.sonit.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sonit.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java)


        // get total using with out live data
        binding.resultTextViewWold.text = viewModel.getTotal().toString()


        // get total using livedata
        viewModel.total_ld_secure.observe(this, Observer {
            binding.resultTextViewWld.text = it.toString()
        })

        binding.insertButton.setOnClickListener {
            viewModel.setTotal(binding.inputEditText.text.toString().toInt())
            viewModel.setTotalUsingLivedata((binding.inputEditText.text.toString().toInt()))

          // need to get value in case we are not using Live data
            binding.resultTextViewWold.text = viewModel.getTotal().toString()
        }



        binding.counterButton.setOnClickListener {
            viewModel.triggerCounter()
        }

        viewModel._newCounterValue.observe(this, Observer {
            binding.counterTv.text = it.toString()
        })

    }
}