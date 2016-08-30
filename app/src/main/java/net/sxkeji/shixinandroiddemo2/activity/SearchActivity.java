package net.sxkeji.shixinandroiddemo2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.sxkeji.shixinandroiddemo2.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 搜索
 * Created by zhangshixin on 8/30/2016.
 */
public class SearchActivity extends AppCompatActivity implements View.OnFocusChangeListener{
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        mTvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mEtSearch.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        //聚焦，弹出历史、热门搜素记录
        if (hasFocus){
            mEtSearch.setHint("");

        }else {
            mEtSearch.setHint("全新胜达（进口）");
        }
    }


}
