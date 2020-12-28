package com.example.my_com_huanxin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_com_huanxin.R;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter {
    private Context context;

    private OnClicnener onClicnener;
    private List<String> list1;

    public RecyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list1 = list1;
    }

    {
        try {
            list1 = EMClient.getInstance().contactManager().getSelfIdsOnOtherPlatform();
        } catch (HyphenateException e) {
            e.printStackTrace();
        }
    }

    public void setOnClicnener(OnClicnener onClicnener) {
        this.onClicnener = onClicnener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.buju, parent, false);
        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        String s = list1.get(position);
        viewHolder1.name.setText(s);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClicnener != null) {
                    onClicnener.onClickener(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return list1.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView name;

        public ViewHolder1(View inflate) {
            super(inflate);
            name = inflate.findViewById(R.id.tex_name);
        }
    }

    public interface OnClicnener {
        void onClickener(View view, int p);
    }
}
