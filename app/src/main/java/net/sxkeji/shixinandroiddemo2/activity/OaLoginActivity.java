package net.sxkeji.shixinandroiddemo2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import net.sxkeji.shixinandroiddemo2.BaseActivity;
import net.sxkeji.shixinandroiddemo2.R;
import net.sxkeji.shixinandroiddemo2.api.OaApi;
import net.sxkeji.shixinandroiddemo2.beans.OaCheckInResultBean;
import net.sxkeji.shixinandroiddemo2.beans.OaLoginResultBean;
import net.sxkeji.shixinandroiddemo2.beans.OaStatusBean;
import net.sxkeji.shixinandroiddemo2.beans.OaUserInfoBean;
import net.sxkeji.shixinandroiddemo2.helper.RequestHelper;
import net.sxkeji.shixinandroiddemo2.utils.EncodeUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * <br/> Description:
 * <p>
 * <br/> Created by shixinzhang on 16/12/8.
 * <p>
 * <br/> Email: shixinzhang2016@gmail.com
 * <p>
 * <a  href="https://about.me/shixinzhang">About me</a>
 */

public class OaLoginActivity extends BaseActivity {
    private final String TAG = this.getClass().getSimpleName();
    @Bind(R.id.tv_detail)
    TextView mTvDetail;
    @Bind(R.id.btn_login)
    Button mBtnLogin;
    @Bind(R.id.tv_user_info)
    TextView mTvUserInfo;

