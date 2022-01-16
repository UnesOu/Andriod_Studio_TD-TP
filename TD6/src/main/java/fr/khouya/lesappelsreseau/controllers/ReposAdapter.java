package fr.khouya.lesappelsreseau.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import fr.khouya.lesappelsreseau.R;
import fr.khouya.lesappelsreseau.interfaces.GithubService;
import fr.khouya.lesappelsreseau.models.Commit;
import fr.khouya.lesappelsreseau.models.Repos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {

    private final List<Repos> reposList;
    private final GithubService githubService;

    public ReposAdapter(List<Repos> repos, GithubService githubService) {
        this.reposList = repos;
        this.githubService = githubService;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View reposView = inflater.inflate(R.layout.repos_item, parent, false);
        return new ViewHolder(reposView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repos repos = reposList.get(position);

        int nb_commits = 0;

        ImageView avatar = holder.avatar;
        Glide.with(holder.itemView)
                .load(repos.getOwner().getAvatar_url())
                .centerCrop()
                .placeholder(R.drawable.github)
                .into(avatar);

        TextView owner = holder.owner;
        owner.setText(repos.getOwner().getLogin());

        TextView repository = holder.repository;
        repository.setText(repos.getName());

        TextView issues = holder.issues;
        issues.setText(String.valueOf(repos.getOpen_issues()));

        TextView commits = holder.commits;
        githubService.getCommits(repos.getOwner().getLogin(), repos.getName()).enqueue(new Callback<List<Commit>>() {
            @Override
            public void onResponse(Call<List<Commit>> call, Response<List<Commit>> response) {
                if (response.body() != null) {
                    commits.setText(String.valueOf(getNbCommits(response.body())));
                } else {
                    commits.setText("0");
                }
            }

            @Override
            public void onFailure(Call<List<Commit>> call, Throwable t) { }
        });

        TextView language = holder.language;
        language.setText(repos.getLanguage());

    }

    @Override
    public int getItemCount() {
        return this.reposList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView avatar;
        public TextView owner;
        public TextView repository;
        public TextView issues;
        public TextView commits;
        public TextView language;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            avatar = itemView.findViewById(R.id.repos_avatar_owner);
            owner = itemView.findViewById(R.id.repos_nom_owner);
            repository = itemView.findViewById(R.id.repos_nom_repos);
            issues = itemView.findViewById(R.id.repos_issues);
            commits = itemView.findViewById(R.id.repos_commits);
            language = itemView.findViewById(R.id.repos_language);

        }
    }

    private int getNbCommits(List<Commit> commits) {
        return commits.size();
    }
}
