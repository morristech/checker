package com.okmichaels.aufbauchecker;


import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface RestInterface {
    @GET("/result.json")
    Observable<List<com.okmichaels.aufbauchecker.model.Response>> fetchResult();
}
