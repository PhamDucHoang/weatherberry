package bk.sulerhy.weatherberry.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bk.sulerhy.weatherberry.activity.MainActivity;
import bk.sulerhy.weatherberry.R;
import bk.sulerhy.weatherberry.utils.HttpHelper;
import bk.sulerhy.weatherberry.utils.HttpListener;

//import com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker;

public class NewPostFragment extends BaseFragment {

    private final String TAG = "NewPostFragment";

    private Button uploadBtn;
    private ImageView backBtn;
    private String questionText="";
    private EditText uploadCmt;
    private ImageView uploadImg1;
    private ImageView uploadImg2;
    private ImageButton deletePicBtn1;
    private ImageButton deletePicBtn2;
    private MainActivity mainActivity;
    private Dialog imgPickerDialog;
    private TextView uploadCatTitle;
//    private SingleDateAndTimePicker singleDateAndTimePicker;
    private TextView dateTimeTv;
//    private Spinner categorySpinner;
    ArrayList<String> catListName;
    Long deadlineTime = 0L;
    Dialog timeDiaglog;
    Dialog catDiaglog;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    ArrayList<Category> categoriesDownloaded = new ArrayList<>();
    String chosenCategoriesText = "";
    String chosenCatNameText="";


//    final int CAMERA_PIC1 = 10;
//    final int CAMERA_PIC2 = 20;
//    final int LIBRARY_PIC1 = 11;
//    final int LIBRARY_PIC2 = 21;
    int code;
    final int PICTURE1 = 1111;
    final int PICTURE2 = 2222;


    private String imagePath1, imagePath2;

    private HashMap<String, Long> categoryMap = new HashMap<>();

    public NewPostFragment() {
    }

    public static NewPostFragment newInstance() {
        NewPostFragment fragment = new NewPostFragment();
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
        return inflater.inflate(R.layout.fragment_new_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivity = getMainActivity();
        mainActivity.showLoadingDialog();
        initialize(view);
//        singleDateAndTimePicker.setVisibility(View.GONE);


    }

    private void initialize(View view) {
    }

    public class Category{
        public String name;
        public Long catId;
    }
    public class CategoriesList{
        ArrayList<Category> category;
    }
}
