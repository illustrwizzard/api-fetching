package com.example.retrfitex.insert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrfitex.R;
import com.example.retrfitex.insert.viewmodel.myviewmodel;
import com.example.retrfitex.newproject.apiController;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchdataRecycler extends AppCompatActivity {
    RecyclerView recyclerView;
    List<fetchdatamodel> fetchdatamodelList;
    myviewmodel myviewmodel;
    myAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata_recycler);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //getdatatolayout();

        myAdapter=new myAdapter(fetchdatamodelList);
        recyclerView.setAdapter(myAdapter);
        myviewmodel= ViewModelProviders.of(this).get(myviewmodel.class);
        myviewmodel.getDataObserver().observe(this, new Observer<List<fetchdatamodel>>() {
            @Override
            public void onChanged(List<fetchdatamodel> fetchdatamodels) {
                if (fetchdatamodels!=null){
                    fetchdatamodelList=fetchdatamodels;
                    myAdapter.updatelist(fetchdatamodels);
                }

            }
        });
        myviewmodel.makeApiCall();



    }

    private void getdatatolayout() {
        Call<List<fetchdatamodel>> call= apiController.getInstance().getapi().getdata();
        call.enqueue(new Callback<List<fetchdatamodel>>() {
            @Override
            public void onResponse(Call<List<fetchdatamodel>> call, Response<List<fetchdatamodel>> response) {
                List<fetchdatamodel> res_data=response.body();
                myAdapter=new myAdapter(res_data);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<fetchdatamodel>> call, Throwable t) {

            }
        });
    }
}