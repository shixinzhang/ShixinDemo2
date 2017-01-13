package net.sxkeji.shixinandroiddemo2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import net.sxkeji.shixinandroiddemo2.hybrid.handler.UIHandler;
import net.sxkeji.shixinandroiddemo2.hybrid.handler.internal.HybridFactory;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * <br/> Description:
 * <p>
 * <br/> Created by shixinzhang on 16/12/21.
 * <p>
 * <br/> Email: shixinzhang2016@gmail.com
 * <p>
 * <a  href="https://about.me/shixinzhang">About me</a>
 */

public class SxApplication extends Application {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        addLifecycleListener();
        registerHybridHandler();
        Realm.init(this);
        Realm.setDefaultConfiguration(
                new RealmConfiguration.Builder()
                        .name("shixinzhang.realm")
                        .deleteRealmIfMigrationNeeded()
//                        .inMemory() //数据保存在内存
                        .build()
        );
    }

    private void registerHybridHandler() {
        HybridFactory.getInstance().registerHandlers(UIHandler.class);

    }

    private void addLifecycleListener() {

        //生命周期监听
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {
//                Log.d(TAG, activity.getLocalClassName() + " onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
