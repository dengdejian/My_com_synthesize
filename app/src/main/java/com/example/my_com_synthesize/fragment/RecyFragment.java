package com.example.my_com_synthesize.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.example.my_com_synthesize.adapter.CanAdapter;
import com.example.my_com_synthesize.adapter.FrAdapters;
import com.example.my_com_synthesize.adapter.GridAdaopter;
import com.example.my_com_synthesize.adapter.LiAdapter;
import com.example.my_com_synthesize.adapter.LisAdapter;
import com.example.my_com_synthesize.adapter.PlusAdapter;
import com.example.my_com_synthesize.R;
import com.example.my_com_synthesize.adapter.MainAdapter;
import com.example.my_com_synthesize.adapter.MainGridAdapter;
import com.example.my_com_synthesize.adapter.VpAdapter;
import com.example.my_com_synthesize.bean.AnewsListBean;
import com.example.my_com_synthesize.bean.AstudentBean;
import com.example.my_com_synthesize.adapter.LineAdapter;
import com.example.my_com_synthesize.bean.PersonBanner;
import com.example.my_com_synthesize.interfaces.discover.IHome;
import com.example.my_com_synthesize.presenetr.HomePresenter;

import java.util.List;

public class RecyFragment extends BlankFragment<HomePresenter> implements IHome.View {

    private SearchView search;
    private RecyclerView recy;
    private List<PersonBanner.DataBean.BannerBean> banner;
    private List<PersonBanner.DataBean.ChannelBean> channel;
    private List<PersonBanner.DataBean.BrandListBean> brandList;
    private List<PersonBanner.DataBean.NewGoodsListBean> newGoodsList;
    private List<PersonBanner.DataBean.HotGoodsListBean> hotGoodsList;
    private List<PersonBanner.DataBean.TopicListBean> topicList;
    private List<PersonBanner.DataBean.CategoryListBean> categoryList;

    @Override
    public void getBannerReturn(PersonBanner bannerBean) {
        channel = bannerBean.getData().getChannel();
        PersonBanner.DataBean data = bannerBean.getData();
        banner = data.getBanner();
        brandList = bannerBean.getData().getBrandList();
        newGoodsList = bannerBean.getData().getNewGoodsList();
        hotGoodsList = bannerBean.getData().getHotGoodsList();
        topicList = bannerBean.getData().getTopicList();
        categoryList = bannerBean.getData().getCategoryList();

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recy.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(7, 10);

        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(5);
        singleLayoutHelper.setPadding(20, 20, 20, 20);
        singleLayoutHelper.setMargin(20, 20, 20, 20);
        singleLayoutHelper.setBgColor(Color.WHITE);//设置背景颜色

        //第一个布局
        MainAdapter mainAdapter = new MainAdapter(getActivity(), singleLayoutHelper, banner);


        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(1);
        gridLayoutHelper.setItemCount(5);
        gridLayoutHelper.setPadding(20, 20, 20, 20);
        gridLayoutHelper.setMargin(20, 20, 20, 20);
        gridLayoutHelper.setBgColor(Color.BLUE);//设置背景颜色
        gridLayoutHelper.setAutoExpand(false);
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例

        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格

        //第二个 布局
        MainGridAdapter mainGridAdapter = new MainGridAdapter(getActivity(), channel, gridLayoutHelper);

        //第三个布局
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(2);
        staggeredGridLayoutHelper.setItemCount(2);
        staggeredGridLayoutHelper.setPadding(20, 20, 20, 20);
        staggeredGridLayoutHelper.setMargin(20, 20, 20, 20);
        staggeredGridLayoutHelper.setBgColor(Color.BLUE);//设置背景颜色

        staggeredGridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        staggeredGridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        PlusAdapter plusAdapter = new PlusAdapter(getActivity(), staggeredGridLayoutHelper, brandList);

        //第四个布局
        LinearLayoutHelper onePlusNLayoutHelper = new LinearLayoutHelper();
        onePlusNLayoutHelper.setBgColor(Color.CYAN);//设置背景颜色
        onePlusNLayoutHelper.setItemCount(1);
        LineAdapter lineAdapter = new LineAdapter(getActivity(), onePlusNLayoutHelper);


        //第五个布局
        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(1);

        gridLayoutHelper1.setItemCount(2);
        gridLayoutHelper1.setPadding(70, 20, 20, 20);
        gridLayoutHelper1.setMargin(70, 20, 20, 20);
        gridLayoutHelper1.setAutoExpand(false);
        gridLayoutHelper1.setWeights(new float[]{40, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例

        gridLayoutHelper1.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper1.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper1.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper1.setSpanCount(2);// 设置每行多少个网格

        GridAdaopter gridAdaopter = new GridAdaopter(getActivity(), gridLayoutHelper1, newGoodsList);

        //第六个布局
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);

        LisAdapter lisAdapter = new LisAdapter(getActivity(), linearLayoutHelper, hotGoodsList);

        //第七个布局
        OnePlusNLayoutHelper onePlusNLayoutHelper1 = new OnePlusNLayoutHelper();
        int size = topicList.size();
        onePlusNLayoutHelper1.setItemCount(size);
        FrAdapters frAdapters = new FrAdapters(getActivity(), topicList, onePlusNLayoutHelper1);

        //第八个布局
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2, 2);
        gridLayoutHelper2.setItemCount(2);

        LiAdapter liAdapter = new LiAdapter(getActivity(), categoryList, gridLayoutHelper2);

        //第九個佈局
        LinearLayoutHelper linearLayoutHelper1 = new LinearLayoutHelper();
        linearLayoutHelper1.setItemCount(1);
        CanAdapter canAdapter = new CanAdapter(getActivity(), linearLayoutHelper1);

        


        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(mainAdapter);
        delegateAdapter.addAdapter(mainGridAdapter);
        delegateAdapter.addAdapter(plusAdapter);
        delegateAdapter.addAdapter(lineAdapter);
        delegateAdapter.addAdapter(gridAdaopter);
        delegateAdapter.addAdapter(lisAdapter);
        delegateAdapter.addAdapter(frAdapters);
        delegateAdapter.addAdapter(liAdapter);
        delegateAdapter.addAdapter(canAdapter);

        recy.setLayoutManager(virtualLayoutManager);
        recy.setAdapter(delegateAdapter);


    }

    @Override
    public void getAnewsListReturn(AnewsListBean anewsListBean) {

    }

    @Override
    public void getAstudentReturn(AstudentBean astudentBean) {

    }

    @Override
    public void fail(String msg) {

    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void tips(String tip) {
        Log.e("TAG==--", "tips: " + tip);
    }

    @Override
    public void loading(int visible) {

    }

    @Override
    protected void initView(View inflate) {
        search = (SearchView) inflate.findViewById(R.id.search);
        recy = (RecyclerView) inflate.findViewById(R.id.recy);
    }

    @Override
    protected HomePresenter add() {
        return new HomePresenter(this);
    }

    @Override
    protected void initData() {
        presenter.getBanner();
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_recy;
    }
}