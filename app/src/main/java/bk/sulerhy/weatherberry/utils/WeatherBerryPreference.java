package bk.sulerhy.weatherberry.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class WeatherBerryPreference {

    private final static String PREF_NAME = "WEATHERBERRY";
    private final static String KEY_TUTORIAL = "IS_TUTORIAL_VIEWED";
    private final static String KEY_TOKEN = "TOKEN";
    private final static String KEY_USER_ID = "USER_ID";

    public static boolean isTutorialViewed(Context context) {
        SharedPreferences whigooPref = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        return whigooPref.getBoolean(KEY_TUTORIAL, false);
    }

    public static void setTutorialViewStatus(Context context, boolean isViewed) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE).edit();
        editor.putBoolean(KEY_TUTORIAL, isViewed);
        editor.apply();
    }

    public static String getToken(Context context) {
        SharedPreferences whigooPref = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        return whigooPref.getString(KEY_TOKEN, null);
    }

    public static void setToken(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE).edit();
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }
    public static Long getUserId(Context context) {
        SharedPreferences whigooPref = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        return whigooPref.getLong(KEY_USER_ID, 0);
    }

    public static void setUserId(Context context, Long userId) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE).edit();
        editor.putLong(KEY_USER_ID, userId);
        editor.apply();
    }
}
