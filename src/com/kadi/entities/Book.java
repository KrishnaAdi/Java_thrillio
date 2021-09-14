package com.kadi.entities;

public class Book extends Bookmark{
    private int publicationYear;
    private String publisher;
    private String[] autors;
    private String genre;
    private double amazonRating;

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAutors() {
        return autors;
    }

    public void setAutors(String[] autors) {
        this.autors = autors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }
}
