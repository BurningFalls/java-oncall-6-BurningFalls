package oncall.Controller;

import oncall.Model.MonthDay;
import oncall.Model.Workers;
import oncall.View.InputView;

public class OncallController {
    private MonthDay monthDay;
    private Workers weekdayWorkers;
    private Workers weekendWorkers;

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


}
