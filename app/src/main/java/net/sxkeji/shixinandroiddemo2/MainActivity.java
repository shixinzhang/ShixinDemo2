package net.sxkeji.shixinandroiddemo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.sxkeji.shixinandroiddemo2.activity.SearchActivity;
import net.sxkeji.shixinandroiddemo2.adapter.ActivityListAdapter;
import net.sxkeji.shixinandroiddemo2.adapter.BaseQuickAdapter;
import net.sxkeji.shixinandroiddemo2.beans.ActivityBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private ActivityListAdapter mActivityListAdapter;
    private List<ActivityBean> mActivityNameList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initList();

    }

    private void initList() {
        mActivityListAdapter = new ActivityListAdapter(this, mActivityNameList);
        mActivityListAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Class<?> claz = mActivityNameList.get(position).getClaz();
                Intent intent = new Intent(MainActivity.this, claz);
                startActivity(intent);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mActivityListAdapter);
    }

    private void initData() {
        mActivityNameList = new ArrayList<>();
        mActivityNameList.add(new ActivityBean("搜索", SearchActivity.class));

    }
}
