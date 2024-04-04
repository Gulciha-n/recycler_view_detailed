package com.gulcihan.recyclerviewdetailed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(private val mcontex:Context , private val moviesList:List<Movies>)
    :RecyclerView.Adapter<MoviesAdapter.cardDesignObjectsHolder>() {

    inner class cardDesignObjectsHolder(view: View) : RecyclerView.ViewHolder(view){

        val imageViewMovie : ImageView
        val textViewMovieTitle : TextView
        val textViewMoviePrice : TextView
        val buttonAddCart : Button

        init{
            imageViewMovie = view.findViewById(R.id.imageViewMovie)
            textViewMovieTitle = view.findViewById(R.id.textViewMovieTitle)
            textViewMoviePrice = view.findViewById(R.id.textViewMoviePrice)
            buttonAddCart = view.findViewById(R.id.buttonAddCart)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardDesignObjectsHolder {
        val design = LayoutInflater.from(mcontex).inflate(R.layout.card_movie_design, parent ,false)
        return cardDesignObjectsHolder(design)
        //Binding design
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: cardDesignObjectsHolder, position: Int) {
        val movie = moviesList[position]

        holder.textViewMovieTitle.text = movie.movieName
        holder.textViewMoviePrice.text = "${movie.movie_price} $"

        holder.imageViewMovie.setImageResource(mcontex.resources.getIdentifier(movie.movie_image_name,"drawable",mcontex.packageName))

        holder.buttonAddCart.setOnClickListener {
            Toast.makeText(mcontex,"${movie.movieName} added to the card",Toast.LENGTH_LONG).show()

            /*
            hangi veriyi hangi görsel nesneye bağlayacağımızı belirttiğimiz yerdir.
            Veri kümesini ve tasarım üzerindeki görselleri düzenlediğimiz ve organize ettiğimiz yer burası.
            Bize sırayla veri kümesindeki verileri verir ve biz bu verilere erişerek  hangi veriyi hangi görsel
            nesneye bağlayacağımızı belirtiyoruz.
             */
        }
    }
}












