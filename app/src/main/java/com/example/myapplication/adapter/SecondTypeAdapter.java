package com.example.myapplication.adapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.databinding.GoodsSeconditemBinding;
import com.example.myapplication.moudel.GoodsTypeEntity;

import java.util.List;

public class SecondTypeAdapter extends BaseQuickAdapter<GoodsTypeEntity.DataBeanX.DataBean, BaseViewHolder> {
    public SecondTypeAdapter(List<GoodsTypeEntity.DataBeanX.DataBean> data) {
        super(R.layout.goods_seconditem, data);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        DataBindingUtil.bind(holder.itemView);
        super.onBindViewHolder(holder, position);
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, GoodsTypeEntity.DataBeanX.DataBean dataBean) {
        GoodsSeconditemBinding  binding = DataBindingUtil.getBinding(baseViewHolder.itemView);
        binding.setSecondtype(dataBean);
    }
}
