package bk.sulerhy.weatherberry.utils;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Http通信のヘルパークラス
 */

public class HttpHelper implements Callback {
    private HttpListener mListener;
    private OkHttpClient mOkHttpClient;
    private Context mContext;

    public HttpHelper(Context context, HttpListener listener) {
        mListener = listener;
        mContext = context;
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.connectTimeout(20, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(20, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(20, TimeUnit.SECONDS);

        mOkHttpClient = okHttpBuilder.build();
    }
    /**
     * POST通信開始
     */
    public void postMultipartContent(String url, RequestBody body) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("token", WeatherBerryPreference.getToken(mContext) == null ? Urls.DEFAULT_TOKEN : WeatherBerryPreference.getToken(mContext))
                .post(body)
                .build();

        mOkHttpClient.newCall(request).enqueue(this);
        Log.d("HttpHelper","post to: " + url);
    }

    /**
     * GET通信開始
     */
    public void get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("token", WeatherBerryPreference.getToken(mContext) == null ? Urls.DEFAULT_TOKEN : WeatherBerryPreference.getToken(mContext))
                .get()
                .build();

        mOkHttpClient.newCall(request).enqueue(this);
        Log.d("HttpHelper","get from: " + url);
    }

    /**
     * POST通信開始
     */
    public void post(String url, String json) {
        RequestBody body ;
        if (json!=null) {
            body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), json);
        }else {
            body=RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), "");
        }
        Request request = new Request.Builder()
                .url(url)
                .addHeader("token", WeatherBerryPreference.getToken(mContext) == null ? Urls.DEFAULT_TOKEN : WeatherBerryPreference.getToken(mContext))
                .post(body)
                .build();

        mOkHttpClient.newCall(request).enqueue(this);
        Log.d("HttpHelper","post to: " + url);
    }


    /**
     * POST通信開始
     */
    public void put(String url, String json) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), json);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("token", WeatherBerryPreference.getToken(mContext) == null ? Urls.DEFAULT_TOKEN : WeatherBerryPreference.getToken(mContext))
                .put(body)
                .build();

        mOkHttpClient.newCall(request).enqueue(this);
        Log.d("HttpHelper","post to: " + url);
    }

    /**
     * POST通信開始
     */
    public void delete(String url, String json) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("token", WeatherBerryPreference.getToken(mContext) == null ? Urls.DEFAULT_TOKEN : WeatherBerryPreference.getToken(mContext))
                .delete()
                .build();

        mOkHttpClient.newCall(request).enqueue(this);
        Log.d("HttpHelper","post to: " + url);
    }

    /**
     * Http通信成功
     */
    @Override
    public void onResponse(Call call, Response response) {
        Log.d("HttpHelper","response_code: " + response.code());
        boolean isCallbackFin = false;
        if (response.code() == 200 || response.code() == 400) {
            try {
                String result = response.body().string();
                Log.d("HttpHelper","result: " + result);
                if (result != null) {
                    Gson gson = new Gson();
                    JsonObject jsonObject = gson.fromJson(result, JsonObject.class);
                    if (mListener != null) {
                        mListener.onCompletion(jsonObject,response.code());
                        isCallbackFin = true;
                    }
                }
            } catch (Exception e) {
                mListener.onCompletion(null,response.code());
                e.printStackTrace();
            }
        }
        if (!isCallbackFin && mListener != null) {
            Log.e("RESPONSE CODE",response.code()+"");
            mListener.onCompletion(null,response.code());
        }
        mListener = null;
    }

    /*
     * Http通信失敗
     */
    @Override
    public void onFailure(Call call, IOException e) {
        Log.d("HttpHelper","request failure");
        if (mListener != null) {
            mListener.onCompletion(null,404);
        }
        mListener = null;
    }

}