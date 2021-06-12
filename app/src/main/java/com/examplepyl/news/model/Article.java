package com.examplepyl.news.model;

import com.google.gson.annotations.SerializedName;

public class Article {
    /*"source": {
"id": "techcrunch",
"name": "TechCrunch"
},
"author": "Alex Wilhelm, Natasha Mascarenhas",
"title": "Why sports tech is bigger than a game",
"description": "Hello and welcome back to Equity, TechCrunch’s venture capital-focused podcast, where we unpack the numbers behind the headlines. For this week’s deep dive, Alex and Natasha dug into the burgeoning of sports media, sports gaming, and fantasy sports world toda…",
"url": "https://techcrunch.com/2021/06/02/why-sports-tech-is-bigger-than-a-game/",
"urlToImage": "https://techcrunch.com/wp-content/uploads/2020/07/equity-podcast-2019-phone.jpg?w=711",
"publishedAt": "2021-06-02T14:00:51Z",
"content"*/

    @SerializedName("source")
   public Source source;

    @SerializedName("author")
    public String author;

    @SerializedName("title")
   public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("url")
    public String url;

    @SerializedName("urlToImage")
    public String urlToImage;

    @SerializedName("publishedAt")
   public String publishedAt;

    @SerializedName("content")
    public String content;

    public Source getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }
}