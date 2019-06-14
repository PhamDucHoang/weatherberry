package bk.sulerhy.weatherberry.utils;

/**
 * Created by user01 on 2018/04/09.
 */

public class Urls {
    public static final String DEFAULT_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJKT0tFUiI6IlQyNEFtdmtraC9UT3pvRTF3Tmh1V0plS2k3Y2pRL2I0L3VlQW0rSHFUWkxkK3NKM0lETHBEcnlxUDBVd0tmcklOWXR3c2VxYmxBZDdJTkxHWHdER0cyRnVDcTk5KzlxTFp2NEZERmQyTHA2TEtTVW55UnZUTU4rQ3dFbkU1V3J4RjZiNTBOQkpCa2RYdnY5ZmJGalA2VHVhY1lMeGFtTGJsa1N4aHNZWHRnMD0ifQ.3DJxrx2CEkyhmk1RBthdngvmg0kNQdQ8Qmp1dkjUEulSq8WPOSHuXG3ApfwpW2g55agtWT4ZPYew0ZwUHvd0Ug";

    public final static String ROOT_URL = "http://54.254.175.214:80/whigoo";

    public final static String LOGIN = ROOT_URL + "/user/login?nickname={0}&password={1}&login_type={2}";

    public final static String GET_PASSWORD_RESET = ROOT_URL + "/user/resend_password?email={0}";

    public final static String POST_PASSWORD_SET_NEW_PW = ROOT_URL + "/user/new_password";

    public final static String POST_ADD_USER = ROOT_URL + "/user/add";

    public final static String GET_CHECK_SOCIAL_USER = ROOT_URL + "/user/social_account_check?socialId={0}&type={1}";

    public final static String POST_ADD_SOCIAL_USER = ROOT_URL + "/user/add_social_account";

    public final static String GET_TIMELINE = ROOT_URL + "/timeline/get_timeline?page={0}";

    public final static String GET_NEWPOST = ROOT_URL + "/timeline/get_newest_post?page={0}";

    public final static String POST_VOTE_POST = ROOT_URL + "/post/vote?post_id={0}&action={1}&vote_item={2}";

    public final static String POST_SHARE_POST = ROOT_URL + "/post/repost?post_id={0}&action={1}";

    public final static String POST_MUTE_USER = ROOT_URL + "/user/mute_action/?mute_to={0}&action={1}";

    public final static String POST_BLOCK_USER = ROOT_URL + "/user/block_action/?block_to={0}&action={1}";

    public final static String POST_REPORT_POST = ROOT_URL + "/post/report";

    public final static String GET_GET_REPORT_POST_ITEM = ROOT_URL + "/report/get_report_items";

    public final static String GET_POST_BY_CATEGORY = ROOT_URL + "/timeline/get_post_by_category?page={0}&category_id={1}";

    public final static String POST_CATEGORY_FAVORITE = ROOT_URL + "/category/favorite?category_id={0}&action={1}";

    public final static String POST_CATEGORY_FAVORITE_LIST = ROOT_URL + "/category/favorite_multi";

    public final static String GET_USER_CATEGORY = ROOT_URL + "/category/user_category_data";

    public final static String POST_FOLLOW = ROOT_URL + "/user/follow_action/?follow_to={0}&action={1}";

    public final static String GET_GET_VOTED_USERS = ROOT_URL + "/post/voted_user_list?post_id={0}&voted_item={1}";

    public final static String GET_VOTED_USER = ROOT_URL + "/search/search_voted_user?post_id={0}&voted_item={1}&keyword={2}";

    public final static String POST_ADD_NEW_POST = ROOT_URL + "/post/add";

    public final static String GET_ALL_CATEGORIES = ROOT_URL + "/category/all";

    public final static String GET_GET_USER_INFO = ROOT_URL + "/user/get_full_user_info";

    public final static String POST_GET_USERS_VOTED_POST = ROOT_URL + "/user/get_voted_post";

    public final static String POST_GET_POST = ROOT_URL + "/user/get_post";

    public final static String GET_STATISTIC_BY_POST = ROOT_URL + "/post/post_stats?post_id={0}&item={1}";

    public final static String GET_VOTE_RANKING_LIST = ROOT_URL + "/search/vote_rank";

    public final static String GET_HISTORY = ROOT_URL + "/search/get_search_history";

    public final static String POST_DELETE_HISTORY = ROOT_URL + "/search/delete_history";

    public final static String GET_SEARCH_BY_KEYWORD = ROOT_URL + "/search";

    public final static String GET_NOTIFICATION = ROOT_URL + "/user/get_notification?page={0}";

    public final static String GET_USER_PROFILE = ROOT_URL + "/user/my_profile";

    public final static String GET_ANOTHER_PROFILE = ROOT_URL + "/user/profile?user_id={0}";

    public final static String GET_FOLLOW_USERS_BY_ID = ROOT_URL + "/user/get_user_follow?user_id={0}";

    public final static String GET_FOLLOWERS_BY_ID = ROOT_URL + "/user/get_user_follower?user_id={0}";

    public final static String GET_SEARCH_FOLLOW_BY_ID = ROOT_URL + "/user/search_user_follow?user_id={0}&keyword={1}";

    public final static String GET_SEARCH_FOLLOWERS_BY_ID = ROOT_URL + "/user/search_user_follower?user_id={0}&keyword={1}";

    public final static String GET_POST_VOTE_DETAIL = ROOT_URL + "/user/get_stats";

    public final static String POST_PIN_TOP = ROOT_URL + "/user/pin_to_top/?post_id={0}&action={1}";

    public final static String PUT_UPDATE_EMAIL = ROOT_URL + "/user/update_email";

    public final static String GET_MUTE_USER_LIST = ROOT_URL + "/user/get_mute_list";

    public final static String GET_USER_UPDATE = ROOT_URL + "/user/update_user";

    public final static String PUT_USER_UPDATE = ROOT_URL + "/user/update_user";

    public final static String GET_BLOCK_USER_LIST = ROOT_URL + "/user/block_list";

    public final static String GET_IMAGE_BY_LINK = ROOT_URL + "/file/get_image?path={0}";

    public final static String GET_MY_POST = ROOT_URL + "/user/get_post?page={0}";

    public final static String GET_MY_VOTED_POST = ROOT_URL + "/user/get_voted_post?page={0}";

    public final static String GET_ANOTHER_POST = ROOT_URL + "/user/get_user_post?user_id={0}&page={1}";

    public final static String GET_ANOTHER_VOTED_POST = ROOT_URL + "/user/get_user_voted_post?user_id={0}&page={1}";

    public final static String POST_PROFILE_PIC = ROOT_URL + "/user/upload_avatar";

    public final static String POST_DELETE_USER = ROOT_URL + "/user/delete";

    public final static String POST_DELETE_POST = ROOT_URL + "/post/delete?post_id={0}";

    public final static String GET_SEARCH_POST= ROOT_URL +"/search/post?keyword={0}&page={1}&start_time={2}";

    public final static String GET_SEARCH_USER= ROOT_URL +"/search/user?keyword={0}&page={1}&start_time={2}";

}
