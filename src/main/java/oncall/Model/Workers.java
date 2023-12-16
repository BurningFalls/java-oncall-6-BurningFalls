package oncall.Model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Workers {
    private List<String> workers;

    public Workers(String input) {
        isValidInput(input);
        List<String> workerList = parseWithComma(input);
        validate(workerList);

        this.workers = workers;
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

    public void validate(List<String> workers) {
        isCount5to35(workers);
        isNameUnder5Char(workers);
        isNameDuplicate(workers);
    }

    public void isCount5to35(List<String> workers) {
        if (workers.size() < 5 || workers.size() > 35) {
            throw new IllegalArgumentException("[ERROR] 근무자는 5명 이상 35명 이하여야 합니다.");
        }
    }

    public void isNameUnder5Char(List<String> workers) {
        for (int i = 0; i < workers.size(); i++) {
            String name = workers.get(i);
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 근무자의 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public void isNameDuplicate(List<String> workers) {
        Set<String> names = new HashSet<>();
        for (String name : workers) {
            if (!names.add(name)) {
                throw new IllegalArgumentException("[ERROR] 중복 닉네임이 존재합니다.");
            }
        }
    }
}
