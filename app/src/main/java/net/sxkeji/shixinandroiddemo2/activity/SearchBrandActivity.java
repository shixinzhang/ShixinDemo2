package net.sxkeji.shixinandroiddemo2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ismaeltoe.FlowLayout;

import net.sxkeji.shixinandroiddemo2.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 搜索品牌或车型
 * Created by zhangshixin on 9/6/2016.
 */
public class SearchBrandActivity extends Activity {
    @Bind(R.id.et_search)
    EditText mEtSearch;
    @Bind(R.id.ll_search)
    LinearLayout mLlSearch;
    @Bind(R.id.tv_cancel)
    TextView mTvCancel;
    @Bind(R.id.flow_recent_search)
    FlowLayout mFlowRecentSearch;
    @Bind(R.id.flow_hot_car)
    FlowLayout mFlowHotCar;
    @Bind(R.id.ll_search_history)
    LinearLayout mLlSearchHistory;
    @Bind(R.id.rv_search_result)
    RecyclerView mRvSearchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_brand);
        ButterKnife.bind(this);

        initSearchData();
    }


    private void initSearchData() {
        for (int i = 0; i < 7; i++) {
            final TextView tvRecentSearch = (TextView) LayoutInflater.from(this).inflate(R.layout.item_search_item, null);
            if (i % 2 == 0) {
                tvRecentSearch.setText("标致40" + i );
            }else {
                tvRecentSearch.setText("标致408标致408标致40"+i);
            }
            tvRecentSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SearchBrandActivity.this, tvRecentSearch.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            mFlowRecentSearch.addView(tvRecentSearch);
        }
        for (int i = 0; i < 10; i++) {
            final TextView tvHotCar = (TextView) LayoutInflater.from(this).inflate(R.layout.item_search_item, null);
            if (i % 2 == 0) {
                tvHotCar.setText("标致40" + i );
            }else if (i == 3 || i == 4 || i == 6){
                tvHotCar.setText("标致408标致408标致40"+i);
            }else {
                tvHotCar.setText("标致40标致40" + i );
            }
            tvHotCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SearchBrandActivity.this, tvHotCar.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            mFlowHotCar.addView(tvHotCar);
        }
    }

}
