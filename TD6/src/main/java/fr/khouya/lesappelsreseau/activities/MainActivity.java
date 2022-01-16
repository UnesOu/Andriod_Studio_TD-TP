package fr.khouya.lesappelsreseau.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import fr.khouya.lesappelsreseau.R;
import fr.khouya.lesappelsreseau.interfaces.GithubService;
import fr.khouya.lesappelsreseau.models.Repos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button btn_repos;
    private EditText editText_repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_repos = findViewById(R.id.repos_btn_search);
        editText_repos = findViewById(R.id.repos_edittext_search);

        btn_repos.setOnClickListener(v -> {
            String q = String.valueOf(editText_repos.getText());
            Intent intent = new Intent(MainActivity.this, ReposAvtivity.class);
            intent.putExtra("repos", q);
            startActivity(intent);
        });

    }

}