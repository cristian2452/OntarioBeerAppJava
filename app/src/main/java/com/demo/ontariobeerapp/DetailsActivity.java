package com.demo.ontariobeerapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.d(null,"on create started");

        getIncomingIntent();
    }

    private void getIncomingIntent() {

        String imageUrl = getIntent().getStringExtra("imageUrl");
        String name = getIntent().getStringExtra("name");
        String type = getIntent().getStringExtra("type");
        String category = getIntent().getStringExtra("category");
        String country = getIntent().getStringExtra("country");
        String abv = getIntent().getStringExtra("abv");
        String brewer = getIntent().getStringExtra("brewer");

        setInfo(name,imageUrl,type,category,country,abv,brewer);
    }

    private void setInfo(String name, String imageUrl,String type, String category, String country,
                         String abv, String brewer){

        TextView widgetName = findViewById(R.id.detail_name);
        widgetName.setText("Name: "+name);

        TextView widgetType = findViewById(R.id.detail_type);
        widgetType.setText("Type: "+type);

        TextView widgetCategory = findViewById(R.id.detail_category);
        widgetCategory.setText("Category: "+category);

        TextView widgetCoutry = findViewById(R.id.detail_country);
        widgetCoutry.setText("Country: "+country);

        TextView widgetAbv = findViewById(R.id.detail_abv);
        widgetAbv.setText("Abv: "+abv);

        TextView widgetBrewer = findViewById(R.id.detail_brewer);
        widgetBrewer.setText("Brewer: "+brewer);

        ImageView widgetImage = findViewById(R.id.detail_beerPicture);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(widgetImage);
    }
}
