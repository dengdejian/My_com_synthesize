package com.example.my_com_synthesize.api;

import com.example.my_com_synthesize.bean.AnewsListBean;
import com.example.my_com_synthesize.bean.AstudentBean;
import com.example.my_com_synthesize.bean.PersonBanner;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface HomeApi {
    //Banner
    //https://cdwan.cn/api/index
    String BASE_BANNER = "https://cdwan.cn/";

    @GET("api/index")
    Flowable<PersonBanner> getBannerDesc();

    //http://cdwan.cn:7000/exam2003/anewslist.json
    @GET("exam2003/anewslist.json")
    Flowable<AnewsListBean> getAnewsList();

    //http://cdwan.cn:7000/exam2003/astudent.json
    @GET("exam2003/astudent.json")
    Flowable<AstudentBean> getAstudent();
}
