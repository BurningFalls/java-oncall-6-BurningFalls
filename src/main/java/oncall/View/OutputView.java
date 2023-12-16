package oncall.View;

import oncall.Constant.Constants;
import oncall.Model.MonthDay;

import java.util.List;

public class OutputView {

    public static void printWorkerList(MonthDay monthDay, List<Integer> weekList, List<String> workerList) {
        int month = monthDay.getMonth();
        String dayStart = monthDay.getDay();
        int dayIndex = Constants.DAYLIST.indexOf(dayStart);

        for (int day = 1; day < workerList.size(); day++) {
            String realDay = Constants.DAYLIST.get(dayIndex);
            dayIndex = (dayIndex + 1) % 7;
            System.out.print(month + "월 " + day + "일 " + realDay);
            if (weekList.get(day) == Constants.WEEKDAY_HOLIDAY) {
                System.out.print("(휴일)");
            }
            System.out.println(" " + workerList.get(day));
        }
    }
}
