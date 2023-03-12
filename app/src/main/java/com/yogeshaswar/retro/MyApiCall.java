package com.yogeshaswar.retro;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {
    //https://catfact.ninja/       fact

    @GET("fact")
    Call<DataModel> getData();

}
