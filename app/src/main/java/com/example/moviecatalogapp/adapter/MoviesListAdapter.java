package com.example.moviecatalogapp.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecatalogapp.R;
import com.example.moviecatalogapp.clickHandler.ClickHandler;
import com.example.moviecatalogapp.databinding.MovieCardViewBinding;
import com.example.moviecatalogapp.modal.Movies;

import java.util.List;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MoviesListViewHolder> {

    private Context context;
    private ClickHandler clickHandler;

    private List<Movies> moviesList;
    private MovieCardViewBinding binding;


    public MoviesListAdapter(Context context, List<Movies> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
        clickHandler = new ClickHandler(context);
    }


    @NonNull
    @Override
    public MoviesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movie_card_view, parent, false);
        return new MoviesListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesListViewHolder holder, int position) {

        Movies movie = moviesList.get(position);

        float ratingValue = getRatingValueOfPosition(position);

        if (ratingValue != 0.0 ){
            holder.binding.ratingBar.setRating(ratingValue);
            holder.binding.ratingBar.setVisibility(View.VISIBLE);
        }else {
            holder.binding.ratingBar.setVisibility(View.GONE);
        }

        holder.binding.cardView.setOnClickListener(view -> {
            int clickCount = clickHandler.getClickCount(position);
            if (clickCount % 5 != 0){
                clickHandler.giveDescription(view, movie);
            } else {
                clickHandler.ratingActivity(view, position, movie.number);
            }
        });

        holder.binding.setCardViewItem(movie);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public static class MoviesListViewHolder extends RecyclerView.ViewHolder {

        MovieCardViewBinding binding;

        public MoviesListViewHolder(@NonNull MovieCardViewBinding cardViewBinding) {
            super(cardViewBinding.getRoot());
            binding = cardViewBinding;
        }
    }

    private float getRatingValueOfPosition(int position){
        SharedPreferences sharedPreferences = context.getSharedPreferences("RATING_POS", Context.MODE_PRIVATE);
        return sharedPreferences.getFloat("rating"+position, 0);
    }
}
