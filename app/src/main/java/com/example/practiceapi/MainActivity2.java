package com.example.practiceapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    List<Example> datalist;
    ImageView flags1;
    TextView country_name,realname,team,firstappearance,createdby,publisher,bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        flags1 = findViewById(R.id.flags);
        country_name = findViewById(R.id.country_name);
        realname = findViewById(R.id.realname);
        team = findViewById(R.id.team);
        firstappearance = findViewById(R.id.firstappearance);
        createdby = findViewById(R.id.createdby);
        publisher = findViewById(R.id.publisher);
        bio = findViewById(R.id.bio);

        datalist = ApiAdapter.datalist;

        int position = getIntent().getIntExtra("flags",0);

//        ApiInterface apiinterface = ApiClient.getApiClient().create(ApiInterface.class);
//        apiinterface.getApiInterface().enqueue(new Callback<List<Example>>() {
//            @Override
//            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
//
//                if (response.isSuccessful())
//                {

                    Glide.with(MainActivity2.this).load(datalist.get(position).getImageurl()).into(flags1);
                    country_name.setText(datalist.get(position).getName());
                    realname.setText(datalist.get(position).getRealname());
                    team.setText(datalist.get(position).getTeam());
                    firstappearance.setText(datalist.get(position).getFirstappearance());
                    createdby.setText(datalist.get(position).getCreatedby());
                    publisher.setText(datalist.get(position).getPublisher());
                    bio.setText(datalist.get(position).getBio());

//        Toast.makeText(this, ""+datalist.get(position).getName(), Toast.LENGTH_SHORT).show();
//                    holder.realname.setText(datalist.get(position).getRealname());
//                    holder.team.setText(datalist.get(position).getTeam());
//                    holder.firstappearance.setText(datalist.get(position).getFirstappearance());
//                    holder.createdby.setText(datalist.get(position).getCreatedby());
//                    holder.publisher.setText(datalist.get(position).getPublisher());
//                    holder.bio.setText(datalist.get(position).getBio());
//                }
//            }

//            @Override
//            public void onFailure(Call<List<Example>> call, Throwable t) {
//
//            }
//        });

    }
}