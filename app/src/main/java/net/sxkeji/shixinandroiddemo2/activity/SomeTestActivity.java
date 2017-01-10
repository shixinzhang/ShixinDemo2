package net.sxkeji.shixinandroiddemo2.activity;

import android.content.Intent;
import android.net.Uri;

import net.sxkeji.shixinandroiddemo2.BaseActivity;
import net.sxkeji.shixinandroiddemo2.R;

import butterknife.OnClick;

/**
 * <br/> Description: 一些小内容
 * <p>
 * <br/> Created by shixinzhang on 16/12/15.
 * <p>
 * <br/> Email: shixinzhang2016@gmail.com
 * <p>
 * <a  href="https://about.me/shixinzhang">About me</a>
 */

public class SomeTestActivity extends BaseActivity {


    @Override
    public void initViews() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void addListeners() {

    }

    public void jump2Market() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
