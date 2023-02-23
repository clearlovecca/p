package com.example.myapplication.utlis;

import com.example.myapplication.moudel.GoodsTypeEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    @GET("goods/category")
    Observable<GoodsTypeEntity> getGoods();
}
