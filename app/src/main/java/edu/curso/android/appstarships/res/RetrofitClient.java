package edu.curso.android.appstarships.res;

import android.util.Log;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String URL_BASE = "https://swapi.co/api/";

    public static Retrofit recuperarRetrofit()
    {
        if(retrofit==null)
        {
            retrofit = new retrofit2.Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