    private String mSessionKey;
    private String mMsg;
    private String mLatlng = "31.221517,121.382759";    //经纬度
    private String mAddr = "%E4%B8%8A%E6%B5%B7%E5%B8%82%E6%99%AE%E9%99%80%E5%8C%BA%E5%85%89%E5%A4%8D%E8%A5%BF%E8%B7%AF%E9%9D%A0%E8%BF%91%E6%B1%87%E9%93%B6%E9%93%AD%E5%B0%8A6%E5%8F%B7%E6%A5%BC";
    private String mBaseUrl = "http://oa.yaomaiche.com:89";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initViews();
        loadData();
    }

    @Override
    public void initViews() {
        RequestHelper.setBaseUrl(mBaseUrl);
    }

    @Override
    public void loadData() {
        getUserInfo();
        getStatus();
    }

    @Override
    public void addListeners() {
    }

    void showLog(String msg) {
        Log.d(TAG, msg);
    }

    @OnClick(R.id.btn_check_in)
    public void checkIn() {
        checkInOrOut(true);
    }

    private void checkInOrOut(boolean isCheckIn) {
        String type = isCheckIn ? "checkin" : "checkout";
        if (!isCheckIn) {
            mAddr = EncodeUtils.urlDecode(mAddr);
        }
        if (TextUtils.isEmpty(mAddr)) {
            mAddr = "上海市普陀区光复西路靠近汇银铭尊6号楼";
        }

        new RequestHelper().create(OaApi.class)
                .checkIn("checkin", type, mLatlng, mAddr, mSessionKey)
                .enqueue(new Callback<OaCheckInResultBean>() {
                    @Override
                    public void onResponse(Call<OaCheckInResultBean> call, Response<OaCheckInResultBean> response) {
//                        showLog(response.body());
                        if (response.body() != null) {
                            showMsg(response.body().toString());
                        } else {
                            showMsg("签到失败");
                        }
                    }

                    @Override
                    public void onFailure(Call<OaCheckInResultBean> call, Throwable t) {
                        showLog(t.getMessage());
                        showMsg("签到失败: " + t.getMessage());
                    }
                });
    }

    @OnClick(R.id.btn_check_out)
    public void checkOut() {
        checkInOrOut(false);
    }

    @OnClick(R.id.btn_get_status)
    public void getStatus() {
        new RequestHelper().create(OaApi.class)
                .getStatus("checkin", "getStatus", mSessionKey)
                .enqueue(new Callback<OaStatusBean>() {
                    @Override
                    public void onResponse(Call<OaStatusBean> call, Response<OaStatusBean> response) {
                        Log.e(TAG, "onResponse" + response.code() + " \n " + response.body() + " \n" + response.message() + "\n" + response.errorBody());
                        OaStatusBean oaStatusBean = response.body();
                        if (oaStatusBean != null) {
                            showLog(oaStatusBean.toString());
                        } else {
                            showLog("oaStatusBean is null");
                            return;
                        }
                        List<OaStatusBean.SignbtnsBean> signbtnsBeanList = oaStatusBean.getSignbtns();

                        if (signbtnsBeanList == null) {
                            showMsg("查询失败，请检查是否登录");
                            return;
                        }
                        String statusResult = " ";
                        for (int i = 0; i < signbtnsBeanList.size(); i++) {
                            OaStatusBean.SignbtnsBean signbtnsBean = signbtnsBeanList.get(i);
                            OaStatusBean.SignbtnsBean.DetailBean detail = signbtnsBean.getDetail();
                            if (detail != null) {
                                String addr = detail.getAddr();
                                String latitude = detail.getLatitude();
                                String longitude = detail.getLongitude();
                                String signTime = detail.getSignDate() + ", " + detail.getSignTime();
                                String status = detail.getStatus();
                                String isEnable = signbtnsBean.getIsEnable();

                                String currentStatus = i == 0 ? "签到" : "签退";

                                statusResult += "\n查询成功\n" + addr + "\n" + "坐标 (" + latitude + "," + longitude + ")\n" + currentStatus + "时间：" + signTime
                                        + "\n 当前状态：" + status + "\n能否再次：" + isEnable;
                            }
                        }
                        showMsg(statusResult);


                    }

                    @Override
                    public void onFailure(Call<OaStatusBean> call, Throwable t) {
                        Log.d(TAG, "onFailure " + t.getMessage());
                        showMsg("查询状态失败： " + t.getMessage());
                    }
                });
    }

    @OnClick(R.id.btn_login)
    public void login() {
        new RequestHelper().create(OaApi.class)
                .login("login", "zhangshixin", "Yuntu@123")
                .enqueue(new Callback<OaLoginResultBean>() {
                    @Override
                    public void onResponse(Call<OaLoginResultBean> call, Response<OaLoginResultBean> response) {
                        showLog("onResponse: " + response);
                        OaLoginResultBean loginResultBean = response.body();
                        if (loginResultBean == null) {
                            return;
                        }
                        mSessionKey = loginResultBean.getSessionkey();
                        showLog(mSessionKey);
                        showMsg("登录成功，sessionKey: " + mSessionKey);
                        getUserInfo();
                    }

                    @Override
                    public void onFailure(Call<OaLoginResultBean> call, Throwable t) {
                        showLog("onFailure " + t.getMessage());
                        showMsg("登录失败：" + t.getMessage());
                    }
                });
    }

    public void getUserInfo() {
        new RequestHelper().create(OaApi.class)
                .getUserInfo("getuser", mSessionKey)
                .enqueue(new Callback<OaUserInfoBean>() {
                    @Override
                    public void onResponse(Call<OaUserInfoBean> call, Response<OaUserInfoBean> response) {
                        OaUserInfoBean userInfoBean = response.body();
                        if (userInfoBean == null) {
                            showErrorGetUserInfo();
                            return;
                        }
                        if (userInfoBean.getName() == null){
                            showErrorGetUserInfo();
                            return;
                        }
                        mTvUserInfo.setText(userInfoBean.getName() + "\n" + userInfoBean.getSubcom() + "\n" + userInfoBean.getJobtitle());

                    }

                    @Override
                    public void onFailure(Call<OaUserInfoBean> call, Throwable t) {
                        showErrorGetUserInfo();
                    }
                });
    }

    private void showErrorGetUserInfo(){
        mTvUserInfo.setText("查询个人信息失败，请检查是否登录");
    }

    private void showMsg(String s) {
        if (!TextUtils.isEmpty(s))
            mTvDetail.setText(s);
    }
}
