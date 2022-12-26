package com.example.practiceapi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.viewDta> {

    Activity activity;
    public static  List<Example> datalist;

    public ApiAdapter(Activity activity, List<Example> datalist) {

        this.activity = activity;
        this.datalist = datalist;

    }

    @NonNull
    @Override
    public viewDta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_1,parent,false);
        return new viewDta(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewDta holder, @SuppressLint("RecyclerView") int position) {

          String  abc = String.valueOf(Glide.with(activity).load(datalist.get(position).getImageurl()).into(holder.flags));
                  Log.d("1223", "onBindViewHolder: ----------------------------------->"+abc);
          holder.country_name.setText(datalist.get(position).getName());
//              holder.layot.startShimmerAnimation();
          holder.flags.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(activity,MainActivity2.class);
                  intent.putExtra("flags",position);
                  activity.startActivity(intent);
              }
          });

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class viewDta extends RecyclerView.ViewHolder {

        ImageView flags;
        TextView country_name;
        ShimmerLayout layot;

        public viewDta(@NonNull View itemView) {
            super(itemView);

            flags = itemView.findViewById(R.id.flags);
            country_name = itemView.findViewById(R.id.country_name);
            layot = itemView.findViewById(R.id.shimmerlayoutt);

        }
    }


}
