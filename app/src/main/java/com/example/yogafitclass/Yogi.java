package com.example.yogafitclass;

public class Yogi {

    private int id;
    private String name;
    private String author;
    private String detail;
    private String price;
    private String image;

    public Yogi(int id, String name, String author, String detail, String price, String image) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.detail = detail;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

