package com.demo.ontariobeerapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("beers")
    Call<List<Beer>> fetchBeers();
}
