package com.examplepyl.news.model;

import com.google.gson.annotations.SerializedName;

public class Source {
    /*id": "techcrunch",
"name"*/
    @SerializedName("id")
    public String id;

    @SerializedName("name")
   public String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
