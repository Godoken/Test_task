package com.example.test_task;

import java.util.List;

import okhttp3.Credentials;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WatsonAPI {

    /*@POST("v3/identify?version=2018-05-01")    "{credentials}/v3/identify?version=2018-05-01"
    Call<List<Language>> identify(//@Header("Authorization") String credentials,
                                @Body String text);*/
    /*@POST("{credentials}/v3/identify?version=2018-05-01")
    Call<List<IdentifieldLanguage>> identify(@Header("Authorization: Basic") String credentials,
                                             @Header("Content-Type: text/plain") String string, @Body String text
                                  );*/

    @POST("/v3/identify?version=2018-05-01")
    Call<List<IdentifieldLanguage>> identify(@Body String text, @Header("Content-Type") String string,
                                             @Header("Authorization") String encoding
    );

}
