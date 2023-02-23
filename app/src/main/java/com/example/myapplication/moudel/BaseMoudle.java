package com.example.myapplication.moudel;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.utlis.Api;
import com.example.myapplication.utlis.RetrofitManager;

public class BaseMoudle {
    public Api getApi(){
        return RetrofitManager.getRetrofitManager().doNetWork().create(Api.class);
    }
    public <T>MutableLiveData<T> getData(MutableLiveData<T> mutableLiveData, Observable observable){
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        mutableLiveData.postValue((T) o);
                    }
                });
        return mutableLiveData;
    }

}
