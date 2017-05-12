package com.example.weijunhao.architecture;



import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by WEI JUNHAO on 2017/5/12.
 */

public interface RetrofitService {

    @GET("weather_min")
    Observable<BaseEntity<Weather>> weather_min(@Query("city") String city);
}
