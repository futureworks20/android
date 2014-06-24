package com.example.androidextratopics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ApplockkService extends Service {
	List<String> apps = new ArrayList<String>();

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	     public void onCreate() {       
	 
	         super.onCreate();
	 
	     }
	 
	     @Override
	 
	     public void onDestroy() {       
	 
	         super.onDestroy();
	 Log.e("TAG_SERVICE DESTROY CALLED", "@@@@");
	     }

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
	// TODO Auto-generated method stub
	Log.i("Service", "@@@@@@@@@@");
	PackageManager packageManager = getPackageManager();
	Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
	mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
	List<ResolveInfo> appList = packageManager.queryIntentActivities(mainIntent, 0);
	Collections.sort(appList, new ResolveInfo.DisplayNameComparator(packageManager));
	List<PackageInfo> packs = packageManager.getInstalledPackages(0);
	for(int i=0; i < packs.size(); i++) {
	PackageInfo p = packs.get(i);
	ApplicationInfo a = p.applicationInfo;
	// skip system apps if they shall not be included
//	if((a.flags & ApplicationInfo.FLAG_SYSTEM) == 1)
//	{
//	continue;
//	}
	apps.add(p.packageName);
	Log.e(currentApp(), "outside IF");
	if(currentApp().equals("com.onemic"))
	{
		Log.e("TAG ONE MIC", "INSIDE IF");
	Toast.makeText(getApplicationContext(), p.packageName+"   is package name  ", Toast.LENGTH_LONG).show();
	}
	}
	return Service.START_STICKY ;
}

public String currentApp()
{
	ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
	List<ActivityManager.RunningTaskInfo> RunningTask = mActivityManager.getRunningTasks(1);
	ActivityManager.RunningTaskInfo ar = RunningTask.get(0);
	//ar.topActivity.getPackageName()
	String activityOnTop=ar.topActivity.getClassName();
	return activityOnTop;	


}



}
