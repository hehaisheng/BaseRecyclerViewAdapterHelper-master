package com.chad.baserecyclerviewadapterhelper.test;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017-02-23.
 */

public class MyMutilItemAdapter  extends BaseMultiItemQuickAdapter<MyItemType,BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyMutilItemAdapter(List<MyItemType> data) {
        super(data);
        addItemType(MyItemType.ITEM_CLICK_TYPE, R.layout.test_oneitem_layout);
        addItemType(MyItemType.ITEM_CLICK_LONG_TYPE,R.layout.test_twoitem_layout);


    }

    @Override
    protected void convert(BaseViewHolder helper, MyItemType item) {
        switch (helper.getItemViewType())
        {
            case MyItemType.ITEM_CLICK_TYPE:
                helper.addOnClickListener(R.id.test_text1).addOnClickListener(R.id.test_text2);
                break;
            case MyItemType.ITEM_CLICK_LONG_TYPE:
                helper.addOnLongClickListener(R.id.test_text3).addOnLongClickListener(R.id.test_text4);
                break;
        }

    }
}
