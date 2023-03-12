package com.yogeshaswar.retro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView text, text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //step -> Model Class -> DataModel
            text = (TextView) findViewById(R.id.textResponse);
//            text2 = (TextView) findViewById(R.id.textResponse2);

            //Retrofit Builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://catfact.ninja")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Instance of interface - 1. Interface class 2. Call object
        MyApiCall myApiCall = retrofit.create(MyApiCall.class);
        Call<DataModel> call = myApiCall.getData();

        //call enqueue
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if(response.code() != 200) {
                    text.setText("Check Connection");
                    return;
                }
//                //response
//                String responseText = "";
//                responseText = "Fact " + response.body().getFact() +
//                        "\nWordCount " + response.body().getLength();

                text.setText(response.body().getFact());
//                text2.setText(response.body().getLength());
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });








    }
}