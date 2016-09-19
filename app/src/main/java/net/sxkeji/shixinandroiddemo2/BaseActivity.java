package net.sxkeji.shixinandroiddemo2;

import android.content.SharedPreferences;
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
    public final String THEME_NAME = "theme";
    private SharedPreferences mSharedPreferences;
    private boolean mCurrentTheme;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences = getSharedPreferences("shixinsp", MODE_PRIVATE);
        mCurrentTheme = mSharedPreferences.getBoolean(THEME_NAME, false);
        setDayNightTheme(mCurrentTheme);
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

    public SharedPreferences getMySharedPreferences() {
        return mSharedPreferences;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public boolean isCurrentTheme() {
        return mCurrentTheme;
    }

    public void setCurrentTheme(boolean currentTheme) {
        mCurrentTheme = currentTheme;
    }

    /**
     * 切换日夜间模式
     *
     * @param isDay
     */
    public void setDayNightTheme(boolean isDay) {
        if (isDay) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        if (isDay != isCurrentTheme()) {
            getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
            recreate();
        }
    }
}
