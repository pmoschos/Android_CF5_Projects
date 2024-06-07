package gr.aueb.cf.fragmentsapp2024a.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import gr.aueb.cf.fragmentsapp2024a.R;
import gr.aueb.cf.fragmentsapp2024a.fragments.FavoriteFragment;
import gr.aueb.cf.fragmentsapp2024a.fragments.HomeFragment;
import gr.aueb.cf.fragmentsapp2024a.fragments.PostFragment;
import gr.aueb.cf.fragmentsapp2024a.fragments.ProfileFragment;
import gr.aueb.cf.fragmentsapp2024a.fragments.UploadFragment;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNV;
    private TextView titleTV;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTV = findViewById(R.id.titleTV);
        toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frameLayout);
        bottomNV = findViewById(R.id.bottomNV);

        fragmentManager = getSupportFragmentManager();

        // when app opens then HomeFragment appears to the user
        bottomNV.getMenu().getItem(2).setChecked(true);
        fragmentManager.beginTransaction().replace(R.id.frameLayout, new HomeFragment(), "HomeFragment").commit();
        titleTV.setText("Home");

        bottomNV.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if (itemId == R.id.uploadItem) {
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, new UploadFragment(), "UploadFragment").commit();
                    titleTV.setText("Upload");
                } else if (itemId == R.id.postItem) {
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, new PostFragment(), "PostFragment").commit();
                    titleTV.setText("My Posts");
                } else if (itemId == R.id.homeItem) {
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, new HomeFragment(), "HomeFragment").commit();
                    titleTV.setText("Home");
                } else if (itemId == R.id.favoriteItem) {
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, new FavoriteFragment(), "FavoriteFragment").commit();
                    titleTV.setText("Favorites");
                } else if (itemId == R.id.profileItem) {
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, new ProfileFragment(), "ProfileFragment").commit();
                    titleTV.setText("Profile");
                }

                return true;
            }
        });

    }
}