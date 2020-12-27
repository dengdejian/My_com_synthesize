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
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.my_com_synthesize.R;
import com.example.my_com_synthesize.bean.PersonBanner;

import java.util.List;

public class PlusAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private StaggeredGridLayoutHelper staggeredGridLayoutHelper;
    private List<PersonBanner.DataBean.BrandListBean> list;

    public PlusAdapter(Context context, StaggeredGridLayoutHelper staggeredGridLayoutHelper, List<PersonBanner.DataBean.BrandListBean> list) {
        this.context = context;
        this.staggeredGridLayoutHelper = staggeredGridLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return staggeredGridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bujuc, parent, false);
        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        PersonBanner.DataBean.BrandListBean brandListBean = list.get(position);
        Glide.with(context).load(brandListBean.getList_pic_url()).into(viewHolder1.img_cd);
        viewHolder1.brand.setText(brandListBean.getName());
        viewHolder1.price.setText(brandListBean.getFloor_price() + "元起");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView img_cd;
        private final TextView price;
        private final TextView brand;

        public ViewHolder1(View inflate) {
            super(inflate);
            img_cd = inflate.findViewById(R.id.img_cd);
            brand = inflate.findViewById(R.id.brand);
            price = inflate.findViewById(R.id.price);

        }
    }
}
