package com.example.tp1_movies_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize and assign variable
        BottomNavigationView navView = findViewById(R.id.nav_view);

        //Set Home Selected
        navView.setSelectedItemId(R.id.navigation_popular_movie);

        //Perform ItemSelectedListener
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_popular_movie:
                        Intent i = new Intent(MainActivity.this, PopularMovies.class);
                        startActivity(i);
                        finish();
                        break;

                    case R.id.navigation_new_movies:
                        i = new Intent(MainActivity.this, NewMovies.class);
                        startActivity(i);
                        finish();
                        break;
                }
                return false;
            }
        });

    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.navigation_popular_movie:
                Intent i = new Intent(MainActivity.this, PopularMovies.class);
                startActivity(i);
                finish();
                break;

            case R.id.navigation_new_movies:
                 i = new Intent(MainActivity.this, NewMovies.class);
                startActivity(i);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/
}