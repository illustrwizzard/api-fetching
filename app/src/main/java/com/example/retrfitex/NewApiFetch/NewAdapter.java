package com.example.retrfitex.NewApiFetch;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrfitex.R;

import java.util.ArrayList;
import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.myviewHoldwer> {
    private List<NewProductsList> newProductsLists;


    public void setDataEntries(List<NewProductsList> newProductsLists) {
        this.newProductsLists=newProductsLists;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public NewAdapter.myviewHoldwer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.new_single,parent,false);
        newProductsLists= new ArrayList<>();
        return new myviewHoldwer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewAdapter.myviewHoldwer holder, int position) {
       // NewProductsList newProductsList=newProductsLists.get(position);
        //holder.bind(newProductsList);

       holder.title.setText(newProductsLists.get(position).getTitle());
        holder.quantity.setText(newProductsLists.get(position).getQuantity());
        holder.price.setText("&#8377; "+newProductsLists.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
       // Log.w("kkkk", String.valueOf(newProductsLists.size()));
        return newProductsLists !=null ? newProductsLists.size():0;

    }


    public class myviewHoldwer extends RecyclerView.ViewHolder {
        TextView title,quantity,price;
        public myviewHoldwer(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.n1);
            quantity=itemView.findViewById(R.id.n2);
            price=itemView.findViewById(R.id.p3);
        }

        @SuppressLint("SetTextI18n")
        public void bind(NewProductsList newProductsList) {
            title.setText(newProductsList.getTitle());
            quantity.setText(newProductsList.getQuantity());
            price.setText("&#8377; "+newProductsList.getPrice());
        }
    }
}
