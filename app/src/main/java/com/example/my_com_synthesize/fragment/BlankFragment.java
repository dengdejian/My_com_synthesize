package com.example.my_com_synthesize.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_com_synthesize.presenetr.BasePersenter;


public abstract class BlankFragment<P extends BasePersenter> extends Fragment {

    public P presenter;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(getLayout(), container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (presenter == null) {
            presenter = add();
        }
        initView(inflate);
        initData();
    }

    protected abstract void initView(View inflate);

    protected abstract P add();

    protected abstract void initData();


    protected abstract int getLayout();

}