package com.example.retrfitex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    String url="https://jsonplaceholder.typicode.com/";
    Retrofit retrofit;
    myapi myapi1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myapi1=retrofit.create(myapi.class);

        Call<List<model>> call=myapi1.getmodel();
        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> data=response.body();
                for(int i = 0; i< Objects.requireNonNull(data).size(); i++){
                    tv.append(" ID : "+data.get(i).getId()+"\n TITLE : "+data.get(i).getTitle()+"\n BODY : "+data.get(i).getBody()+"\n \n \n");


                }
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {

            }
        });
    }
}