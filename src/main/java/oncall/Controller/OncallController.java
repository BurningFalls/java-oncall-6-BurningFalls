package oncall.Controller;

import oncall.Model.MonthDay;
import oncall.View.InputView;

public class OncallController {
    private MonthDay monthDay;

    public void startOnCall() {
        receiveMonthDay();
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
}
