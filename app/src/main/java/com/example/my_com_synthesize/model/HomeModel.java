package com.example.my_com_synthesize.model;


import android.util.Log;

import com.example.my_com_synthesize.api.HomeApi;
import com.example.my_com_synthesize.bean.AnewsListBean;
import com.example.my_com_synthesize.bean.AstudentBean;
import com.example.my_com_synthesize.bean.PersonBanner;
import com.example.my_com_synthesize.interfaces.Callback;
import com.example.my_com_synthesize.interfaces.discover.IHome;
import com.example.my_com_synthesize.net.CommonSubscriber;
import com.example.my_com_synthesize.net.HomeHttpManager;
import com.example.my_com_synthesize.utils.RxUtils;

import io.reactivex.disposables.Disposable;


public class HomeModel extends BaseModel implements IHome.Model {

    private HomeApi api;

    public HomeModel() {
        api = HomeHttpManager.getInstance().getDiscoverApi();
    }

    @Override
    public void getBannerData(Callback callback) {
        CommonSubscriber<PersonBanner> disposable = api.getBannerDesc().compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<PersonBanner>(callback) {
                    @Override
                    public void onNext(PersonBanner bannerBean) {
                        callback.success(bannerBean);
                    }
                });
        addDisposable(disposable);
    }

    @Override
    public void getAnewsListData(Callback callback) {
        addDisposable(api.getAnewsList().compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AnewsListBean>(callback) {
                    @Override
                    public void onNext(AnewsListBean anewsListBean) {
                        callback.success(anewsListBean);
                    }
                }));
    }

    @Override
    public void getAstudentData(Callback callback) {
        addDisposable(api.getAstudent().compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AstudentBean>(callback) {
                    @Override
                    public void onNext(AstudentBean astudentBean) {
                        callback.success(astudentBean);
                    }
                }));
    }

    @Override
    public void addDisposable(Disposable disposable) {

    }

    @Override
    public void clear() {

    }
}
