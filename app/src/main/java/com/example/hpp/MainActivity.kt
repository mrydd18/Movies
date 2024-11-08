package com.example.hpp

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hpp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val movies = listOf(
        Movies(
            "Requiem for a Dream",
            8.3,
            imageView = R.drawable.requiemforadream
        ),

        Movies(
            "The Godfather",
            9.2,
            imageView = R.drawable.godfather
        ),

        Movies(
            "The Dark Knight",
            9.0,
            imageView = R.drawable.darkknight
        ),
        Movies(
            "Pulp Fiction",
            8.9,
            imageView = R.drawable.pulp
        ),
        Movies(
            "The Shawshank Redemption",
            9.3,
            imageView = R.drawable.shawshank
        ),
        Movies(
            "The Lord of the Rings",
            8.9,
            imageView = R.drawable.lordofrings
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.adapter = MoviesAdapter(movies)

    }
}
