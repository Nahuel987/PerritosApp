package com.example.perritoapp.api;

import com.example.perritoapp.model.BreedImageListResponse;
import com.example.perritoapp.model.BreedListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiDog {

    @GET("api/breeds/list/")
    Call<BreedListResponse> getBreedList();

    @GET("api/breed/{breed}/images/")
    Call<BreedImageListResponse> getBeedImageList(@Path("breed") String breed);


}
