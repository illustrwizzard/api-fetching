package com.example.retrfitex.NewApiFetch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.retrfitex.R;

import java.util.List;

public class NewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private NewAdapter newAdapter;
    private NewViewModel newViewModel;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        recyclerView=findViewById(R.id.new_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newAdapter=new NewAdapter();
        recyclerView.setAdapter(newAdapter);

        newViewModel=new ViewModelProvider(this).get(NewViewModel.class);
        newViewModel.getNewProductList().observe(this, new Observer<List<NewProductsList>>() {
            @Override
            public void onChanged(List<NewProductsList> newProductsLists) {
                newAdapter.setDataEntries(newProductsLists);
            }
        });
    }
}