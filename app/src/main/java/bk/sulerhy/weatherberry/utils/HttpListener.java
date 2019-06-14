package bk.sulerhy.weatherberry.utils;

import com.google.gson.JsonObject;

/**
 * Httpヘルパーを使った通信のリスナー
 */

public interface HttpListener {
    /**
     * 正常時、異常時合わせて通信が終わった時に呼ばれる。
     * @param result リクエストの結果
     */
    void onCompletion(JsonObject result, int response);
}
