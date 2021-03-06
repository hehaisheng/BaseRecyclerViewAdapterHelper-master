package com.chad.baserecyclerviewadapterhelper.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.ClickEntity;
import com.chad.baserecyclerviewadapterhelper.util.Utils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 *
 */
public class ItemClickAdapter extends BaseMultiItemQuickAdapter<ClickEntity, BaseViewHolder> {
    NestAdapter nestAdapter;
    public ItemClickAdapter(List<ClickEntity> data) {
        super(data);
        //对不同的类型设置不同的布局，按顺序布局
        addItemType(ClickEntity.CLICK_ITEM_VIEW, R.layout.item_click_view);
        addItemType(ClickEntity.CLICK_ITEM_CHILD_VIEW, R.layout.item_click_childview);
        addItemType(ClickEntity.LONG_CLICK_ITEM_VIEW, R.layout.item_long_click_view);
        addItemType(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW, R.layout.item_long_click_childview);
        addItemType(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW, R.layout.item_nest_click);

    }


    @Override
    protected void convert(final BaseViewHolder helper, final ClickEntity item) {
        switch (helper.getItemViewType()) {
            //对该布局的btn点击时，出现的是item长按点击，不是child
            //就是下面的代码的意思就是：对btn设置一个点击
            //在开始设置了父类能消耗点击，这里是特别设置
            case ClickEntity.CLICK_ITEM_VIEW:
                helper.addOnClickListener(R.id.btn);
                break;
            case ClickEntity.CLICK_ITEM_CHILD_VIEW:
                helper.addOnClickListener(R.id.iv_num_reduce).addOnClickListener(R.id.iv_num_add)
                .addOnLongClickListener(R.id.iv_num_reduce).addOnLongClickListener(R.id.iv_num_add);
                // set img data
                break;
            case ClickEntity.LONG_CLICK_ITEM_VIEW:
                helper.addOnLongClickListener(R.id.btn);
                break;
            case ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW:
                helper.addOnLongClickListener(R.id.iv_num_reduce).addOnLongClickListener(R.id.iv_num_add)
                .addOnClickListener(R.id.iv_num_reduce).addOnClickListener(R.id.iv_num_add);
                break;
            case ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW:
                helper.setNestView(R.id.item_click); // u can set nestview id
                final RecyclerView recyclerView = (RecyclerView) helper.getView(R.id.nest_list);
                recyclerView.setLayoutManager(new LinearLayoutManager(helper.getConvertView().getContext(),LinearLayoutManager.VERTICAL,false));
                recyclerView.setHasFixedSize(true);

                nestAdapter = new NestAdapter();
                recyclerView.setAdapter(nestAdapter);

                recyclerView.addOnItemTouchListener(listener);
                break;
        }
    }
    final OnItemClickListener listener = new OnItemClickListener() {
        @Override
        public void onSimpleItemClick(final BaseQuickAdapter baseQuickAdapter, final View view, final int i) {
            Logger.d( "嵌套RecycleView item 收到: "+"点击了第 "+i+" 一次");
            Toast.makeText(Utils.getContext(), "嵌套RecycleView item 收到: "+"点击了第 "+i+" 一次", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            Toast.makeText(Utils.getContext(), "childView click", Toast.LENGTH_SHORT).show();

        }
    };
}
