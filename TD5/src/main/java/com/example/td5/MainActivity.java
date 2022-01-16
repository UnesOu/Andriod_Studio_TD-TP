package com.example.td5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewContacts = (RecyclerView) findViewById(R.id.rvContacts);

        contacts.add(new Contact("EL ALAM","Nassim","https://via.placeholder.com/150"));
        contacts.add(new Contact("hamid","salhi","https://via.placeholder.com/150"));
        contacts.add(new Contact("bazza","housni","https://via.placeholder.com/150"));
        contacts.add(new Contact("benzidon","saad","https://via.placeholder.com/150"));


        ContactsAdapter adapter = new ContactsAdapter(contacts,this);
        recyclerViewContacts.setAdapter(adapter);
        recyclerViewContacts.setLayoutManager(new LinearLayoutManager(this));

    }
}