package me.xujichang.xfilemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by xjc on 2017/10/25。
 */

public class ActivityRouter {

    private static HashMap<String, Activity> sActivityHashMap = new HashMap<>();
    private static HashMap<String, Class<? extends Activity>> sPreActivityMap = new HashMap<>();
    private static ActivityRouter instance;
    private static WeakReference<Context> sContext;

    private ActivityRouter() {

    }

    public static ActivityRouter bindContext(Context context) {
        sContext = new WeakReference<Context>(context);
        return getInstance();
    }

    private static class ClassHolder {

        private static ActivityRouter sRouter = new ActivityRouter();
    }

    public static ActivityRouter getInstance() {
        checkContext();
        if (instance == null) {
            instance = ClassHolder.sRouter;
        }
        return instance;
    }

    /**
     * 添加Activity
     */
    public void addActivity(Activity activity) {
        checkContext();
        addActivity(activity, activity.getClass().getName());
    }

    /**
     * 检测是否初始化 对Context赋值
     */
    private static void checkContext() {
        if (null == sContext || null == sContext.get()) {
            throw new RuntimeException("This Router has no Context that is useful");
        }
    }

    /**
     * 添加Activity
     */
    public void addActivity(Activity activity, String tag) {
        checkContext();
        sActivityHashMap.put(tag, activity);
    }

    /**
     * 删除Activity
     */
    public void deleteActivity(Activity activity) {
        checkContext();
        sActivityHashMap.remove(activity.getClass().getName());
    }

    /**
     * 根据 TAG 删除Activity
     */
    public void deleteActivity(String tag) {
        checkContext();
        sActivityHashMap.remove(tag);
    }

    /**
     * 根据 TAG  查找Activity 并跳转
     * 此Activity 必须是仍然在Map内的
     */
    public void returnToActivity(String tag) {
        Activity activity = sActivityHashMap.get(tag);
        if (null == activity) {
            throw new RuntimeException("This  Tag  is not in the Activity Map");
        }
        toActivity(activity.getClass());
    }

    public void putPreActivity(Class<? extends Activity> c) {
        sPreActivityMap.put(c.getName(), c);
    }

    public void putPreActivity(Class<Activity> c, String tag) {
        sPreActivityMap.put(tag, c);
    }

    public void toActivity(String tag) {
        Class<? extends Activity> c = sPreActivityMap.get(tag);
        if (null == c) {
            throw new RuntimeException("This  Tag  is not in the Activity PreMap");
        }
        toActivity(c);
    }

    public void toActivity(Class<?> c) {
        checkContext();
        Context context = sContext.get();
        Intent intent = new Intent(context, c);
        context.startActivity(intent);
    }
}
