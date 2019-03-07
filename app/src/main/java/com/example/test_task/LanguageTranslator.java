package com.example.test_task;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LanguageTranslator {

    //curl -u "{6987a48d-342e-4a69-8adc-e65b1cc0b9da}:{password}" "{https://gateway.watsonplatform.net/language-translator/api}/{method}"

    List<IdentifieldLanguage> languageList = null;
    private IdentifyCallback identifyCallback;

    static final String BASE_URL = "https://gateway.watsonplatform.net/language-translator/api/";

    //String credentials = Credentials.basic("6987a48d-342e-4a69-8adc-e65b1cc0b9da", "MxYSIi6nQP2Y");
    String encoding = Base64.getEncoder().encodeToString(("6987a48d-342e-4a69-8adc-e65b1cc0b9da:MxYSIi6nQP2Y").getBytes());

    public void start(final IdentifyCallback identifyCallback){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //OkHttpClient client = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                //.client(client)
                .build();

        WatsonAPI watsonAPI = retrofit.create(WatsonAPI.class);

        Call<List<IdentifieldLanguage>> call = watsonAPI.identify("Language translator translates text from one language to another", "text/plain",
                "Basic " + encoding);

        call.enqueue(new Callback<List<IdentifieldLanguage>>() {
            @Override
            public void onResponse(Call<List<IdentifieldLanguage>> call, Response<List<IdentifieldLanguage>> response) {
                if(response.isSuccessful()) {
                    List<IdentifieldLanguage> languageList = response.body();
                    identifyCallback.onSuccess(languageList);
                } else {
                    identifyCallback.onFailure(new RuntimeException());
                }
            }

            @Override
            public void onFailure(Call<List<IdentifieldLanguage>> call, Throwable t) {
                identifyCallback.onFailure(t);
                t.printStackTrace();
            }
        });

        //return languageList;
    }

    public List<IdentifieldLanguage> getLanguageList(){

        return languageList;
    }

    public interface IdentifyCallback{
        void onSuccess(List<IdentifieldLanguage> languagesList);
        void onFailure(Throwable throwable);
    }
}
