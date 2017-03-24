package com.chad.baserecyclerviewadapterhelper.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-02-23.
 */

public class MyMutilItemActivity extends Activity{

    public MyMutilItemAdapter myMutilItemAdapter;
    public List<MyItemType> myItemTypes=new ArrayList<>();
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main_layout);
        recyclerView=(RecyclerView) findViewById(R.id.main_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myItemTypes.add(new MyItemType(MyItemType.ITEM_CLICK_TYPE));
        myItemTypes.add(new MyItemType(MyItemType.ITEM_CLICK_LONG_TYPE));
        myMutilItemAdapter=new MyMutilItemAdapter(myItemTypes);
        recyclerView.setAdapter(myMutilItemAdapter);
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            /**
             * Callback method to be invoked when an item in this AdapterView has
             * been clicked.
             *
             * @param view     The view within the AdapterView that was clicked (this
             *                 will be a view provided by the adapter)
             * @param position The position of the view in the adapter.
             */
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                Log.d(TAG, "SimpleOnItemClick: ");
                Toast.makeText(MyMutilItemActivity.this, "onSimpleItemClick" + position, Toast.LENGTH_SHORT).show();
            }
            /**
             * callback method to be invoked when an chidview in this view has been
             * click and held
             *
             * @param view     The view whihin the AbsListView that was clicked
             * @param position The position of the view int the adapter
             * @return true if the callback consumed the long click ,false otherwise
             */
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.d("onItemChildClick "+position+" be click");
                Toast.makeText(MyMutilItemActivity.this, "onItemChildClick" + position, Toast.LENGTH_SHORT).show();

            }

            /**
             * Callback method to be invoked when an item in this view has been clicked and held.
             * @param adapter
             * @param view
             * @param position
             */
            @Override
            public void onItemLongClick(final BaseQuickAdapter adapter, final View view, final int position) {
                Toast.makeText(MyMutilItemActivity.this, "onItemLongClick" + position, Toast.LENGTH_SHORT).show();
            }
            /**
             * Callback method to be invoked when an itemchild in this view has been clicked and held.
             * @param adapter
             * @param view
             * @param position
             */
            @Override
            public void onItemChildLongClick(final BaseQuickAdapter adapter, final View view, final int position) {
                Toast.makeText(MyMutilItemActivity.this, "onItemChildLongClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
