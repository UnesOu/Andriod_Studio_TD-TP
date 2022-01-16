package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView showLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());
        showLogin = findViewById(R.id.showLogin);

        NewsListApplication app = (NewsListApplication) getApplicationContext();

        showLogin.setText(app.getLogin());
    }
}