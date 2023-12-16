package oncall.Model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MonthDay {
    private static final List<String> dayList = List.of(
            "월", "화", "수", "목", "금", "토", "일"
    );
    private int month;
    private String day;

    public MonthDay(String input) {
        isValidInput(input);
        List<String> monthDay = parseWithComma(input);
        validate(monthDay);
    }

    public void isValidInput(String input) {
        String regex = "^[^,]+(,[^,]+)*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 문자열의 형태가 유효하지 않습니다.");
        }
    }

    public List<String> parseWithComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }

    public void validate(List<String> monthDay) {
        isLengthTwo(monthDay);
        String monthString = monthDay.get(0);
        int month = isNumeric(monthString);
        String day = monthDay.get(1);
        isMonth1to12(month);
        isDayValidate(day);

        this.month = month;
        this.day = day;
    }

    public void isLengthTwo(List<String> monthDay) {
        if (monthDay.size() != 2) {
            throw new IllegalArgumentException("[ERROR] 문자열의 형태가 유효하지 않습니다.");
        }
    }

    public int isNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 월 입력값이 숫자가 아닙니다.");
        }
    }

    public void isMonth1to12(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("[ERROR] 월 입력값이 1 이상 12 이하의 숫자가 아닙니다.");
        }
    }

    public void isDayValidate(String day) {
        if (!dayList.contains(day)) {
            throw new IllegalArgumentException("[ERROR] 요일 입력 형식이 잘못되었습니다.");
        }
    }

    public boolean isWeekend(int dayNumber) {
        int index = dayList.indexOf(day);
        index = (index + dayNumber - 1) % 7;
        String nextDay = dayList.get(index);
        if (nextDay.equals("토") || nextDay.equals("일")) {
            return true;
        }
        return false;
    }

    public int getMonth() {
        return month;
    }
}
