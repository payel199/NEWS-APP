package com.examplepyl.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.examplepyl.news.Network.RestManager;
import com.examplepyl.news.adapter.RecyclerViewAdapter;
import com.examplepyl.news.databinding.ActivityMainBinding;
import com.examplepyl.news.model.Article;
import com.examplepyl.news.model.News;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    //SearchView searchView;
    ArrayList<Article> articleuser=new ArrayList<>();
    RecyclerViewAdapter adapter;
    // private static final String API_KEY="cf6a9b30ffca4e309baa0656fb238f2b";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        articleuser=new ArrayList<>();
        adapter=new RecyclerViewAdapter(articleuser,MainActivity.this);
        binding.rcview.setAdapter(adapter);
         getUserData();
    }

    private  void getUserData(){
        Call<ResponseBody> getUser= RestManager.getInstance().getApiService().getDetail();
        getUser.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                int responseCode=response.code();
                if(responseCode==200){
                    try {
                        News news=new Gson().fromJson(response.body().string(),News.class);
                        articleuser.clear();
                        articleuser.addAll(news.articles);
                        adapter.notifyDataSetChanged();


                    }catch (Exception exception){
                        Log.e("Exception",""+exception.getMessage());
                    }
                }
                if(responseCode>=300 && responseCode<400){
                    Toast.makeText(MainActivity.this, "Redirection Detected", Toast.LENGTH_SHORT).show();
                }

                if(responseCode>399 && responseCode<500){
                    Toast.makeText(MainActivity.this, "Client Side Error", Toast.LENGTH_SHORT).show();
                }

                if(responseCode>499 && responseCode <600){
                    Toast.makeText(MainActivity.this, "Server SIde Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Get Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_menu:
                Toast.makeText(this, "search clicked", Toast.LENGTH_SHORT).show();
                return true;
            default: return true;
        }
    }
}



