package com.example.practiceapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

public static final  String baseUrl="https://simplifiedcoding.net/demos/";
    public static Retrofit retrofit;

public static Retrofit getApiClient()
{
    retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
return retrofit;
}

}
