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
//        List<String> workerList = parseWithComma(input);
//        validate(workerList);
//
//        this.workerList = workerList;
    }

    public void isValidInput(String input) {
        String regex = "^[^,]+(,[^,]+)*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 문자열의 형태가 유효하지 않습니다.");
        }
    }

//    public List<String> parseWithComma(String input) {
//        return Arrays.stream(input.split(","))
//                .map(String::trim)
//                .filter(str -> !str.isEmpty())
//                // .map(Integer::parseInt)
//                .collect(Collectors.toList());
//    }
}
