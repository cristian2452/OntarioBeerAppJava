package com.demo.ontariobeerapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.ViewHolder> {
    private List<Beer> dataset;
    private Context context;

    public BeerAdapter(List<Beer> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_beer, viewGroup, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Beer beer = dataset.get(position);
        viewHolder.name.setText(beer.getName());
        viewHolder.type.setText(beer.getType());
        viewHolder.category.setText(beer.getCategory());
        viewHolder.country.setText(beer.getCountry());

        Glide.with(context)
             .load(beer.getImageUrl())
             .into(viewHolder.picture);
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.category)
        TextView category;
        @BindView(R.id.country)
        TextView country;
        @BindView(R.id.beerPicture)
        ImageView picture;
        
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
