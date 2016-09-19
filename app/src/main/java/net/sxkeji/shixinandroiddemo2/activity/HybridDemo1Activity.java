package net.sxkeji.shixinandroiddemo2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import net.sxkeji.shixinandroiddemo2.BaseActivity;
import net.sxkeji.shixinandroiddemo2.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * description: Hybrid 练习1,熟悉 Native 与 H5 的基本交互
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 9/19/2016
 */
public class HybridDemo1Activity extends BaseActivity {

    @Bind(R.id.web_view)
    WebView mWebView;
    @Bind(R.id.btn_call_js)
    Button mBtnCallJs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hybrid_demo1);
        ButterKnife.bind(this);
        initViews();
        addListeners();
    }

    @Override
    public void initViews() {
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JsBridge(), "zsx");
        mWebView.loadUrl("file:///android_asset/demo.html");
    }

    @Override
    public void addListeners() {
        mBtnCallJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.loadUrl("javascript:show('shixinzhang is so cute')");
            }
        });
    }

    @Override
    public void loadData() {

    }

    public class JsBridge {

        public JsBridge() {

        }

        /**
         * 在非 UI 线程回调
         *
         * @param number
         */
        @JavascriptInterface
        public void makeCall(String number) {
            Intent view = new Intent();
            view.setAction(Intent.ACTION_DIAL);
            view.setData(Uri.parse("tel:" + number));
            startActivity(view);
        }
    }
}
