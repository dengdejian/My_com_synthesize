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
import com.bumptech.glide.Glide;
import com.example.my_com_synthesize.R;
import com.example.my_com_synthesize.bean.PersonBanner;

import java.util.ArrayList;
import java.util.List;

public class MainGridAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private List<PersonBanner.DataBean.ChannelBean> list;

    public MainGridAdapter(Context context, List<PersonBanner.DataBean.ChannelBean> list, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.list = list;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    private GridLayoutHelper gridLayoutHelper;

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bujub, parent, false);
        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PersonBanner.DataBean.ChannelBean channelBean = list.get(position);
        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        String name1 = channelBean.getName();
        Glide.with(context).load(channelBean.getIcon_url()).into(viewHolder1.img_b);
        viewHolder1.tex_b.setText(name1);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView tex_b;
        private final ImageView img_b;

        public ViewHolder1(View inflate) {
            super(inflate);
            img_b = inflate.findViewById(R.id.img_b);
            tex_b = inflate.findViewById(R.id.te_b);
        }
    }
}
