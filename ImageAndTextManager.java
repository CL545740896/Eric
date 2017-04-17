package com.example.eric.multiitemtest;

import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.adapter.holder.BaseViewHolderManager;

/**
 * ViewHoldManager类
 * 实现数据添加
 */

public class ImageAndTextManager extends BaseViewHolderManager<ImageTextBean> {


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, @NonNull ImageTextBean data) {
        TextView textView = getView(holder, R.id.tv_uerName);
        textView.setText(data.getText());
        TextView content = getView(holder, R.id.tv_content);
        content.setText(data.getContent());
        ImageView imageView = getView(holder, R.id.iv_user);
        imageView.setImageResource(data.getImg());
    }

    @Override
    protected int getItemLayoutId()
    {
        return R.layout.uer_layout_item;
    }

}