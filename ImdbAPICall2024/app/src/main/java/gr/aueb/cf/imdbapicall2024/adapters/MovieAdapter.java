package gr.aueb.cf.imdbapicall2024.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import gr.aueb.cf.imdbapicall2024.R;
import gr.aueb.cf.imdbapicall2024.models.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);
        holder.titleTV.setText(movie.getTitle());
        holder.descriptionTV.setText(movie.getDescription());

        if (!movie.getImage().isEmpty()) {
            Picasso.get().load(movie.getImage()).into(holder.movieIV);
        }
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private MaterialTextView titleTV;
        private MaterialTextView descriptionTV;
        private ImageView movieIV;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.titleTV);
            descriptionTV = itemView.findViewById(R.id.descriptionTV);
            movieIV = itemView.findViewById(R.id.movieIV);

        }
    }
}
