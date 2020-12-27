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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.my_com_synthesize.R;
import com.example.my_com_synthesize.bean.PersonBanner;

import java.util.List;

public class LisAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;

    private List<PersonBanner.DataBean.HotGoodsListBean> list;

    public LisAdapter(Context context, LinearLayoutHelper linearLayoutHelper, List<PersonBanner.DataBean.HotGoodsListBean> list) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bujuf, parent, false);
        return new Viewholders(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Viewholders viewholders=(Viewholders)holder;
        PersonBanner.DataBean.HotGoodsListBean hotGoodsListBean = list.get(position);
        Glide.with(context).load(hotGoodsListBean.getList_pic_url()).into(viewholders.off);
        viewholders.name.setText(hotGoodsListBean.getName());
        viewholders.ds.setText(hotGoodsListBean.getGoods_brief());
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private class Viewholders extends RecyclerView.ViewHolder {

        private final TextView ds;
        private final TextView name;
        private final ImageView off;

        public Viewholders(View inflate) {
            super(inflate);
            off = inflate.findViewById(R.id.img_off);
            name = inflate.findViewById(R.id.tex_name);
            ds = inflate.findViewById(R.id.tex_goods);
        }
    }
}
