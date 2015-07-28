package com.sysu.databank.tools;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {
	public static List<Activity> activities = new ArrayList<Activity>();
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	public static void removeActivity(Activity activity){
		activities.remove(activity);
	}
	public static void FinishAll(){
		for(Activity activity : activities){
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}

}
