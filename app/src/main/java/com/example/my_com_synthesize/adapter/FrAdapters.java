package com.example.my_com_synthesize.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.my_com_synthesize.R;
import com.example.my_com_synthesize.bean.PersonBanner;

import java.util.ArrayList;
import java.util.List;

public class FrAdapters extends DelegateAdapter.Adapter {
    private Context context;
    private List<PersonBanner.DataBean.TopicListBean> list;
    private OnePlusNLayoutHelper onePlusNLayoutHelper;

    public FrAdapters(Context context, List<PersonBanner.DataBean.TopicListBean> list, OnePlusNLayoutHelper onePlusNLayoutHelper) {
        this.context = context;
        this.list = list;
        this.onePlusNLayoutHelper = onePlusNLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return onePlusNLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bujug, parent, false);
        return new ViewHolderw(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderw viewHolderw = (ViewHolderw) holder;
        PersonBanner.DataBean.TopicListBean topicListBean = list.get(position);

        VpAdapter vpAdapter = new VpAdapter(context, list);
        viewHolderw.pager.setAdapter(vpAdapter);

        viewHolderw.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewHolderw.title.setText(topicListBean.getTitle());

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewHolderw.title.setText(topicListBean.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolderw extends RecyclerView.ViewHolder {

        private final ViewPager pager;
        private final TextView title;

        public ViewHolderw(View inflate) {
            super(inflate);
            pager = inflate.findViewById(R.id.pagers);
            title = inflate.findViewById(R.id.tex_title);
        }
    }
}
