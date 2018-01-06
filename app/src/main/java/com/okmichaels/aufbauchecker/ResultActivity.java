package com.okmichaels.aufbauchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.okmichaels.aufbauchecker.adapters.ResultAdapter;
import com.okmichaels.aufbauchecker.model.Grade;
import com.okmichaels.aufbauchecker.model.Response;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ResultActivity extends AppCompatActivity {
    private RecyclerView resultRecyclerView;
    private ResultAdapter resultAdapter;
    private ArrayList<Grade> grades;

    private static String BASE_URL = "http://allamihomes.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultRecyclerView = findViewById(R.id.recycler_view_result);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        resultRecyclerView.setLayoutManager(lm);

        loadData();
    }

    private void loadData() {
        //create a new gson instance so as to use our deserializer
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Grade.class, new GradeDeserializer())
                .setLenient()
                .create();
        RestInterface rqInterface = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RestInterface.class);

        rqInterface.fetchResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError);
    }

    private void handleResponse(List<Response> responses) {
        Toast.makeText(this, "gotten response", Toast.LENGTH_SHORT).show();
    }

    private void handleError(Throwable error) {
        Log.d("ResultActivity", error.getLocalizedMessage());
        Toast.makeText(this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
