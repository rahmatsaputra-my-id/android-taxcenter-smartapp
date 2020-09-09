package com.example.myapplication;

public class Item_card {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int image;

    public Item_card(){

    }

    public Item_card(String name,String description, int image){
        this.name = name;
        this.description = description;
        this.image = image;

    }
}
