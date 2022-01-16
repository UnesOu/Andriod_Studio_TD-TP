package com.example.td5;

public class Contact {
    private String lastName;
    private String firstName;
    private String imageURL;

    public Contact(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Contact(String lastName, String firstName, String imageURL) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.imageURL = imageURL;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
