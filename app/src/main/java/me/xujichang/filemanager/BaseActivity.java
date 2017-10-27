package me.xujichang.filemanager;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.xujichang.util.activity.SuperActivity;

/**
 * Created by xjc on 2017/10/25。
 */

public abstract class BaseActivity extends SuperActivity {

    @Override
    protected long getActivityExitDuration() {
        return 1000;
    }

    @Override
    protected String getMainActivityName() {
        return "MainActivity";
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.sActivityRouter.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainApplication.sActivityRouter.deleteActivity(this);
    }

    protected void toFileActivity() {

    }
}
