package com.example.retrfitex.insert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrfitex.R;
import com.example.retrfitex.newproject.apiController;
import com.example.retrfitex.newproject.responsemodel;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class InsertIntoMysql extends AppCompatActivity {
    EditText ename,eusername,epassword;
    TextView textshow1;
    Button btn;
    String Url="http://192.168.18.75/api/";
  //  Retrofit retrofit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_into_mysql);

        ename=findViewById(R.id.nameid);
        eusername=findViewById(R.id.usernameid);
        epassword=findViewById(R.id.passwordid);
        textshow1=findViewById(R.id.textid);
        btn=findViewById(R.id.buttonid);

        btn.setOnClickListener(v -> process(ename.getText().toString(),eusername.getText().toString(),epassword.getText().toString()));
    }

    private void process(String name,String username, String password) {

      Call<responsemodel> call= apiController.getInstance().getapi().adddata(name,username,password);
      call.enqueue(new Callback<responsemodel>() {
          @Override
          public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
              responsemodel obj=response.body();
              ename.setText("");
              eusername.setText("");
              epassword.setText("");
              Toast.makeText(getApplicationContext(), obj.getMessage(), Toast.LENGTH_LONG).show();

          }

          @Override
          public void onFailure(Call<responsemodel> call, Throwable t) {

          }
      });



//            JSONObject paramObject = new JSONObject();
//            paramObject.put("name", ename.getText().toString());
//            paramObject.put("username", eusername.getText().toString());
//            paramObject.put("password", epassword.getText().toString());
//            Call<insertmodel> call=insertapii.adddata(paramObject.toString());




    }
}
