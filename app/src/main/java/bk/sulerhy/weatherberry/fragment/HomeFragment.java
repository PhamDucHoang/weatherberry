package bk.sulerhy.weatherberry.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;

import bk.sulerhy.weatherberry.R;
import bk.sulerhy.weatherberry.activity.MainActivity;


//
//import com.arlib.floatingsearchview.FloatingSearchView;

//import static com.facebook.FacebookSdk.getApplicationContext;


public class HomeFragment extends BaseFragment {
    private final String TAG = "HomeFragment";
    private android.support.v7.widget.SearchView searchView;
    private MainActivity mainActivity;
    private RecyclerView folowedCategory;
    private RecyclerView allCategory;
    private Dialog categoryDialog;
    private LinearLayout emptyPostTextInstruction;
    private final Long TIMELINE_ID = 30041995L;
    private final Long NEWPOST_ID = 10131996L;

    private Long catId;

    public HomeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("HomeFragment", "onCreate");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        mainActivity = getMainActivity();
        categoryDialog = new Dialog(mainActivity);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("HomeFragment", "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d("HomeFragment", "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        Log.d("HomeFragment", "Initialization Start");
        initialize(view);
        catId = TIMELINE_ID;
    }

    public void initialize(View view) {

    }

}
