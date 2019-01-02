package com.navbar.avario.appetisermobilechallenge.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: orly
 * @date: 12/27/2018
 * @department: Android
 */
public class APIClient {

  public static Retrofit retrofit;

  public void APIClient() {

  }

  public static Retrofit getRetrofit() {

    if (retrofit == null) {
      OkHttpClient.Builder builder = new OkHttpClient.Builder();
      OkHttpClient okHttpClient = builder.build();

      retrofit = new Retrofit.Builder()
          .baseUrl("http://itunes.apple.com/")
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(okHttpClient)
          .build();

    }

    return retrofit;
  }

}
