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

import java.util.List;

public class GridAdaopter extends DelegateAdapter.Adapter {
    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private List<PersonBanner.DataBean.NewGoodsListBean> list;

    public GridAdaopter(Context context, GridLayoutHelper gridLayoutHelper, List<PersonBanner.DataBean.NewGoodsListBean> list) {
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bujue, parent, false);
        return new ViewHolders(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolders viewHolders = (ViewHolders) holder;
        PersonBanner.DataBean.NewGoodsListBean newGoodsListBean = list.get(position);
            Glide.with(context).load(newGoodsListBean.getList_pic_url()).placeholder(R.drawable.vpr).into(viewHolders.img_str);
            viewHolders.tex_str.setText(newGoodsListBean.getName());

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    private class ViewHolders extends RecyclerView.ViewHolder {

        private  TextView tex_strs;
        private  TextView tex_str;
        private  ImageView img_str;

        public ViewHolders(View inflate) {
            super(inflate);
            img_str = inflate.findViewById(R.id.img_str);
            tex_str = inflate.findViewById(R.id.tex_str);
            tex_strs = inflate.findViewById(R.id.tex_strs);
        }
    }
}
