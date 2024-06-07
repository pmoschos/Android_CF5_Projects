package gr.aueb.cf.relativeappdemo2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView ratingTV;
    private TextView ageTV;
    private EditText urlET;
    private Button navigateBtn;
    private final String SHARED_PREF = "sharedPrefs";
    private final String URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ratingTV = findViewById(R.id.ratingTV);
        ageTV = findViewById(R.id.ageTV);
        urlET = findViewById(R.id.urlET);
        navigateBtn = findViewById(R.id.navigateBtn);

        Intent intent = getIntent();
        String ratings = intent.getStringExtra("rating");
        String age = intent.getStringExtra("age");

        ageTV.setText("Age: " + age);
        ratingTV.setText("Rating: " + ratings);

        loadUrl();

        navigateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlET.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

                saveUrl(url);
            }
        });
    }

    private void saveUrl(String url) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(URL, url);
        editor.apply();
    }

    private void loadUrl() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        String myUrl = sharedPreferences.getString(URL, "");
        urlET.setText(myUrl);
    }

}