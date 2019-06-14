package bk.sulerhy.weatherberry.utils;

/**
 * Created by user01 on 1/28/19.
 */

public interface ActionCompleteContract {
    void onViewMoved(int oldPosition, int newPosition);
    void onViewSwiped(int position);
}
