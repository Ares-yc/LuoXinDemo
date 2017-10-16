package com.ares.luoxindemo.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ares.luoxindemo.R;
import com.ares.luoxindemo.entity.CourseTypeEntity;

import java.util.List;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：
 * 版    本：1.0.0
 * 创建时间：2017/10/12.
 * 修改时间：2017/10/12.
 * ====================================
 */

public class CourseTypeAdapter extends RecyclerView.Adapter<CourseTypeAdapter.VH>{

    private Context mContext;
    private List<CourseTypeEntity> mDatas;
    private LayoutInflater layoutInflater;

    public CourseTypeAdapter(Context mContext, List<CourseTypeEntity> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_course_type,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        CourseTypeEntity entity = mDatas.get(position);
        holder.nameTv.setText(entity.typeName);
        if (entity.typeSmallNameList != null && entity.typeSmallNameList.size() > 0){
            holder.smallRv.setLayoutManager(new GridLayoutManager(mContext,2));
            CourseTypeSmallAdapter adapter = new CourseTypeSmallAdapter(mContext,entity.typeSmallNameList);
            holder.smallRv.setAdapter(adapter);
            entity.isOpen = true;
        }
        holder.arrowIv.setBackgroundResource(entity.isOpen ? R.drawable.ic_arrow_down : R.drawable.ic_arrow_right);
        switch (entity.typeName) {
            case "全部课程":
                holder.iconIv.setBackgroundResource(R.drawable.ic_menu_all);
                break;
            case "财经":
                holder.iconIv.setBackgroundResource(R.drawable.ic_menu_cj);
                break;
            case "土建":
                holder.iconIv.setBackgroundResource(R.drawable.ic_menu_tj);
                break;
            case "旅游":
                holder.iconIv.setBackgroundResource(R.drawable.ic_menu_ly);
                break;
            default:
                holder.iconIv.setBackgroundResource(R.drawable.ic_menu_zy);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView iconIv,arrowIv;
        TextView nameTv;
        RecyclerView smallRv;

        public VH(View itemView) {
            super(itemView);
            iconIv = itemView.findViewById(R.id.iv_item_course_type_icon);
            arrowIv = itemView.findViewById(R.id.iv_item_course_type_arrow);
            nameTv = itemView.findViewById(R.id.tv_item_course_type_name);
            smallRv = itemView.findViewById(R.id.rv_item_course_type_small);
        }

    }
}
