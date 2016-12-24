package net.sxkeji.shixinandroiddemo2.hybrid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.FrameLayout;

import net.sxkeji.shixinandroiddemo2.R;

/**
 * <br/> Description:
 * WebView 的容器 Fragment，负责管理 WebView 的：
 * 1.加载（加载动画、加载进度、加载内容）、
 * 2.拦截（某些页面需要跳转到 Native） ----  由 H5 主动触发逻辑，不管是跳转还是显示原生组件，弹个对话框啥的，都是一套机制
 * 3.错误监听（ 404，网络错误...）、
 * 4.替换为离线 H5 （加强体验）、
 * <p>
 * <p>
 * 待做：
 * CSS,JS 资源预加载
 * <p>
 * <br/> Created by shixinzhang on 16/12/23.
 * <p>
 * <br/> Email: shixinzhang2016@gmail.com
 * <p>
 * <a  href="https://about.me/shixinzhang">About me</a>
 */

public class SxWebViewFragment extends Fragment implements SxWebViewProxy.OnUrlReplaceListener {
    private final String TAG = this.getClass().getSimpleName();
    public static final String URL = "link_url";

    private SxWebViewProxy mWebViewProxy;
    private SxWebViewProxy.OnWebViewUIChangedListener mWebViewUIChangedListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof SxWebViewProxy.OnWebViewUIChangedListener) {
            mWebViewUIChangedListener = (SxWebViewProxy.OnWebViewUIChangedListener) activity;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FrameLayout view = (FrameLayout) inflater.inflate(R.layout.fragment_webview, null);
        addWebView(view);
        initWebViewSetting();
        loadUrl();
        return view;
    }

    private void loadUrl() {
        String linkUrl = getArguments().getString(URL);
        if (mWebViewProxy != null && !TextUtils.isEmpty(linkUrl)) {
            mWebViewProxy.loadUrl(linkUrl);
        } else {
            showDebugLog("load url failed!");
        }
    }

    @SuppressWarnings("setJavaScriptEnabled")
    private void initWebViewSetting() {
        if (mWebViewProxy == null) {
            return;
        }
        WebSettings settings = mWebViewProxy.getSettings();
        settings.setJavaScriptEnabled(true);    //允许使用 JS
    }

    private void addWebView(FrameLayout view) {
        if (view != null) {
            mWebViewProxy = new SxWebViewProxy(getContext());
            mWebViewProxy.setUrlReplaceListener(this);
            SxWebChromeClient webChromeClient = new SxWebChromeClient();
            webChromeClient.setWebViewUIChangedListener(mWebViewUIChangedListener);
            mWebViewProxy.setWebChromeClient(webChromeClient);

            mWebViewProxy.setWebViewClient(new SxWebViewClient(mWebViewProxy));
            try {
                view.addView(mWebViewProxy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public SxWebViewProxy getWebView() {
        return mWebViewProxy;
    }

    public boolean canGoBack() {
        if (mWebViewProxy != null && mWebViewProxy.canGoBack()) {
            return true;
        }
        return false;
    }

    public void goBack() {
        if (mWebViewProxy != null) {
            mWebViewProxy.goBack();
        }
    }

    /**
     * 是否替换为离线 URL
     *
     * @param url
     * @return
     */
    @Override
    public String onUrlReplace(String url) {
        return url;
    }

    private void showDebugLog(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        Log.e(TAG, msg);
    }


}
