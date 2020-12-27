package com.example.my_com_synthesize.presenetr;

import com.example.my_com_synthesize.interfaces.IBasePersenter;
import com.example.my_com_synthesize.interfaces.IBaseView;

public class BasePersenter<T extends IBaseView> implements IBasePersenter<T> {

    T view;

    @Override
    public void attachView(T view) {
        this.view = view;

    }

    @Override
    public void unAttachView() {
        this.view = null;
    }
}
