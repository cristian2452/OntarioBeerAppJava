package com.demo.ontariobeerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String TAG = "ONTARIOBEERAPI_DEMO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ontariobeerapi.ca/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        Call<List<Beer>> apiResponse = service.fetchBeers();
        apiResponse.enqueue(new Callback<List<Beer>>() {
            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                final List<Beer> beers = response.body();
                assert beers != null;
                final BeerAdapter adapter = new BeerAdapter(beers);
                final RecyclerView recyclerView = findViewById(R.id.recycler_view);
                final LinearLayoutManager linearLayout = new LinearLayoutManager(getBaseContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(linearLayout);
            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {

            }
        });
    }
}
