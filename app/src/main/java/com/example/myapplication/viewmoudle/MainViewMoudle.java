package com.example.myapplication.viewmoudle;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.myapplication.Respority.BaseRespority;
import com.example.myapplication.adapter.SecondTypeAdapter;
import com.example.myapplication.adapter.TypeAdapter;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.moudel.GoodsTypeEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class MainViewMoudle extends ViewModel {
    TypeAdapter typeAdapter;
    List<GoodsTypeEntity.DataBeanX> list = new ArrayList<>();
    List<GoodsTypeEntity.DataBeanX.DataBean> type=new ArrayList<>();
    BaseRespority baseRespority = new BaseRespority();

    SecondTypeAdapter secondTypeAdapter;
    public void loadData(ActivityMainBinding binding, LifecycleOwner owner, Context context){
        typeAdapter = new TypeAdapter(list);
        binding.goods.setAdapter(typeAdapter);
        binding.goods.setLayoutManager(new LinearLayoutManager(context));
        baseRespority.getData().observe(owner, new Observer<GoodsTypeEntity>() {
            @Override
            public void onChanged(GoodsTypeEntity goodsTypeEntity) {
                list.addAll(goodsTypeEntity.getData());
                typeAdapter.notifyDataSetChanged();
                refreshlist(0);
            }
        });
        secondTypeAdapter = new SecondTypeAdapter(type);
        binding.goodsType.setAdapter(secondTypeAdapter);
        binding.goodsType.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));

        typeAdapter.setOnItemClickListener((adapter, view, position) -> refreshlist(position));
    }
    public void refreshlist(int position){
       type.clear();
       type.addAll(list.get(position).getData());
       secondTypeAdapter.notifyDataSetChanged();
    }

}
