package com.examplepyl.news.Network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("top-headlines?sources=techcrunch&apiKey=94e34e7eacd14679b372843cdc306306")
    public Call<ResponseBody> getDetail();

  //  https://newsapi.org/v2/everything?q=tesla&from=2021-05-11&sortBy=publishedAt&apiKey=94e34e7eacd14679b372843cdc306306

}
