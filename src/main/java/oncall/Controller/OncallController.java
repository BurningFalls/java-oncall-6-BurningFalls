package oncall.Controller;

import oncall.Model.MonthDay;
import oncall.Model.Workers;
import oncall.View.InputView;

import java.util.List;

public class OncallController {
    private MonthDay monthDay;
    private Workers weekdayWorkers;
    private Workers weekendWorkers;
    private List<Integer> weekList;

    public void startOnCall() {
        receiveMonthDay();
        receiveWeekdayWorkers();
        receiveWeekendWorkers();
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

    public void makeWeekList() {
        List<Integer> monthCount = List.of(
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        );
        int month = monthDay.getMonth();
        int dayCount = monthCount.get(month - 1);

        calculateWeekList(month, dayCount);
    }

    public void calculateWeekList(int month, int dayCount) {

    }
}
