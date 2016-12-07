package com.anadeainc.exampledagger.common;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;

public final class CommonUtils {

    private CommonUtils() {
    }

    public static void startActivityClearTask(Activity activity, Class<? extends Activity> clazz) {
        Intent intent = new Intent(activity, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    public static void showDialogCommon(FragmentManager fragmentManager, String title, String message) {
        DialogCommon dialog = DialogCommon.newInstance(title, message);
        dialog.setCancelable(false);
        dialog.show(fragmentManager, DialogCommon.class.getSimpleName());
    }
}
