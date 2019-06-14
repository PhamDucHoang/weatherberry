package bk.sulerhy.weatherberry.fragment;

import android.support.v4.app.Fragment;

import bk.sulerhy.weatherberry.activity.MainActivity;


public class BaseFragment extends Fragment {

    protected MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }
}
