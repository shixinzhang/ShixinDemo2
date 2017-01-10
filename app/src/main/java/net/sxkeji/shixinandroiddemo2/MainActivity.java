package net.sxkeji.shixinandroiddemo2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import net.sxkeji.shixinandroiddemo2.activity.AmapLocationActivity;
import net.sxkeji.shixinandroiddemo2.activity.AnnotationTestActivity;
import net.sxkeji.shixinandroiddemo2.activity.OaLoginActivity;
import net.sxkeji.shixinandroiddemo2.activity.RefreshLoadMoreActivity;
import net.sxkeji.shixinandroiddemo2.activity.SomeTestActivity;
import net.sxkeji.shixinandroiddemo2.activity.SuspensionHeaderActivity;
import net.sxkeji.shixinandroiddemo2.activity.ChangeThemeActivity;
import net.sxkeji.shixinandroiddemo2.activity.DIYView1Activity;
import net.sxkeji.shixinandroiddemo2.activity.FocusInTouchModeActivity;
import net.sxkeji.shixinandroiddemo2.activity.HybridDemo1Activity;
import net.sxkeji.shixinandroiddemo2.activity.SearchActivity;
import net.sxkeji.shixinandroiddemo2.adapter.ActivityListAdapter;
import net.sxkeji.shixinandroiddemo2.adapter.rvbaseadapter.BaseQuickAdapter;
import net.sxkeji.shixinandroiddemo2.beans.ActivityBean;
import net.sxkeji.shixinandroiddemo2.hybrid.SxWebViewActivity;
import net.sxkeji.shixinandroiddemo2.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 吸取之前那个 demo 的问题，不乱引入第三方，记住！
 */
public class MainActivity extends BaseActivity {
    private final String TAG = this.getClass().getSimpleName();

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private ActivityListAdapter mActivityListAdapter;
    private List<ActivityBean> mActivityNameList;
    private final String INSTANCE_STATE_TEST = "instance_test";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
        loadData();
    }

    @Override
    public void initViews() {

        boolean s = StringUtils.isRgbValue("#7B0D16\t");
        System.out.println("颜色" + s);

        System.out.println(Color.parseColor("#7B0D16"));

        mActivityNameList = new ArrayList<>();
        mActivityNameList.add(new ActivityBean("搜索", SearchActivity.class));
        mActivityNameList.add(new ActivityBean("夜间模式", ChangeThemeActivity.class));
        mActivityNameList.add(new ActivityBean("Hybrid 练习1", HybridDemo1Activity.class));
        mActivityNameList.add(new ActivityBean(getString(R.string.diy_demo1), DIYView1Activity.class));
        mActivityNameList.add(new ActivityBean(getString(R.string.focusable_in_touch), FocusInTouchModeActivity.class));
        mActivityNameList.add(new ActivityBean(getString(R.string.alpha_header_recyclerview), SuspensionHeaderActivity.class));
        mActivityNameList.add(new ActivityBean(getString(R.string.refresh_load_more), RefreshLoadMoreActivity.class));
        mActivityNameList.add(new ActivityBean(getString(R.string.annotation), AnnotationTestActivity.class));
        mActivityNameList.add(new ActivityBean(getString(R.string.some_test), SomeTestActivity.class));
        mActivityNameList.add(new ActivityBean(getString(R.string.some_test), OaLoginActivity.class));
        mActivityNameList.add(new ActivityBean(getString(R.string.location), AmapLocationActivity.class));
        mActivityNameList.add(new ActivityBean(getString(R.string.hybrid), SxWebViewActivity.class));
    }

    @Override
    public void loadData() {

        mActivityListAdapter = new ActivityListAdapter(this, mActivityNameList);
        mActivityListAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Class<?> claz = mActivityListAdapter.getData().get(position).getClaz();
                Intent intent = new Intent(MainActivity.this, claz);
                if (mActivityNameList != null){
                    ActivityBean activityBean = mActivityNameList.get(position);
                    if (getString(R.string.hybrid).equals(activityBean.getName())){
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                        intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    }
                }
                startActivity(intent);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mActivityListAdapter);
    }

    @Override
    public void addListeners() {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        showDebugLog("onSaveInstanceState");
        outState.putString(INSTANCE_STATE_TEST, "shixinzhang");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String saveState = savedInstanceState.getString(INSTANCE_STATE_TEST);
        showDebugLog("onRestoreInstanceState" + saveState);
    }
}
