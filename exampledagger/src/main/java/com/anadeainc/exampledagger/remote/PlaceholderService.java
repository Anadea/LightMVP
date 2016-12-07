package com.anadeainc.exampledagger.remote;

import com.anadeainc.exampledagger.remote.api.PlaceholderApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class PlaceholderService implements RemoteService<PlaceholderApi> {

    private static final String URL_ENDPOINT = "http://jsonplaceholder.typicode.com";

    private final PlaceholderApi api;

    @Inject
    PlaceholderService() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

        api = retrofit.create(PlaceholderApi.class);
    }

    @Override
    public PlaceholderApi getApi() {
        return api;
    }

}
