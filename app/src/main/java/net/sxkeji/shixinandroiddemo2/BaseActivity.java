package net.sxkeji.shixinandroiddemo2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

/**
 * description: 基类
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 9/19/2016
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 子类统一，初始化布局
     */
    public abstract void initViews();

    /**
     * 子类统一，加载数据
     */
    public abstract void loadData();

    /**
     * 子类统一，添加监听
     */
    public abstract void addListeners();

    /**
     * 切换日夜间模式
     * @param isDay
     */
    public void switchDayNightTheme(boolean isDay) {
        if (isDay) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
        recreate();
    }
}
