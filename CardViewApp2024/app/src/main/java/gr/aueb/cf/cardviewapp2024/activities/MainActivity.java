package gr.aueb.cf.cardviewapp2024.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import gr.aueb.cf.cardviewapp2024.R;
import gr.aueb.cf.cardviewapp2024.adapters.MyAdapter;
import gr.aueb.cf.cardviewapp2024.models.Movie;

public class MainActivity extends AppCompatActivity {

    private String[] titles = {"Title 01", "Title 02", "Title 03", "Title 04", "Title 05", "Title 06"};
    private String[] categories = {"Category 01", "Category 02", "Category 03", "Category 04", "Category 05", "Category 06"};
    private int[] images = {
      R.drawable.image01,
      R.drawable.image02,
      R.drawable.image03,
      R.drawable.image04,
      R.drawable.image05,
      R.drawable.image06
    };
    private ArrayList<Movie> movieArrayList;
    private ConstraintLayout mainLayout;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        recyclerView = findViewById(R.id.recyclerView);

        movieArrayList = new ArrayList<>();
        setMyData(); // check

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(movieArrayList);
        recyclerView.setAdapter(myAdapter);

        // ItemTouchHelper
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    } // end of onCreate()

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
    ) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int moviePosition = viewHolder.getAdapterPosition();
            Movie movie = movieArrayList.remove(moviePosition);
            String movieTitle = movie.getTitle();

            myAdapter.notifyDataSetChanged();

            // Snackbar.make(MainActivity.this, mainLayout, movieTitle + " deleted!", Snackbar.LENGTH_LONG).show();
            Snackbar snackbar = Snackbar.make(MainActivity.this, mainLayout, movieTitle + " deleted!", Snackbar.LENGTH_LONG);
            snackbar.setDuration(8000)
                    .setTextColor(Color.BLACK)
                    .setBackgroundTint(Color.GRAY)
                    .setActionTextColor(Color.WHITE)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            movieArrayList.add(moviePosition, movie);
                            myAdapter.notifyDataSetChanged();
                        }
                    });

            // Custom text size, textStyle...
            View snackBarView = snackbar.getView();
            TextView textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);

            snackbar.show();

        }
    };

    private void setMyData() {
        for (int i = 0; i < titles.length; i++) {
            Movie movie = new Movie(titles[i], categories[i], images[i]);
            movieArrayList.add(movie);
        }
        for (int i = 0; i < titles.length; i++) {
            Movie movie = new Movie(titles[i], categories[i], images[i]);
            movieArrayList.add(movie);
        }
    }
}