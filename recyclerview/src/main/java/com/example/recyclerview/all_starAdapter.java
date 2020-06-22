package com.example.recyclerview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class all_starAdapter extends RecyclerView.Adapter<all_starAdapter.ViewHolder>{

    private List<all_star>mall_starList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView all_starImage;
        TextView all_starName;

        public ViewHolder(View view){
            super(view);
            all_starImage = (ImageView) view.findViewById(R.id.all_star_image);
            all_starName = (TextView) view.findViewById(R.id.all_star_name);

        }
    }

    public  all_starAdapter (List <all_star> all_starList){
        mall_starList = all_starList;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_star_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        all_star all_star = mall_starList.get(position);
        holder.all_starImage.setImageResource(all_star.getImg());
        holder.all_starName.setText(all_star.getName());
    }

    @Override
    public int getItemCount(){
        return mall_starList.size();
    }
}

