package fr.khouya.lesappelsreseau.interfaces;

import java.util.List;

import fr.khouya.lesappelsreseau.models.Commit;
import fr.khouya.lesappelsreseau.models.Repos;
import fr.khouya.lesappelsreseau.models.ReposSearches;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService {

    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    Call<List<Repos>> userRepos(@Path("user") String user);

    @GET("/search/repositories")
    Call<List<Repos>> searchRepos(@Query("q") String query);

    @GET("/search/repositories")
    Call<ReposSearches> searchReposQuery(@Query("q") String query);

    @GET("/repos/{user}/{repos}/commits")
    Call<List<Commit>> getCommits(@Path("user") String user, @Path("repos") String repos);

}
