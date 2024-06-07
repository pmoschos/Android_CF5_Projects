package gr.aueb.cf.imdbapicall2024.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import gr.aueb.cf.imdbapicall2024.R;
import gr.aueb.cf.imdbapicall2024.adapters.MovieAdapter;
import gr.aueb.cf.imdbapicall2024.models.Movie;

public class MainActivity extends AppCompatActivity {

    private EditText searchET;
    private Button searchBtn;
    private RecyclerView recyclerView;
    private ArrayList<Movie> movieArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchET = findViewById(R.id.searchET);
        searchBtn = findViewById(R.id.searchBtn);
        recyclerView = findViewById(R.id.recyclerView);
        movieArrayList = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchET.getText().toString().trim().isEmpty()) {
                    searchET.setError("Please enter a movie name");
                    // searchET.setFocusable(true);
                } else {
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    // https://tv-api.com/en/API/SearchMovie/k_e2h9g4au/     (inception 2010)
                    String url = "https://tv-api.com/en/API/SearchMovie/k_e2h9g4au/" + searchET.getText().toString().trim();

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                movieArrayList.clear();
                                JSONArray jsonArray = response.getJSONArray("results");

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    Movie movie = new Movie();
                                    movie.setId(jsonObject.getString("id"));
                                    movie.setTitle(jsonObject.getString("title"));
                                    movie.setDescription(jsonObject.getString("description"));
                                    movie.setImage(jsonObject.getString("image"));
                                    movie.setResultType(jsonObject.getString("resultType"));

                                    // add movie to array list !
                                    movieArrayList.add(movie);
                                }

                                // set Adapter !!!
                                recyclerView.setAdapter(new MovieAdapter(movieArrayList));

                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });

                    requestQueue.add(jsonObjectRequest);

                }
            }
        });

    }
}