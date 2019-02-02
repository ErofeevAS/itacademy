package com.gmail.erofeev.st.alexei.homework21.model;

import java.util.Date;

public class Book {
    private String id;
    private String author;
    private String title;
    private String genre;
    private float price;
    private String date;
    private String description;

    private Book(Builder builder) {
        id = builder.id;
        author = builder.author;
        title = builder.title;
        genre = builder.genre;
        price = builder.price;
        date = builder.date;
        description = builder.description;
    }

    public String getAuthor() {
        return author;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public float getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static final class Builder {
        private String id;
        private String author;
        private String title;
        private String genre;
        private float price;
        private String date;
        private String description;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder author(String val) {
            author = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder genre(String val) {
            genre = val;
            return this;
        }

        public Builder price(float val) {
            price = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
