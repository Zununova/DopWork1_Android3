package com.example.dopwork1_android3.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.dopwork1_android3.R
import com.example.dopwork1_android3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setUpObserve()
        setUpListener()
    }

    private fun setUpObserve() {
        mainViewModel.count.observe(this) { count ->
            binding.textViewNumber.text = count.toString()
        }
        mainViewModel.changeColor.observe(this) { bool ->
            val colorRes = if (bool) R.color.teal_200 else R.color.white
            binding.textViewNumber.setTextColor(ContextCompat.getColor(this, colorRes))
        }
    }

    private fun setUpListener() = with(binding) {
        buttonPlus.setOnClickListener {
            mainViewModel.plus()
        }
        buttonMinus.setOnClickListener {
            mainViewModel.minus()
        }
    }
}
