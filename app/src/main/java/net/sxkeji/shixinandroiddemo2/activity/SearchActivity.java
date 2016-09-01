package net.sxkeji.shixinandroiddemo2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import net.sxkeji.shixinandroiddemo2.R;

/**
 * 搜索
 * Created by zhangshixin on 8/30/2016.
 */
public class SearchActivity extends AppCompatActivity {

    private BuyCarTabFragment mBuyCarTabFragment;
    private OnBackPressFragmentListener mOnBackPressFragmentListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mBuyCarTabFragment = new BuyCarTabFragment();
        mOnBackPressFragmentListener = mBuyCarTabFragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, mBuyCarTabFragment).commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mOnBackPressFragmentListener != null && mOnBackPressFragmentListener.onBackPressed()) {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 返回键监听器，用于向 Fragment 传递返回事件
     */
    public interface OnBackPressFragmentListener {
        boolean onBackPressed();
    }
}
