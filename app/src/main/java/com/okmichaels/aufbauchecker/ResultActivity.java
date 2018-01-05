package com.okmichaels.aufbauchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.okmichaels.aufbauchecker.http.ApiService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ResultActivity extends AppCompatActivity {

    TextView stringView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        stringView = findViewById(R.id.result_dump);

        getJsonData();
    }

    private void getJsonData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://forum.manjaro.org")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Observable<List<String>> observable = apiService.getJsonData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<List<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<String> strings) {
                for (String txt: strings) {
                    Log.d("ResultActivity.onNext", txt);
                }
                stringView.setText(strings.get(0));
            }
        });

    }
}
