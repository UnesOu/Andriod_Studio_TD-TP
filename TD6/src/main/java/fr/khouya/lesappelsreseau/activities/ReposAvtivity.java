package fr.khouya.lesappelsreseau.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import fr.khouya.lesappelsreseau.R;
import fr.khouya.lesappelsreseau.controllers.ReposAdapter;
import fr.khouya.lesappelsreseau.interfaces.GithubService;
import fr.khouya.lesappelsreseau.models.Repos;
import fr.khouya.lesappelsreseau.models.ReposSearches;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReposAvtivity extends AppCompatActivity {

    private List<Repos> repositories;

    private GithubService githubService;

    private RecyclerView recyclerView;
    private ReposAdapter reposAdapter;
    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos_avtivity);

        recyclerView = findViewById(R.id.repos_recycle_view);

        Intent intent = getIntent();
        if (intent.hasExtra("repos")) {
            query = intent.getStringExtra("repos");
        }

        githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);

        githubService.searchReposQuery(query).enqueue(new Callback<ReposSearches>() {
            @Override
            public void onResponse(Call<ReposSearches> call, Response<ReposSearches> response) {
                afficherLesRepos(response.body());
            }

            @Override
            public void onFailure(Call<ReposSearches> call, Throwable t) {
                onFailureGet();
            }
        });

    }

    public void afficherLesRepos(ReposSearches reposSearches) {
        this.repositories = reposSearches.getItems();
        reposAdapter = new ReposAdapter(this.repositories, githubService);
        recyclerView.setAdapter(reposAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onFailureGet() {
        Toast.makeText(this, "Erreur lors de l'appel de service", Toast.LENGTH_LONG).show();
    }
}