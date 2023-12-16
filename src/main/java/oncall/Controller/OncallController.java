package oncall.Controller;

import oncall.Model.MonthDay;
import oncall.Model.WorkerList;
import oncall.View.InputView;

public class OncallController {
    private MonthDay monthDay;
    private WorkerList weekdayWorkerList;
    private WorkerList weekendWorkerList;

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
                weekdayWorkerList = new WorkerList(input);

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
                weekendWorkerList = new WorkerList(input);

                successFlag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
