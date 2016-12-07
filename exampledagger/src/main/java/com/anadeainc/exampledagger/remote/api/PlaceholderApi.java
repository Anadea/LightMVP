package com.anadeainc.exampledagger.remote.api;

import com.anadeainc.exampledagger.remote.models.Post;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface PlaceholderApi {

    @Headers({"Content-type: application/json"})
    @GET("/posts")
    Single<List<Post>> getPosts();
}
