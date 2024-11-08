package com.example.hpp
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hpp.databinding.CustomToastBinding
import com.example.hpp.databinding.ItemsMoviesBinding


class MoviesAdapter(private val movies: List<Movies>) : RecyclerView.Adapter<MoviesAdapter.UserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemsMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = movies[position]
        holder.binding.movieName.text = user.moviename
        holder.binding.imdbScore.text = user.imdbscore.toString()
        holder.binding.imageView.setImageResource(user.imageView)
        holder.binding.infoButton.setOnClickListener {
        holder.itemView.context.showCustomToast("${user.moviename}${user.imdbscore}")
        }

    }

    override fun getItemCount() = movies.size



    class UserViewHolder(val binding: ItemsMoviesBinding) : RecyclerView.ViewHolder(binding.root)


}
fun Context.showCustomToast(message: String) {
    // Inflate custom layout using view binding
    val inflater = LayoutInflater.from(this)
    val binding = CustomToastBinding.inflate(inflater)

    binding.toastText.text = message
    binding.toastText.setTextColor(Color.WHITE)
    binding.root.setBackgroundColor(Color.BLACK)

    with (Toast(this)) {
        duration = Toast.LENGTH_SHORT
        view = binding.root
        setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 200)
        show()
    }
}