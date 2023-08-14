package com.example.platzi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.platzi.R
import com.example.platzi.databinding.ActivityMainBinding
import com.example.platzi.ui.productadapter.productadapter
import com.example.platzi.viewmodels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //initialize the viewmodels
    val viewmodel:ProductViewModel by viewModels()

lateinit var adapter:productadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        adapter=productadapter()
        binding.Recyclerviewid.adapter=adapter

        viewmodel.allProducts.observe(this@MainActivity){

           adapter.submitList(it)
        }




    }
}