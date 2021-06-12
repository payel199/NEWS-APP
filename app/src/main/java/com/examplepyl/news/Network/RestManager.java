package com.examplepyl.news.Network;

import android.net.Network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestManager {
    static RestManager instance = new RestManager();

    public  static RestManager getInstance(){
        return  instance;
    }
    private ApiService apiService;
    public  ApiService getApiService(){
        if (apiService==null){
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .readTimeout(500, TimeUnit.SECONDS)
                    .writeTimeout(500,TimeUnit.SECONDS)
                    .connectTimeout(500,TimeUnit.SECONDS)
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.base_url)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            apiService = retrofit.create(ApiService.class);
        }


        return apiService;
    }
}
