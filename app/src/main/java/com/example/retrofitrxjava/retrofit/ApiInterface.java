package com.example.retrofitrxjava.retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("employees")
    Observable<ResponseData> getUserDetails();
}
