package me.xujichang.xfilemanager;

import android.app.Application;

/**
 * Created by xjc on 2017/10/25。
 */

public class FileManagerApplication extends Application {

    public static ActivityRouter sActivityRouter;

    @Override

    public void onCreate() {
        super.onCreate();
        sActivityRouter = ActivityRouter.bindContext(this);
        initFileManagerActivity();
    }

    private void initFileManagerActivity() {
        sActivityRouter.putPreActivity(FileManagerMainActivity.class);
        sActivityRouter.putPreActivity(FileManagerDocumentActivity.class);
        sActivityRouter.putPreActivity(FileManagerPictureActivity.class);
        sActivityRouter.putPreActivity(FileManagerVideoActivity.class);
    }
}
