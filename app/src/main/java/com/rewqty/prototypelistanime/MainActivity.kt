 package com.rewqty.prototypelistanime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rewqty.prototypelistanime.databinding.ActivityMainBinding
import com.rewqty.prototypelistanime.model.Anime

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AnimeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getAnimeTop()
        viewModel.myResponseList.observe(this, Observer {
            adapter = AnimeAdapter()
            adapter.data = it

            val manager = LinearLayoutManager(this)
            binding.animeList.layoutManager = manager
            binding.animeList.adapter = adapter
        })
    }
}