package net.sxkeji.shixinandroiddemo2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.TextView;

import net.sxkeji.shixinandroiddemo2.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * description:
 * <br/>
 * author: shixinzhang
 * <br/>
 * data: 9/18/2016
 */
public class ChangeThemeActivity extends AppCompatActivity {
    @Bind(R.id.tv_change_theme)
    TextView mTvChangeTheme;
    private boolean isNight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_theme);
        ButterKnife.bind(this);
        mTvChangeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDayNightMode(isNight);
                isNight = !isNight;
            }
        });
    }

    public void setDayNightMode(boolean day) {
        if (day)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
        recreate();
    }
}
