package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class BaseAdpaterBing extends BaseQuickAdapter<HomeBean.ResultBean, BaseViewHolder> {

    public BaseAdpaterBing(int layoutResId, @Nullable List<HomeBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.ResultBean item) {
        ImageView image = helper.getView(R.id.image);
        Glide.with(mContext).load(item.getThumbnail()).into(image);
          helper.setText(R.id.text,item.getSummary());
    }
}
