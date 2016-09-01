package net.sxkeji.shixinandroiddemo2.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ismaeltoe.FlowLayout;
import com.squareup.picasso.Picasso;

import net.sxkeji.shixinandroiddemo2.R;
import net.sxkeji.shixinandroiddemo2.adapter.BaseQuickAdapter;
import net.sxkeji.shixinandroiddemo2.adapter.SearchResultAdapter;
import net.sxkeji.shixinandroiddemo2.beans.CarBrandBean;
import net.sxkeji.shixinandroiddemo2.utils.GsonUtils;
import net.sxkeji.shixinandroiddemo2.views.sortlistview.SortFramlayout;
import net.sxkeji.shixinandroiddemo2.views.sortlistview.SortModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 买车 Tab Native
 * Created by zhangshixin on 9/1/2016.
 */
public class BuyCarTabFragment extends Fragment implements View.OnFocusChangeListener, TextWatcher {
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
    @Bind(R.id.sortframlayout)
    SortFramlayout mSortframlayout;
    @Bind(R.id.iv_logo)
    ImageView mIvSelectBrandLogo;
    @Bind(R.id.tv_name)
    TextView mTvSelectBrandName;
    @Bind(R.id.recycler_car_series)
    RecyclerView mRecyclerCarSeries;
    @Bind(R.id.drawer_car_series)
    RelativeLayout mDrawerCarSeries;
    @Bind(R.id.drawlayout)
    DrawerLayout mDrawlayout;
    @Bind(R.id.flow_recent_search)
    FlowLayout mFlowRecentSearch;
    @Bind(R.id.flow_hot_car)
    FlowLayout mFlowHotCar;
    @Bind(R.id.ll_search_history)
    LinearLayout mLlSearchHistory;
    @Bind(R.id.recycler_view)
    RecyclerView mSearchResultList;

    private Context mContext;
    private Activity mActivity;
    private SearchResultAdapter mSearchResultAdapter;
    private
    List<String> mSearchResultData = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "b", "c", "d", "b", "c", "d", "b", "c", "d", "b", "c", "d", "b", "c", "d"));
    private List<SortModel> mCarBrandList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_car, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mContext = getContext();
        mActivity = getActivity();
        loadData();
        initViews();
        setListener();
    }

    private void loadData() {
        initSearchData();
        initLocalCarListData();
    }

    private void initSearchData() {
        for (int i = 0; i < 10; i++) {
            final TextView tvRecentSearch = (TextView) LayoutInflater.from(mContext).inflate(R.layout.item_search_item, null);
            tvRecentSearch.setText("宝马" + i + "系");
            tvRecentSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, tvRecentSearch.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            mFlowRecentSearch.addView(tvRecentSearch);
        }
        for (int i = 0; i < 10; i++) {
            final TextView tvHotCar = (TextView) LayoutInflater.from(mContext).inflate(R.layout.item_search_item, null);
            tvHotCar.setText("宝马" + i + "系");
            tvHotCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, tvHotCar.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            mFlowHotCar.addView(tvHotCar);
        }
    }

    private void initViews() {
        initSearch();
        initCarBrandList();
    }

    private void initCarBrandList() {
        if (mCarBrandList != null) {
            mSortframlayout.setData(null, mCarBrandList);
            mSortframlayout.setRefresh(false);
        } else {
            Log.e("汽车品牌列表", "汽车列表为空");
        }
    }

    private void initSearch() {
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
                View currentFocus = mActivity.getCurrentFocus();
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

        mSearchResultAdapter = new SearchResultAdapter(mContext, mSearchResultData);
        mSearchResultAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String s = mSearchResultAdapter.getData().get(position);
                Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
            }
        });
        mSearchResultList.setLayoutManager(new LinearLayoutManager(mContext));
        mSearchResultList.setAdapter(mSearchResultAdapter);
    }


    /**
     * 输入框是否选中的状态改变
     *
     * @param v
     * @param hasFocus
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (mEtSearch == null || mTvSearch == null || mIvClear == null) {
            return;
        }
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
        mLlSearchHistory.setVisibility(View.VISIBLE);
    }

    private void dismissSearchHistoryView() {
        mEtSearch.clearFocus();
        mLlSearchHistory.setVisibility(View.GONE);
    }

    /**
     * 监听输入框输入的内容，实时搜索
     *
     * @param s
     * @param start
     * @param before
     * @param count
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (TextUtils.isEmpty(s)) {
            mSearchResultList.setVisibility(View.GONE);
        } else {

            // TODO: 8/30/2016 请求搜索结果，填充数据
            mSearchResultData.add(s.toString());
            mSearchResultAdapter.setData(mSearchResultData);
            mSearchResultList.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 加载本地品牌数据
     */
    private void initLocalCarListData() {
        try {
            InputStream inputStream = mActivity.getAssets().open("allbrand.json.txt");
            int size = inputStream.available();
            byte[] bytes = new byte[size];
            inputStream.read(bytes);
            String localBrandJson = new String(bytes);

            //加载成功，解析
            if (!TextUtils.isEmpty(localBrandJson)) {
                CarBrandBean carBrandBean = (CarBrandBean) GsonUtils.jsonToBean(localBrandJson, CarBrandBean.class);
                mCarBrandList = carBrandBean.getCarBrandList();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("汽车品牌列表", "汽车列表加载失败" + e.getMessage());
        }
    }

    private void setListener() {
        mSortframlayout.setOnItemClickListener(new SortFramlayout.SortListviewOnitemClickInterface() {
            @Override
            public void onItemClick(List<SortModel> sortModels, int position) {
                SortModel sortModel = sortModels.get(position);
                if (sortModel != null && !TextUtils.isEmpty(sortModel.getName())) {
                    mTvSelectBrandName.setText(sortModel.getName());
                    String logoUrl = sortModel.getLogoUrl();
                    if (!TextUtils.isEmpty(logoUrl)) {
                        Picasso.with(mContext).load(logoUrl)
                                .placeholder(R.mipmap.ic_launcher)
                                .error(R.mipmap.ic_launcher)
                                .into(mIvSelectBrandLogo);
                    }
                }
                setDrawlayout();
            }
        });
    }

    /**
     * 抽屉的展开与关闭
     **/
    private void setDrawlayout() {
        if (mDrawlayout.isDrawerOpen(mDrawerCarSeries)) {
            mDrawlayout.closeDrawer(GravityCompat.END);
        } else {
            mDrawlayout.openDrawer(GravityCompat.END);
        }
        mDrawlayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                mDrawlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED); //打开
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                mDrawlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED); //关闭滑动
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }


//    @Override
//    public void onBackPressed() {
//        if (mDrawlayout != null && mDrawlayout.isDrawerOpen(mDrawerCarSeries)) {
//            mDrawlayout.closeDrawers();
//            return;
//        }
//        mActivity.finish();
//    }

    @Override
    public void afterTextChanged(Editable s) {
        //do nothing
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //do nothing
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
