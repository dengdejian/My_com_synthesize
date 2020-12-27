package com.example.my_com_synthesize.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.my_com_synthesize.R;
import com.example.my_com_synthesize.bean.PersonBanner;

import java.util.List;

public class LoveAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private List<PersonBanner.DataBean.CategoryListBean> list;
    private StickyLayoutHelper stickyLayoutHelper;

    public LoveAdapter(Context context, List<PersonBanner.DataBean.CategoryListBean> list, StickyLayoutHelper stickyLayoutHelper) {
        this.context = context;
        this.list = list;
        this.stickyLayoutHelper = stickyLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return stickyLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bujuk, parent, false);
        return new ViewHolder1s(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PersonBanner.DataBean.CategoryListBean categoryListBean = list.get(position);

        List<PersonBanner.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBean.getGoodsList();
        for (PersonBanner.DataBean.CategoryListBean.GoodsListBean personBanner : goodsList) {
            PersonBanner.DataBean.CategoryListBean.GoodsListBean goodsListBean = goodsList.get(position);
            String name1 = goodsListBean.getName();
            String list_pic_url1 = goodsListBean.getList_pic_url();

            ViewHolder1s viewHolder1s = (ViewHolder1s) holder;
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(context).load(list_pic_url1).apply(requestOptions).into(viewHolder1s.guo);
            viewHolder1s.name.setText(name1);

        }


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private class ViewHolder1s extends RecyclerView.ViewHolder {

        private final TextView name;
        private final ImageView guo;

        public ViewHolder1s(View inflate) {
            super(inflate);
            guo = inflate.findViewById(R.id.guo);
            name = inflate.findViewById(R.id.tex_na);
        }
    }
}
