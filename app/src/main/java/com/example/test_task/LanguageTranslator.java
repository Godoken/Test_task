package com.example.test_task;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LanguageTranslator implements Callback<List<Language>> {

    //curl -u "{6987a48d-342e-4a69-8adc-e65b1cc0b9da}:{password}" "{https://gateway.watsonplatform.net/language-translator/api}/{method}"

    List<Language> languageList = null;

    static final String BASE_URL = "https://gateway.watsonplatform.net/language-translator/api/";

    String credentials = Credentials.basic("6987a48d-342e-4a69-8adc-e65b1cc0b9da", "MxYSIi6nQP2Y");

    public List<Language> start(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        WatsonAPI watsonAPI = retrofit.create(WatsonAPI.class);

        Call<List<Language>> call = watsonAPI.identify(credentials,
                "Language translator translates text from one language to another");
        call.enqueue(this);

        return languageList;
    }

    @Override
    public void onResponse(retrofit2.Call<List<Language>> call, retrofit2.Response<List<Language>> response) {

        int k = 0;
        String s = "";

        if(response.isSuccessful()) {
            languageList = response.body();
        } else {
            k = response.code();
            s = response.message();
        }

    }

    @Override
    public void onFailure(retrofit2.Call<List<Language>> call, Throwable t) {

        t.printStackTrace();

    }

    public List<Language> getLanguageList(){

        return languageList;
    }
}
