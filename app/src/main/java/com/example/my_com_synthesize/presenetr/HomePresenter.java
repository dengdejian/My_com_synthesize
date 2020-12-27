package com.example.my_com_synthesize.presenetr;

import android.util.Log;

import com.example.my_com_synthesize.bean.AnewsListBean;
import com.example.my_com_synthesize.bean.AstudentBean;
import com.example.my_com_synthesize.bean.PersonBanner;
import com.example.my_com_synthesize.interfaces.Callback;
import com.example.my_com_synthesize.interfaces.discover.IHome;
import com.example.my_com_synthesize.model.HomeModel;

public class HomePresenter extends BasePersenter<IHome.View> implements IHome.Persenter {

    IHome.View view;
    IHome.Model model;

    public HomePresenter(IHome.View view) {
        this.view = view;
        model = new HomeModel();
    }

    @Override
    public void getBanner() {
        this.model.getBannerData(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null) {
                    view.getBannerReturn((PersonBanner) o);
                    Log.d("TAG", "success: " + o.toString());
                }
            }
        });
    }

    @Override
    public void getAnewsList() {
        this.model.getAnewsListData(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null) {
                    view.getAnewsListReturn((AnewsListBean) o);
                    Log.d("TAG", "success: " + o.toString());
                }
            }
        });
    }

    @Override
    public void getAstudent() {
        this.model.getAstudentData(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null) {
                    view.getAstudentReturn((AstudentBean) o);
                    Log.d("TAG", "success: " + o.toString());
                }
            }
        });
    }
}
