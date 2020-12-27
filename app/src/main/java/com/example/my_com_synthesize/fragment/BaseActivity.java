package com.example.my_com_synthesize.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_com_synthesize.presenetr.BasePersenter;

public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity {
    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (presenter == null) {
            presenter = add();
        }
        initView();
        initData();
    }

    protected abstract P add();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayout();

}
