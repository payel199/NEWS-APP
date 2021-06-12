package com.examplepyl.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.examplepyl.news.R;
import com.examplepyl.news.model.Article;


import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {
    ArrayList<Article> userList;
    Context appcontext;
    ArrayList<Article> backup;

    public RecyclerViewAdapter(ArrayList<Article> userList, Context appcontext) {
        this.userList = userList;
        this.appcontext= appcontext;
        backup=new ArrayList<>(userList);
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Article users=userList.get(position);
        holder.authorTv.setText(users.getAuthor());
        holder.titleTv.setText(users.getTitle());
        holder.desTv.setText(users.getDescription());
        holder.dateTv.setText(users.getPublishedAt());
        holder.contentTv.setText(users.getContent());
        holder.sourceTv.setText(users.getSource().getName());

        if(users.getUrlToImage()!=null || !users.getUrlToImage().isEmpty())
        {
            Glide.with(appcontext).load(users.getUrlToImage()).into(holder.imageTv);

        }

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView authorTv,titleTv,desTv,contentTv,dateTv,sourceTv;
        ImageView imageTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            authorTv=itemView.findViewById(R.id.author);
            titleTv=itemView.findViewById(R.id.title);
            desTv=itemView.findViewById(R.id.desc);
            contentTv=itemView.findViewById(R.id.content);
            dateTv=itemView.findViewById(R.id.time);
            sourceTv=itemView.findViewById(R.id.source);
            imageTv=itemView.findViewById(R.id.img);
        }
    }
    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<Article> filtereddata=new ArrayList<>();
            if(keyword.toString().isEmpty())
                filtereddata.addAll(backup);
            else {
                for (Article obj: backup){
                    if (obj.getTitle().toString().toLowerCase().contains(keyword.toString().toLowerCase())){
                        filtereddata.add(obj);
                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filtereddata;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            userList.clear();
            userList.addAll((ArrayList<Article>)results.values);
            notifyDataSetChanged();

        }
    };
}
