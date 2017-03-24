package com.chad.baserecyclerviewadapterhelper.test;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2017-02-23.
 */

public class MyItemType implements MultiItemEntity{

    public static final int ITEM_CLICK_TYPE=0;
    public static final int ITEM_CLICK_LONG_TYPE=1;
    public int type;

    public MyItemType(final int type)
    {
        this.type=type;

    }


    @Override
    public int getItemType() {
        return  type;
    }
}
