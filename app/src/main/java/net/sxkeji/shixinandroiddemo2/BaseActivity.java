package net.sxkeji.shixinandroiddemo2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import net.sxkeji.shixinandroiddemo2.annotation.ContentView;

import static android.content.Context.MODE_PRIVATE;

/**
 * description: 基类
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 9/19/2016
 */
public abstract class BaseActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

    public final String THEME_NAME = "theme";
    private SharedPreferences mSharedPreferences;
    private boolean mCurrentTheme;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences = getSharedPreferences("shixinsp", MODE_PRIVATE);
        mCurrentTheme = mSharedPreferences.getBoolean(THEME_NAME, false);
//        setDayNightTheme(mCurrentTheme);

        annotationProcess();
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

    /**
     * 处理注解
     */
    private void annotationProcess() {
        //遍历所有子类
        for (Class c = this.getClass(); c != Context.class; c = c.getSuperclass()) {
            //找到使用 ContentView 注解的类
            ContentView annotation = (ContentView) c.getAnnotation(ContentView.class);
            if (annotation != null) {
                try {   //有可能出错的地方都要 try-catch
                    //获取 注解中的属性值，为 Activity 设置布局
                    this.setContentView(annotation.value());
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

    protected void showErrorLog(String msg) {
        showErrorLog(TAG, msg);
    }

    protected void showErrorLog(String tag, String msg) {
        Log.e(tag, msg);
    }


    protected void showInfoLog(String msg) {
        showInfoLog(TAG, msg);
    }

    protected void showInfoLog(String tag, String msg) {
        Log.i(tag, msg);
    }


    @Override
    protected void onStart() {
        super.onStart();
        showInfoLog("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showInfoLog("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showInfoLog("onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showInfoLog("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showInfoLog("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showInfoLog("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        showInfoLog("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        showInfoLog("onRestoreInstanceState");
    }
}
