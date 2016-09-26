package net.sxkeji.shixinandroiddemo2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import net.sxkeji.shixinandroiddemo2.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * description: 熟悉 focusableInTouchMode
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 9/26/2016
 */
public class FocusInTouchModeActivity extends AppCompatActivity {

    @Bind(R.id.et_normal)
    EditText mEtNormal;
    @Bind(R.id.et_not_focus_in_touch_mode)
    EditText mEtNotFocusInTouchMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_in_touch_mode);
        ButterKnife.bind(this);

        mEtNormal.setFocusableInTouchMode(false);
    }
}
