package com.example.retrfitex.FetchData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.retrfitex.FetchData.ViewModell.ViewModelNew;
import com.example.retrfitex.R;

import java.util.ArrayList;
import java.util.List;

public class FetchDataEx extends AppCompatActivity {
    RecyclerView recyclerView;
    ViewModelNew viewModelNew;
    List<DataModelFetch> fetchList;
    FetchAdapter fetchAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data_ex);
        recyclerView=findViewById(R.id.recycler_new);
        fetchList=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       // viewModelNew=new ViewModelNew();

        viewModelNew= ViewModelProviders.of(this).get(ViewModelNew.class);
        viewModelNew.getObservernew().observe(this, new Observer<List<DataModelFetch>>() {
            @Override
            public void onChanged(List<DataModelFetch> dataModelFetches) {
                if (dataModelFetches==null){
                    fetchList=dataModelFetches;
                    fetchAdapter.updatelist(dataModelFetches);
                }
            }
        });
        viewModelNew.makenewApiCall();

        fetchAdapter=new FetchAdapter(fetchList);
        recyclerView.setAdapter(fetchAdapter);



    }
}