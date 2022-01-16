package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {
    TextView userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());
        userLogin = findViewById(R.id.userLogin);

        Intent loginIntent = getIntent();
        if(loginIntent.hasExtra("login")){
            userLogin.setText(loginIntent.getStringExtra("login"));
        }

        String url = "https://news.google.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }
}