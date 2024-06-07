package gr.aueb.cf.logindemoapp2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameET;
    private EditText passwordET;
    private Button loginBtn;
    private TextView questionTV;
    private TextView registerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        loginBtn = findViewById(R.id.loginBtn);
        questionTV = findViewById(R.id.questionTV);
        registerTV = findViewById(R.id.registerTV);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();

                if (username.isEmpty()) {
                    usernameET.setError("Please enter your username");
                } else if (password.isEmpty()) {
                    passwordET.setError("Please enter your password");
                } else if (username.equals("admin") && password.equals("12345")) {
                    Intent intent = new Intent(MainActivity.this, SecretActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}