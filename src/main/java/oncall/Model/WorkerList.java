package oncall.Model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WorkerList {
    private List<String> workerList;

    public WorkerList(String input) {
        isValidInput(input);
        List<String> workerList = parseWithComma(input);
        validate(workerList);

        this.workerList = workerList;
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

    public void validate(List<String> workerList) {
        isCount5to35(workerList);
        isNameUnder5Char(workerList);
    }

    public void isCount5to35(List<String> workerList) {
        if (workerList.size() < 5 || workerList.size() > 35) {
            throw new IllegalArgumentException("[ERROR] 근무자는 5명 이상 35명 이하여야 합니다.");
        }
    }

    public void isNameUnder5Char(List<String> workerList) {
        for (int i = 0; i < workerList.size(); i++) {
            String name = workerList.get(i);
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 근무자의 이름은 5자 이하여야 합니다.");
            }
        }
    }

}
