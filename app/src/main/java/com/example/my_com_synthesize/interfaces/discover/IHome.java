package com.example.my_com_synthesize.interfaces.discover;

import com.example.my_com_synthesize.bean.AnewsListBean;
import com.example.my_com_synthesize.bean.AstudentBean;
import com.example.my_com_synthesize.bean.PersonBanner;
import com.example.my_com_synthesize.interfaces.Callback;
import com.example.my_com_synthesize.interfaces.IBasePersenter;
import com.example.my_com_synthesize.interfaces.IBaseView;

/**
 * 同袍首页推荐功能接口锲约类
 */
public interface IHome {

    interface View extends IBaseView, Callback {
        //首页Banner
        void getBannerReturn(PersonBanner bannerBean);

        void getAnewsListReturn(AnewsListBean anewsListBean);

        void getAstudentReturn(AstudentBean astudentBean);
    }

    interface Persenter extends IBasePersenter<View> {
        //首页Banner
        void getBanner();

        void getAnewsList();

        void getAstudent();
    }

    interface Model extends IModel {
        //首页Banner
        void getBannerData(Callback callback);

        void getAnewsListData(Callback callback);

        void getAstudentData(Callback callback);
    }


}
