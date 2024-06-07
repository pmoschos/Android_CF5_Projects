package gr.aueb.cf.cardviewapp2024.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import gr.aueb.cf.cardviewapp2024.R;
import gr.aueb.cf.cardviewapp2024.models.Movie;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Movie> movieArrayList;

    public MyAdapter(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_list,
                parent,
                false
        );

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // String movieName = movieArrayList.get(position).getTitle();
        holder.tvTitle.setText(movieArrayList.get(position).getTitle());
        holder.tvCategory.setText(movieArrayList.get(position).getCategory());
        holder.ivImage.setImageResource(movieArrayList.get(position).getImage());

        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                CharSequence text = holder.tvTitle.getText().toString();
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvCategory;
        private ImageView ivImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            ivImage = itemView.findViewById(R.id.ivImage);

        }


    }
}
