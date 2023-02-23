package com.example.myapplication.adapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.databinding.GoodsItemBinding;
import com.example.myapplication.moudel.GoodsTypeEntity;

import java.util.List;

public class TypeAdapter extends BaseQuickAdapter<GoodsTypeEntity.DataBeanX, BaseViewHolder> {

    public TypeAdapter(List<GoodsTypeEntity.DataBeanX> data) {
        super(R.layout.goods_item, data);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        DataBindingUtil.bind(holder.itemView);
        super.onBindViewHolder(holder, position);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, GoodsTypeEntity.DataBeanX dataBeanX) {
        GoodsItemBinding binding = DataBindingUtil.getBinding(baseViewHolder.itemView);
        assert binding != null;
        binding.setGoods(dataBeanX);

    }
}
