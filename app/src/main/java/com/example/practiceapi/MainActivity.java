package com.example.practiceapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ShimmerLayout layot;
    RecyclerView recycleView;
    List<Example> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         layot = findViewById(R.id.shimmerlayoutt);
        recycleView = findViewById(R.id.recycleView);

        ApiInterface apiinterface = ApiClient.getApiClient().create(ApiInterface.class);
        layot.startShimmerAnimation();

   apiinterface.getApiInterface().enqueue(new Callback<List<Example>>() {
         @Override
         public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
     if (response.isSuccessful())
  {

        datalist=response.body();
        ApiAdapter adapter=new ApiAdapter(MainActivity.this,datalist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recycleView.setLayoutManager(linearLayoutManager);
        recycleView.setAdapter(adapter);

//    layot.stopShimmerAnimation();
//    layot.setVisibility(View.GONE);
    }
    }

    @Override
    public void onFailure(Call<List<Example>> call, Throwable t) {

    }
    });
    }
    @Override
    public void onResume() {
        super.onResume();
//        layot.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
//        layot.stopShimmerAnimation();
        super.onPause();
    }
}