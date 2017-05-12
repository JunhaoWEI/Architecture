package com.example.rxjavaretrofit;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by WEI JUNHAO on 2017/5/12.
 */

public interface MyService {
    @GET("weather_mini")
    Observable<BaseEntity<Weather>> weather_mini(@Query("city") String city);

}
