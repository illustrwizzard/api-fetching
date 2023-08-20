package com.example.retrfitex.MVVMFetch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.retrfitex.R;

import java.util.List;

public class MVVMActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ApiViewModel apiViewModel;
    private MVVMAdapter mvvmAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvmactivity);
        recyclerView=findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mvvmAdapter=new MVVMAdapter();
        recyclerView.setAdapter(mvvmAdapter);

        apiViewModel=new ViewModelProvider(this).get(ApiViewModel.class);
        apiViewModel.getApiEntries().observe(this, new Observer<List<ApiEntry>>() {
            @Override
            public void onChanged(List<ApiEntry> apiEntries) {
                mvvmAdapter.setApiEntries(apiEntries);
            }
        });

    }
}