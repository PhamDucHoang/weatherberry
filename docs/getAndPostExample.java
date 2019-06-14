GET SAMPLE
HttpHelper mHttpHelper = new HttpHelper(mainActivity, new HttpListener() {
    @Override
    public void onCompletion(JsonObject result, int responseCode) {
        if (result != null) {
            try {
                Gson gson = new Gson();
                LoginData loginData = gson.fromJson(result.get("resultData"), LoginData.class);
                if (loginData.token != null) {
                    //add some code here

                } else {
                    //error dialog
                    mainActivity.showConFirmDialog("メール及びパスワードが間違います。", null);
                }
            } catch (Exception e) {
                //error dialog
        e.printStackTrace();
                mainActivity.showConFirmDialog("システムエラーが発生しました。", null);
            }
        } else {
            //network error dialog
            mainActivity.showConFirmDialog("通信エラーが発生しました。", null);
        }
    }
});
mHttpHelper.get(MessageFormat.format(Urls.LOGIN, nickname.getText().toString(), password.getText().toString(), 1));





POST SAMPLE
final Gson gson = new Gson();
mHttpHelper = new HttpHelper(mainActivity, new HttpListener() {
    @Override
    public void onCompletion(JsonObject result,int responseCode) {
        if (result != null) {
            try {
                VoteResultData voteResultData = gson.fromJson(result.get("resultData"), VoteResultData.class);
                if (responseCode==200) {
                    // do something
                } else {
                    //error dialog
                    mainActivity.showConFirmDialog("エラーが発生しました", null);
                }
            } catch (Exception e) {
                //error dialog
        e.printStackTrace();
                mainActivity.showConFirmDialog("システムエラーが発生しました。", null);
            }
        } else {
            //network error dialog
            mainActivity.showConFirmDialog("通信エラーが発生しました。", null);
        }
    }
});
mHttpHelper.post(MessageFormat.format(Urls.POST_VOTE_POST, postId, action,voteItem),"");



SHORT POST (NO BODY)
HttpHelper mHttpHelper = new HttpHelper(mainActivity, new HttpListener() {
    @Override
    public void onCompletion(JsonObject result, int responseCode) {
        if (result != null) {
            if (responseCode==200) {
                // do something
            } else {
                //error dialog
                mainActivity.showConFirmDialog("エラーが発生しました。", null);
            }
        } else {
            //network error dialog
            mainActivity.showConFirmDialog("通信エラーが発生しました。", null);
        }
    }
});
mHttpHelper.post(MessageFormat.format(Urls.POST_MUTE_USER, userID, action),"");
notifyDataSetChanged();




Handler


Handler handler = new Handler(Looper.getMainLooper());
handler.post(new Runnable() {
    @Override
    public void run() {
    }
});
