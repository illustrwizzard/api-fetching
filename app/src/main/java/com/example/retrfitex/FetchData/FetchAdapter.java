package com.example.retrfitex.FetchData;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrfitex.R;

import java.util.ArrayList;
import java.util.List;

public class FetchAdapter extends RecyclerView.Adapter<FetchAdapter.myviewHolder> {
    List<DataModelFetch> fetchList;
    public FetchAdapter(List<DataModelFetch> fetchList) {
        this.fetchList=fetchList;
    }

    @NonNull
    @Override
    public FetchAdapter.myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_single_layout,parent,false);
        //fetchList=new ArrayList<>();

        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FetchAdapter.myviewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(fetchList.get(position).getAPI());
        holder.t2.setText(fetchList.get(position).getDescription());
        holder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse(fetchList.get(position).getLink()));
                holder.t1.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (fetchList.size()==0){
            return 0;
        }
        return fetchList.size();
    }

    public void updatelist(List<DataModelFetch> fetchList) {
        this.fetchList=fetchList;
        notifyDataSetChanged();

    }

    public class myviewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        Button b1;
        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.id1);
            t2=itemView.findViewById(R.id.id2);
            b1=itemView.findViewById(R.id.b1);
        }
    }
}
