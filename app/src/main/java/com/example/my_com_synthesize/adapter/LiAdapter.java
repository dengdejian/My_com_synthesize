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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.my_com_synthesize.R;
import com.example.my_com_synthesize.bean.PersonBanner;

import java.util.ArrayList;
import java.util.List;

public class LiAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private List<PersonBanner.DataBean.CategoryListBean> list;
    private GridLayoutHelper gridLayoutHelper;

    public LiAdapter(Context context, List<PersonBanner.DataBean.CategoryListBean> list, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.list = list;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bujuh, parent, false);
        return new VieqHoders(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VieqHoders vieqHoders = (VieqHoders) holder;
        PersonBanner.DataBean.CategoryListBean categoryListBean = list.get(position);
        List<PersonBanner.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBean.getGoodsList();
        for (PersonBanner.DataBean.CategoryListBean.GoodsListBean personBanner : goodsList) {
            String list_pic_url = personBanner.getList_pic_url();
            Glide.with(context).load(list_pic_url).into(vieqHoders.img_url);
            vieqHoders.names.setText(personBanner.getName());
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    private class VieqHoders extends RecyclerView.ViewHolder {

        private final ImageView img_url;
        private final TextView names;

        public VieqHoders(View inflate) {
            super(inflate);
            img_url = inflate.findViewById(R.id.img_url);
            names = inflate.findViewById(R.id.tex_names);
        }
    }
}
