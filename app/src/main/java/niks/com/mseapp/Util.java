package niks.com.mseapp;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Util {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String getAppVersion(Context context) {
        PackageInfo pInfo = null;
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        assert pInfo != null;
        return pInfo.versionName;
    }

    public static String getCurrentDateTime() {
        //SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        f.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
        return f.format(new Date());
    }



    public static String getCurrentTime() {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        //SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        f.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
        return f.format(new Date());
    }


    public static String getDateOfDay() {
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
        return sdf.format(date);
    }

    public static boolean isInternetConnected(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnected();
    }

    public static void showToastAtCenter(Context context, String toastMessage, boolean toastLong) {
        Toast toast;
        if (toastLong)
            toast = Toast.makeText(context, toastMessage, Toast.LENGTH_LONG);
        else
            toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    public static void hideKeyBoard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }




}
