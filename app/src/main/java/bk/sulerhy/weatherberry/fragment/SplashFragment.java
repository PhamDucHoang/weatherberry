package bk.sulerhy.weatherberry.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bk.sulerhy.weatherberry.R;
import bk.sulerhy.weatherberry.activity.MainActivity;

public class SplashFragment extends BaseFragment {
    private final String TAG = "SplashFragment";
    private MainActivity mainActivity;

    public SplashFragment() {
    }

    public static SplashFragment newInstance() {
        SplashFragment fragment = new SplashFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mainActivity = getMainActivity();
        checkAPIConnection();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }

    /**
     * Internet接続をチェックする
     */
    public boolean checkInternetConnection(){
        ConnectivityManager cm = (ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        boolean connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
        if (!connected){
            Log.e(TAG,"Connection fail");
            AlertDialog.Builder builder1 = new AlertDialog.Builder(mainActivity);
            builder1.setMessage("通信に失敗しました。ネットワーク設定を確認の上、再度お試しください。");
            builder1.setCancelable(true);
            builder1.setNegativeButton(
                    "×",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
            return false;
        }else{
            return true;
        }
    }

    /**
     * APIから正常な返答がない場合をチェックする。
     */
    public void checkAPIConnection(){
        boolean hasInternetAccess = checkInternetConnection();
        if (hasInternetAccess) {
            //check API connection
            //if success
            Log.i(TAG,"connection successfully");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    mainActivity.setFirstFragment(new HomeFragment(), "Home");

                }
            }, 2000);  // Give a 2 seconds delay.
        }
    }


}

