package com.example.myapplication.Respority;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.moudel.BaseMoudle;
import com.example.myapplication.moudel.GoodsTypeEntity;

import io.reactivex.Observable;

public class BaseRespority extends BaseMoudle {

    public MutableLiveData<GoodsTypeEntity> getData() {
        MutableLiveData<GoodsTypeEntity> data = new MutableLiveData<>();
        return getData(data,getApi().getGoods());
    }
}
