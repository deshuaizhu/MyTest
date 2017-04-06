package com.che168.mytest;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import java.util.List;

/**
 * @author zhudeshuai
 * @since 17/3/24
 */

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this,
				"Application create：" +getProcessName(this,android.os.Process.myPid())
				,Toast.LENGTH_SHORT).show();
	}




	public static String getProcessName(Context cxt, int pid) {
		ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
		if (runningApps == null) {
			return null;
		}
		for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
			if (procInfo.pid == pid) {
				return procInfo.processName;
			}
		}
		return null;
	}

}
