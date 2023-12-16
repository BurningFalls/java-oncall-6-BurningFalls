package oncall.Enum;

public enum Holiday {
    FIRST_HOLIDAY(1, 1, "신정"),
    SECOND_HOLIDAY(3, 1, "삼일절"),
    THRID_HOLIDAY(5, 5, "어린이날"),
    FOURTH_HOLIDAY(6, 6, "현충일"),
    FIFTH_HOLIDAY(8, 15, "광복절"),
    SIXTH_HOLIDAY(10, 3, "개천절"),
    SEVENTH_HOLIDAY(10, 9, "한글날"),
    EIGHTH_HOLIDAY(12, 25, "성탄절");

    private int month;
    private int day;
    private String name;

    Holiday(int month, int day, String name) {
        this.month = month;
        this.day = day;
        this.name = name;
    }

    public static boolean isContains(int month, int day) {
        for (Holiday holiday : values()) {
            if (holiday.month == month && holiday.day == day) {
                return true;
            }
        }
        return false;
    }
}
