package oncall.Controller;

import oncall.Constant.Constants;
import oncall.Enum.Holiday;
import oncall.Model.MonthDay;
import oncall.Model.Workers;
import oncall.View.InputView;
import oncall.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class OncallController {
    private static final List<Integer> monthCount = List.of(
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    );

    private MonthDay monthDay;
    private Workers weekdayWorkers;
    private Workers weekendWorkers;
    private List<Integer> weekList;
    private List<String> workerList;

    public void startOnCall() {
        receiveMonthDay();
        receiveWeekdayWorkers();
        receiveWeekendWorkers();

        makeAndShowWorkerList();
    }

    public void receiveMonthDay() {
        boolean successFlag = false;

        while(!successFlag) {
            try {
                String input = InputView.inputMonthDay();
                monthDay = new MonthDay(input);

                successFlag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void receiveWeekdayWorkers() {
        boolean successFlag = false;

        while(!successFlag) {
            try {
                String input = InputView.inputWeekdayWorkers();
                weekdayWorkers = new Workers(input);

                successFlag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void receiveWeekendWorkers() {
        boolean successFlag = false;

        while(!successFlag) {
            try {
                String input = InputView.inputWeekendWorkers();
                weekendWorkers = new Workers(input);
                isWorkersValidate();

                successFlag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void isWorkersValidate() {
        weekdayWorkers.isSameLength(weekendWorkers);
        weekdayWorkers.isContainsAll(weekendWorkers);
    }

    public void makeAndShowWorkerList() {
        int month = monthDay.getMonth();
        int dayCount = monthCount.get(month - 1);
        weekList = new ArrayList<>();
        weekList.add(0);
        workerList = new ArrayList<>();
        workerList.add("");

        makeWeekList(month, dayCount);
        makeWorkerList(dayCount);
        // isWorkerListValidate();
        OutputView.printWorkerList(monthDay, weekList, workerList);
    }

    public void makeWeekList(int month, int dayCount) {
        for (int i = 1; i <= dayCount; i++) {
            weekList.add(0);
        }

        calculateWeekList(month, dayCount);
    }

    public void calculateWeekList(int month, int dayCount) {
        for (int day = 1; day <= dayCount; day++) {
            boolean isWeekend = monthDay.isWeekend(day);
            boolean isHoliday = Holiday.isContains(month, day);
            if (!isWeekend && isHoliday) {
                weekList.set(day, 1);
            }
            else if (isWeekend) {
                weekList.set(day, 2);
            }
        }
    }

    public void makeWorkerList(int dayCount) {
        int index1 = 0;
        int index2 = 0;
        int length = weekdayWorkers.getSize();
        for (int day = 1; day <= dayCount; day++) {
            String name = "";
            if (weekList.get(day) == Constants.WEEKDAY) {
                name = weekdayWorkers.getWorker(index1);
                index1 = (index1 + 1) % length;
            } else if (weekList.get(day) == Constants.WEEKDAY_HOLIDAY || weekList.get(day) == Constants.WEEKEND) {
                name = weekendWorkers.getWorker(index2);
                index2 = (index2 + 1) % length;
            }
            workerList.add(name);
        }
    }

//    public void isWorkerListValidate() {
//        for (int i = 1; i < workerList.size(); i++) {
//            String prevName = workerList.get(i - 1);
//            String curName = workerList.get(i);
//            if (prevName.equals(curName)) {
//                changePosition(i);
//            }
//        }
//    }

//    public void changePosition(int index) {
//        boolean isWeekday = (weekList.get(index) == Constants.WEEKDAY);
//
//        int nextIndex = getNextIndex(isWeekday, index);
//        if (nextIndex == -1) {
//            String nextName = findNextName(index);
//            workerList.set(index, nextName);
//            return;
//        }
//        String tmp = workerList.get(index);
//        workerList.set(index, workerList.get(nextIndex));
//        workerList.set(nextIndex, tmp);
//    }

    public String findNextName(int index) {
        String name = workerList.get(index);
        boolean isWeekday = (weekList.get(index) == Constants.WEEKDAY);
        if (isWeekday) {
            return weekdayWorkers.getNextName(name);
        }
        return weekendWorkers.getNextName(name);
    }

    public int getNextIndex(boolean isWeekday, int index) {
        int month = monthDay.getMonth();
        int dayCount = monthCount.get(month - 1);
        for (int i = index + 1; i <= dayCount; i++) {
            boolean flag = (weekList.get(i) == Constants.WEEKDAY);
            if (isWeekday == flag) {
                return i;
            }
        }
        return -1;
    }
}
