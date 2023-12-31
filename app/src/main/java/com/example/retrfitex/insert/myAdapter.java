package com.example.retrfitex.insert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrfitex.R;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>{
    List<fetchdatamodel> res_data;

    public myAdapter(List<fetchdatamodel> res_data) {
        this.res_data = res_data;
    }
    public void updatelist(List<fetchdatamodel> res_data) {
        this.res_data=res_data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlelayout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.nameshow.setText(res_data.get(position).getTitle());
//        holder.usernameshow.setText(res_data.get(position).getUsername());
//        holder.passwordshow.setText(res_data.get(position).getPassword());
        Glide.with(holder.nameshow.getContext()).load("http://192.168.18.75/api/imgg/"+res_data.get(position).getImage()).into(holder.img);

    }

    @Override
    public int getItemCount() {

        if(this.res_data!=null)
            return this.res_data.size();
        else
            return 0;

    }



    static class myViewHolder extends RecyclerView.ViewHolder{
        TextView nameshow,usernameshow,passwordshow;
        ImageView img;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            nameshow=itemView.findViewById(R.id.nameshow);
//            usernameshow=itemView.findViewById(R.id.usernameshow);
//            passwordshow=itemView.findViewById(R.id.passwordshow);
            img=itemView.findViewById(R.id.id_img);
        }
    }

}
