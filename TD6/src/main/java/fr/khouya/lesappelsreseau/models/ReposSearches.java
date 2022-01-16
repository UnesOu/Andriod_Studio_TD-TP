package fr.khouya.lesappelsreseau.models;

import java.util.List;

public class ReposSearches {

    private int total_count;
    private List<Repos> items;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<Repos> getItems() {
        return items;
    }

    public void setItems(List<Repos> items) {
        this.items = items;
    }
}
