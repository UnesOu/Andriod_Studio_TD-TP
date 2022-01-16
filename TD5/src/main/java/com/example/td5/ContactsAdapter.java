package com.example.td5;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private final List<Contact> mContacts;
    private Context mContext;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstNameTextView;
        public TextView lastNameTextView;
        public ImageView imageView;

        public ViewHolder(View itemView){
            super(itemView);
            firstNameTextView = (TextView) itemView.findViewById(R.id.firstName);
            lastNameTextView = (TextView) itemView.findViewById(R.id.lastName);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public ContactsAdapter(List<Contact> contacts,Context context){
        mContacts = contacts;
        mContext = context;

    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact,parent,false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);

        TextView firstNameTextView = holder.firstNameTextView;
        firstNameTextView.setText(contact.getFirstName());

        TextView lastNameTextView = holder.lastNameTextView;
        lastNameTextView.setText(contact.getLastName());

        ImageView imageUrl = holder.imageView;
        Glide.with(mContext).load(contact.getImageURL()).into(imageUrl);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }


}
