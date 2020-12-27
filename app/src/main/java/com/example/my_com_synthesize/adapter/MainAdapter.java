package com.example.my_com_synthesize.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.my_com_synthesize.R;
import com.example.my_com_synthesize.bean.PersonBanner;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;
    private List<PersonBanner.DataBean.BannerBean> list;

    public MainAdapter(Context context, SingleLayoutHelper singleLayoutHelper, List<PersonBanner.DataBean.BannerBean> list) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bujua, parent, false);
        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        PersonBanner.DataBean.BannerBean bannerBean = list.get(position);
        viewHolder1.baner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                PersonBanner.DataBean.BannerBean paths = (PersonBanner.DataBean.BannerBean) path;
                Glide.with(context).load(paths.getImage_url()).into(imageView);
            }
        }).start();

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final Banner baner;

        public ViewHolder1(View inflate) {
            super(inflate);
            baner = inflate.findViewById(R.id.baner);
        }
    }
}
