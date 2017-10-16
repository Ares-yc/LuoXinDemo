package com.ares.luoxindemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ares.luoxindemo.CommonItemDetation;
import com.ares.luoxindemo.R;
import com.ares.luoxindemo.adapter.AllTypeAdapter;
import com.ares.luoxindemo.entity.CourseTypeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：
 * 版    本：1.0.0
 * 创建时间：2017/10/16.
 * 修改时间：2017/10/16.
 * ====================================
 */

public class AllTypeFragment extends Fragment{

    private RecyclerView contentRv;
    private List<CourseTypeEntity> mDatas;
    private AllTypeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_type,container,false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        contentRv = (RecyclerView) view.findViewById(R.id.rv_fragment_all_type_content);

        mDatas = new ArrayList<>();

        mAdapter = new AllTypeAdapter(getContext(),mDatas);

        contentRv.setLayoutManager(new LinearLayoutManager(getContext()));
        contentRv.setAdapter(mAdapter);
        contentRv.addItemDecoration(new CommonItemDetation(getContext(),R.drawable.divider_ee_10));

    }

    private void initData() {
        mDatas.add(new CourseTypeEntity("全部分类",new ArrayList<String>()));

        List<String> typeSmallNameList01 = new ArrayList<>();
        typeSmallNameList01.add("财政金融");
        typeSmallNameList01.add("财务会计");
        typeSmallNameList01.add("经济贸易");
        typeSmallNameList01.add("市场营销");
        typeSmallNameList01.add("工商管理");
        mDatas.add(new CourseTypeEntity("财经",typeSmallNameList01));

        List<String> typeSmallNameList02 = new ArrayList<>();
        typeSmallNameList02.add("建筑设计");
        typeSmallNameList02.add("城镇规划与管理");
        typeSmallNameList02.add("土建施工");
        typeSmallNameList02.add("建筑设备");
        typeSmallNameList02.add("工程管理");
        typeSmallNameList02.add("市政工程");
        typeSmallNameList02.add("房地产");
        mDatas.add(new CourseTypeEntity("土建",typeSmallNameList02));

        List<String> typeSmallNameList03 = new ArrayList<>();
        typeSmallNameList03.add("旅游管理");
        typeSmallNameList03.add("餐饮管理与服务");
        typeSmallNameList03.add("计算机");
        typeSmallNameList03.add("人文素质");
        mDatas.add(new CourseTypeEntity("旅游",typeSmallNameList03));

        mDatas.add(new CourseTypeEntity("资源开发与测试",new ArrayList<String>()));
        mAdapter.notifyDataSetChanged();
    }
}
