package com.example.retrfitex.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.retrfitex.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewProjectMainActivity extends AppCompatActivity {
    EditText ename,eusername,epassword;
    TextView textshow1;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project_main);

        ename=findViewById(R.id.nameid1);
        eusername=findViewById(R.id.usernameid1);
        epassword=findViewById(R.id.passwordid1);
        textshow1=findViewById(R.id.textid1);
        btn=findViewById(R.id.buttonid1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processdata(ename.getText().toString(),eusername.getText().toString(),epassword.getText().toString());
            }
        });
    }

    private void processdata(String name, String email, String password) {
        Call<responsemodel> call=apiController.getInstance()
                .getapi()
                .getregister(name, email, password);
        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
                responsemodel obj=response.body();
                textshow1.setText(obj.getMessage());
                ename.setText("");
                eusername.setText("");
                epassword.setText("");
            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {
                textshow1.setText(t.toString());
                ename.setText("");
                eusername.setText("");
                epassword.setText("");
            }
        });
    }
}