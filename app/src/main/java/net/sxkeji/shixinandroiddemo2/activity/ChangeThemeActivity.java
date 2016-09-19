package net.sxkeji.shixinandroiddemo2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import net.sxkeji.shixinandroiddemo2.BaseActivity;
import net.sxkeji.shixinandroiddemo2.R;
import net.sxkeji.shixinandroiddemo2.adapter.ChangeThemeSampleAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * description: 切换夜间模式
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 9/18/2016
 */
public class ChangeThemeActivity extends BaseActivity {
    @Bind(R.id.tv_change_theme)
    TextView mTvChangeTheme;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private ChangeThemeSampleAdapter mAdapter;
    private List mList = Arrays.asList("shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute", "shixinzhang is so cute");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_theme);
        ButterKnife.bind(this);
        initViews();

    }

    @Override
    public void initViews() {
        mTvChangeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMySharedPreferences().edit().putBoolean(THEME_NAME, !isCurrentTheme()).apply();
                setDayNightTheme(!isCurrentTheme());
            }
        });
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mAdapter = new ChangeThemeSampleAdapter(this, mList);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void addListeners() {

    }

}
