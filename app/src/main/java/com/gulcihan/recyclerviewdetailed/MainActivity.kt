package com.gulcihan.recyclerviewdetailed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gulcihan.recyclerviewdetailed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var moviesArrayList : ArrayList<Movies>
    private lateinit var adapter : MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        moviesArrayList = ArrayList<Movies>()

        val movie1 = Movies(1, "The Pianist", "thepianist", 8.5)
        val movie2 = Movies(2, "Bir Zamanlar Anadolu'da", "birzamanlaranadoluda", 7.8)
        val movie3 = Movies(3, "Django Unchained", "django", 8.4)
        val movie4 = Movies(4, "Inception", "inception", 8.8)
        val movie5 = Movies(5, "Interstellar", "interstellar", 8.6)
        val movie6 = Movies(6, "The Hateful Eight", "thehatefuleight", 7.8)

        moviesArrayList.add(movie1)
        moviesArrayList.add(movie2)
        moviesArrayList.add(movie3)
        moviesArrayList.add(movie4)
        moviesArrayList.add(movie5)
        moviesArrayList.add(movie6)


        adapter = MoviesAdapter(this@MainActivity , moviesArrayList)
        binding.recyclerView.adapter = adapter

    }
}