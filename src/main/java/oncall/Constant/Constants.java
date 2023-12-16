package oncall.Constant;

import java.util.List;

public class Constants {
    public static final int WEEKDAY = 0;
    public static final int WEEKDAY_HOLIDAY = 1;
    public static final int WEEKEND = 2;
    public static final List<String> DAYLIST = List.of(
            "월", "화", "수", "목", "금", "토", "일"
    );
    public static final List<Integer> MONTH_COUNT = List.of(
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    );
}
