package com.etoolkit.photoapi.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.etoolkit.photoapi.R
import com.etoolkit.photoapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)


        binding.nextButton.setOnClickListener {
            viewModel.fetchRandomPhoto()
        }


        viewModel.fetchRandomPhoto().observe(this,{
            binding.author.text = it.user.last_name
            binding.bio.text = it.description
            binding.location.text = it.location.title
            Glide.with(this.applicationContext)
                .load(it.urls.full)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.photoImage)
        })
    }
}