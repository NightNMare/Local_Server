package com.example.dlarb.local_server;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button get;
    Button post;
    EditText inp;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get = findViewById(R.id.get);
        post = findViewById(R.id.post);
        txt = findViewById(R.id.txt);
        inp = findViewById(R.id.inp);
        txt.setText(new Data_Helper(getApplicationContext()).getText());


        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Network_Helper.getInstance().GETData(inp.getText().toString()).enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        txt.setText(response.body().getData());
                        new Data_Helper(getApplicationContext()).saveText(inp.getText().toString());
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        Log.e("fail",t.getMessage());
                    }
                });
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Network_Helper.getInstance().POSTData(inp.getText().toString()).enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        txt.setText(response.body().getData());
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        Log.e("fail",t.getMessage());
                    }
                });
            }
        });

    }
}
