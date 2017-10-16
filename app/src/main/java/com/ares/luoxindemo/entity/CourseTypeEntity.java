package com.ares.luoxindemo.entity;

import java.io.Serializable;
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

public class CourseTypeEntity implements Serializable{

    public String typeName;
    public List<String> typeSmallNameList;
    public boolean isOpen;

    public CourseTypeEntity(String typeName, List<String> typeSmallNameList) {
        this.typeName = typeName;
        this.typeSmallNameList = typeSmallNameList;
    }
}
