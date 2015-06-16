package com.privaties.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class constant {

	// public static boolean flag = true;

	public static void Set_flag(Integer flag, Context context) {
		SharedPreferences pref = context.getSharedPreferences("MyPref", 0);
		Editor editor = pref.edit();
		editor.putInt("Sync_flag", flag);
		editor.commit();
	}

	public static Integer get_flag(Context context) {
		SharedPreferences pref = context.getSharedPreferences("MyPref", 0);
		Integer flag = pref.getInt("Sync_flag", 0);
		return flag;
	}
}
