package com.ares.luoxindemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ares.luoxindemo.R;

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

public class AllTypeSmallAdapter extends RecyclerView.Adapter<AllTypeSmallAdapter.VH>{

    private Context mContext;
    private List<String> mDatas;
    private LayoutInflater layoutInflater;

    public AllTypeSmallAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_course_type_small,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.nameTv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView nameTv;

        public VH(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.tv_item_course_type_small_name);
        }

    }
}
