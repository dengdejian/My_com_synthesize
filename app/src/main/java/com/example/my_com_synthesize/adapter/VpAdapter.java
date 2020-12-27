package com.example.my_com_synthesize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.my_com_synthesize.bean.PersonBanner;

import java.util.List;

public class VpAdapter extends PagerAdapter {

    private Context context;
    private List<PersonBanner.DataBean.TopicListBean> list;

    public VpAdapter(Context context, List<PersonBanner.DataBean.TopicListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        PersonBanner.DataBean.TopicListBean topicListBean = list.get(position);
        // item_pic_url
        //https://github.com/dengdejian?tab=repositorieshttps://yanxuan.nosdn.127.net/14943267735961674.jpg
        String img = "https://github.com/dengdejian?tab=repositorieshttps://yanxuan.nosdn.127.net/14943267735961674.jpg";
        String item_pic_url = topicListBean.getItem_pic_url();
        Glide.with(context).load(img).into(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
