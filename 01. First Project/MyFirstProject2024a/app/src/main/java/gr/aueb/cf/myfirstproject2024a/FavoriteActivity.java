package gr.aueb.cf.myfirstproject2024a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class FavoriteActivity extends AppCompatActivity {

    private static final String TAG = "myTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Favorite onDestroy called");
    }
}