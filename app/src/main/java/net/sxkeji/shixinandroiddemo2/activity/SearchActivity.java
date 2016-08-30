package net.sxkeji.shixinandroiddemo2.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ismaeltoe.FlowLayout;

import net.sxkeji.shixinandroiddemo2.R;
import net.sxkeji.shixinandroiddemo2.adapter.SearchResultAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 搜索
 * Created by zhangshixin on 8/30/2016.
 */
public class SearchActivity extends AppCompatActivity implements View.OnFocusChangeListener, TextWatcher {
    private final String TAG = "SearchActivity";
    @Bind(R.id.iv_search)
    ImageView mIvSearch;
    @Bind(R.id.et_search)
    EditText mEtSearch;
    @Bind(R.id.iv_clear)
    ImageView mIvClear;
    @Bind(R.id.tv_search)
    TextView mTvSearch;
    @Bind(R.id.root)
    LinearLayout mRoot;
    @Bind(R.id.tv_content)
    TextView mTvContent;
    @Bind(R.id.ll_search_history)
    LinearLayout mLlSearchHistory;
    @Bind(R.id.flow_recent_search)
    FlowLayout mFlowRecentSearch;
    @Bind(R.id.flow_hot_car)
    FlowLayout mFlowHotCar;
    @Bind(R.id.recycler_view)
    RecyclerView mSearchResultList;

    private SearchResultAdapter mSearchResultAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        initViews();
        initSearchData();
        mTvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtSearch.requestFocus();
            }
        });
        mIvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtSearch.clearFocus();
                View currentFocus = SearchActivity.this.getCurrentFocus();
                if (currentFocus != null) {
                    IBinder windowToken = currentFocus.getWindowToken();
                    if (windowToken != null) {
                        InputMethodManager inputMethodManager = (InputMethodManager) currentFocus.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                    }
                }
            }
        });
        mEtSearch.setOnFocusChangeListener(this);
        mEtSearch.addTextChangedListener(this);
    }

    private void initViews() {
        mSearchResultAdapter = new SearchResultAdapter(this, new ArrayList<>(Arrays.asList("a", "b", "c", "d")));
        mSearchResultList.setLayoutManager(new LinearLayoutManager(this));
        mSearchResultList.setAdapter(mSearchResultAdapter);
    }

    private void initSearchData() {
        for (int i = 0; i < 10; i++) {
            View searchItem = LayoutInflater.from(this).inflate(R.layout.item_search_item, null);
            ((TextView) searchItem.findViewById(R.id.tv_item)).setText("宝马" + i + "系");
            mFlowRecentSearch.addView(searchItem);
        }
        for (int i = 0; i < 10; i++) {
            View searchItem = LayoutInflater.from(this).inflate(R.layout.item_search_item, null);
            ((TextView) searchItem.findViewById(R.id.tv_item)).setText("宝马" + i + "系");
            mFlowHotCar.addView(searchItem);
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        //聚焦，弹出历史、热门搜素记录
        if (hasFocus) {
            mEtSearch.setHint("");
            mTvSearch.setVisibility(View.GONE);
            mIvClear.setVisibility(View.VISIBLE);
            showSearchHistoryView();
        } else {
            mEtSearch.setHint("全新胜达（进口）");
            mEtSearch.setText("");
            mIvClear.setVisibility(View.GONE);
            mTvSearch.setVisibility(View.VISIBLE);
            dismissSearchHistoryView();
        }
    }

    private void showSearchHistoryView() {
//        if (mSearchHistoryPopup == null) {
//            View v = LayoutInflater.from(this).inflate(R.layout.include_search_history, null);
//            mSearchHistoryPopup = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
//            mSearchHistoryPopup.setOutsideTouchable(false);
//            mSearchHistoryPopup.setBackgroundDrawable(new BitmapDrawable());
//        }
//        mSearchHistoryPopup.showAsDropDown(mEtSearch);
        mLlSearchHistory.setVisibility(View.VISIBLE);
    }

    private void dismissSearchHistoryView() {
//        if (mSearchHistoryPopup != null && mSearchHistoryPopup.isShowing()) {
//            mSearchHistoryPopup.dismiss();
//        }
        mEtSearch.clearFocus();
        mLlSearchHistory.setVisibility(View.GONE);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // TODO: 8/30/2016 请求接口搜索
        Log.e(TAG, "onTextChanged " + s);
        if (TextUtils.isEmpty(s)) {
            mSearchResultList.setVisibility(View.GONE);
        } else {
            mSearchResultList.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
