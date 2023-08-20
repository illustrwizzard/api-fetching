package com.example.retrfitex.MVVMFetch;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrfitex.FetchData.FetchAdapter;
import com.example.retrfitex.R;

import java.util.List;

public class MVVMAdapter extends RecyclerView.Adapter<MVVMAdapter.myviewHolder> {

    private List<ApiEntry> apiEntries;

    public void setApiEntries(List<ApiEntry> apiEntries) {
        this.apiEntries=apiEntries;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MVVMAdapter.myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_single_layout,parent,false);
        //fetchList=new ArrayList<>();

        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MVVMAdapter.myviewHolder holder, int position) {

            ApiEntry apiEntry=apiEntries.get(position);
            holder.bind(apiEntry);
//        holder.t2.setText(fetchList.get(position).getDescription());
//        holder.b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse(fetchList.get(position).getLink()));
//                holder.t1.getContext().startActivity(i);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return apiEntries != null ? apiEntries.size() : 0;
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

        public void bind(ApiEntry apiEntry) {
            t1.setText(apiEntry.getApi());
            t2.setText(apiEntry.getDescription());
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse(apiEntry.getLink()));
                   t1.getContext().startActivity(i);
                }
            });
        }
    }
}
