package com.dev.hotfixdemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by zyf on 2016/10/26.
 */
@DefaultLifeCycle(application = "com.dev.hotfixdemo.HotfixApplicaion",
        flags = ShareConstants.TINKER_ENABLE_ALL, loadVerifyFlag = false)
public class HotfixApplicationLike extends DefaultApplicationLike {

    public static Application application;

    public HotfixApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent, Resources[] resources, ClassLoader[] classLoader, AssetManager[] assetManager) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent, resources, classLoader, assetManager);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
//      you must install multiDex whatever tinker is installed !
        MultiDex.install(base);
        application = getApplication();
    }
}
