package net.sxkeji.shixinandroiddemo2.hybrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import net.sxkeji.shixinandroiddemo2.BaseActivity;
import net.sxkeji.shixinandroiddemo2.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * <br/> Description:
 * <p>
 * <br/> Created by shixinzhang on 16/12/23.
 * <p>
 * <br/> Email: shixinzhang2016@gmail.com
 * <p>
 * <a  href="https://about.me/shixinzhang">About me</a>
 */

public class SxWebViewActivity extends BaseActivity implements SxWebViewProxy.OnWebViewUIChangedListener {
    @Bind(R.id.load_progress)
    ProgressBar mLoadProgress;

    private SxWebViewFragment mWebViewFragment;
    private final String testUrl = "http://m.blog.csdn.net/blog/index?username=u011240877";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    public void initViews() {
        mWebViewFragment = new SxWebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SxWebViewFragment.URL, testUrl);
        mWebViewFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_webview, mWebViewFragment)
                .commit();
    }

    @Override
    public void loadData() {
    }

    @Override
    public void addListeners() {
    }

    @Override
    public void onTitleChanged(String title) {
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
    }

    @Override
    public void onProgressChanged(float progress) {

    }


//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK){
//            if (mWebViewFragment != null && mWebViewFragment.canGoBack()){
//                mWebViewFragment.canGoBack();
//            }else {
//                finish();
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
