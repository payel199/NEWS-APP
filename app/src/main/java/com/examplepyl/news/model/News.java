package com.examplepyl.news.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {

    /* status": "ok",
"totalResults": 10,
"articles":*/
    @SerializedName("status")
   public   String status;

    @SerializedName("totalResults")
    public   int totalResults;

    @SerializedName("articles")
    public List<Article> articles;


}
