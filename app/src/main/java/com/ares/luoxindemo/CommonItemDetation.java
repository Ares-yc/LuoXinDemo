package com.ares.luoxindemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/9/28.
 */

public class CommonItemDetation extends RecyclerView.ItemDecoration{

    private Drawable mDivider;

    public CommonItemDetation(Context mContext, int resId){
        mDivider = ContextCompat.getDrawable(mContext,resId);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int right = mDivider.getIntrinsicWidth();
        int bottom = mDivider.getIntrinsicHeight();
        //最后一列无需right分割线
        if(isLastColumn(view,parent)){
            right = 0;
        }
        //最后一行无需bottom分割线
        if(isLastRow(view,parent)){
            bottom = 0;
        }
        outRect.right = right;
        outRect.bottom = bottom;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        drawHorizontal(c,parent);
        drawVertical(c,parent);
    }

    //画竖直分割线
    private void drawVertical(Canvas c, RecyclerView parent) {
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int left = childView.getRight() + params.leftMargin;
            int right = left + mDivider.getIntrinsicWidth();
            int top = childView.getTop() - params.topMargin;
            int bottom = childView.getBottom() + params.bottomMargin;
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    //画水平分割线
    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int left = childView.getLeft() - params.leftMargin;
            int right = left + childView.getWidth() + mDivider.getIntrinsicWidth() + params.leftMargin + params.rightMargin;
            int top = childView.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    //判断是否是最后一行
    private boolean isLastRow(View view, RecyclerView parent) {
        //判断最后一行：当前项数 > (行数 - 1) * 列数
        return  getPosition(view) + 1 > (getRowCount(parent) - 1) * getSpanCount(parent);
    }

    //获取行数
    private int getRowCount(RecyclerView parent) {
        //获取行数：item总数%列数 == 0 ? item总数/列数 : (item总数/列数)+1
        return parent.getAdapter().getItemCount() % getSpanCount(parent) == 0 ?
                parent.getAdapter().getItemCount()/getSpanCount(parent) :
                (parent.getAdapter().getItemCount()/getSpanCount(parent) +1);
    }

    //判断是否是最后一列
    public boolean isLastColumn(View view, RecyclerView parent) {
        //判断最后一列：当前项数 % 列数  == 0
        //当前项数 = position + 1
        return (getPosition(view) + 1) % getSpanCount(parent) == 0;
    }

    //获取列数
    private int getSpanCount(RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager){
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            return gridLayoutManager.getSpanCount();
        }
        return 1;
    }

    //获取当前item系数
    private int getPosition(View view) {
        return ((RecyclerView.LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
    }
}
