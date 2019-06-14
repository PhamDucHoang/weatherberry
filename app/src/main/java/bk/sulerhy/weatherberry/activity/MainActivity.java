package bk.sulerhy.weatherberry.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import bk.sulerhy.weatherberry.R;

public class MainActivity extends AppCompatActivity {
    private final String TAG ="MainActivity";
    public Fragment mCurrentFragment;
    public Fragment mRootFragment;
    private BottomNavigationView bottomMenu;
    private ImageButton floatingButton;

    private ImageView homeBtnImage;
    private ImageView noticeBtnImage;
    private ImageView profileBtnImage;
    private Dialog yesNoDiaglog, confirmDiaglog;
    private TextView confirmDialogMsg, confirmDialogOkBtn;
    private ArrayList<Fragment> popFragments = new ArrayList<>();
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void showLoadingDialog(String contentDialog){
        dialog = ProgressDialog.show(MainActivity.this, "",
                contentDialog, true);
    }
    public void showLoadingDialog(){
        dialog = ProgressDialog.show(MainActivity.this, "",
                "ロード中 お待ちください...", true);
    }

    public void popBackStack() {
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack();
        popFragments.remove(popFragments.size()-1);
        mCurrentFragment = popFragments.get(popFragments.size()-1);

//        homeClickTimes=3;
    }


    /**
     * 最初のフラグメントを設定する。
     * */
    public void setFirstFragment(Fragment fragment, String name) {
        mCurrentFragment = fragment;
        mRootFragment = fragment;
        popFragments.clear();
        popFragments.add(fragment);
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        manager.beginTransaction()
//                .setCustomAnimations(android.R.anim.slide_in_left,
//                        android.R.anim.slide_out_right)
                .replace(R.id.main_container, fragment, name)
                .commit();
    }

    /**
     * 新しいフラグメントをバックスタックに追加する。
     */
    public void addNextFragment(Fragment newFragment, String newFragmentName) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
//                .setCustomAnimations(android.R.anim.slide_in_left,
//                        android.R.anim.slide_out_right)
                .add(R.id.main_container, newFragment, newFragmentName)
                .hide(popFragments.get(popFragments.size()-1))
                .addToBackStack(newFragmentName)
                .commitAllowingStateLoss();
        popFragments.add(newFragment);
        mCurrentFragment = newFragment;

    }

    /**
     * フラグメントを一つ前に戻す。
     */
    public void popToRoot() {
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack(0, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        mCurrentFragment = mRootFragment;
        Fragment rootFragment = popFragments.get(0);
        popFragments.clear();
        popFragments.add(rootFragment);
        mCurrentFragment = popFragments.get(popFragments.size()-1);
//        profileClicked=false;
    }


}
