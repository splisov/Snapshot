package com.example.grandhis.snapshot;

import android.graphics.Bitmap;

import java.util.Date;

/**
 * Created by Sergey on 10/5/2014.
 */
public class FriendListItem {
    String name;
    Date date;
    Bitmap picture;
    String url;

    public FriendListItem(String name, Date date, String url, Bitmap picture) {
        this.name = name;
        this.date = date;
        this.url = url;
        this.picture = picture;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }
}
