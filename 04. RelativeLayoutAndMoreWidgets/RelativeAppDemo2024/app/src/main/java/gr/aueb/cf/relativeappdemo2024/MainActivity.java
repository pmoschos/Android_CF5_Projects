package gr.aueb.cf.relativeappdemo2024;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private CheckBox athensCB;
    private CheckBox patraCB;
    private RadioGroup agreeRG;
    private RatingBar likeRB;
    private SeekBar ageSB;
    private Switch switchBtn;
    private Button submitBtn;
    private RelativeLayout fullView;
    private TextView seekBarTV;
    private String ratingStars;
    private String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        athensCB = findViewById(R.id.athensCB);
        patraCB = findViewById(R.id.patraCB);
        agreeRG = findViewById(R.id.agreeRG);
        likeRB = findViewById(R.id.likeRB);
        ageSB = findViewById(R.id.ageSB);
        switchBtn = findViewById(R.id.switchBtn);
        submitBtn = findViewById(R.id.submitBtn);
        fullView = findViewById(R.id.fullView);
        seekBarTV = findViewById(R.id.seekBarTV);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("rating", ratingStars);
                intent.putExtra("age", age);
                startActivity(intent);
            }
        });

        likeRB.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingStars = String.valueOf(rating);
                Toast.makeText(MainActivity.this, ratingStars, Toast.LENGTH_SHORT).show();
            }
        });

        ageSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarTV.setText("Set your age (allowed 18 to 65): " + progress);
                age = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchBtn.setText("dark");
                    scrollView.setBackgroundColor(getColor(R.color.blue_03));
                    fullView.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue_02));
                } else {
                    switchBtn.setText("light");
                    scrollView.setBackgroundColor(getColor(R.color.blue_02));
                    fullView.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue_01));
                }
            }
        });

    }
}