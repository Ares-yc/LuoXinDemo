package com.ares.luoxindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ares.luoxindemo.adapter.CourseTypeAdapter;
import com.ares.luoxindemo.entity.CourseTypeEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contentRv;
    private List<CourseTypeEntity> mDatas;
    private CourseTypeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
        initData();
    }

    private void initView() {
        contentRv = (RecyclerView) findViewById(R.id.rv_activity_main_content);

        mDatas = new ArrayList<>();

        mAdapter = new CourseTypeAdapter(this,mDatas);

        contentRv.setLayoutManager(new LinearLayoutManager(this));
        contentRv.setAdapter(mAdapter);
        contentRv.addItemDecoration(new CommonItemDetation(this,R.drawable.divider_ee_10));
    }

    private void initListener() {

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
