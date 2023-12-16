package oncall.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MonthDayTest {

    @ValueSource(strings = {",5,월", "5,월,", "5.월", ",5,월,"})
    @ParameterizedTest
    void 입력_형태가_유효하지_않으면_에러(String text) {
        assertThatThrownBy(() -> new MonthDay(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"5", "월", "5,월,일", "5월"})
    @ParameterizedTest
    void 월과_요일이_존재하지_않으면_에러(String text) {
        assertThatThrownBy(() -> new MonthDay(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"월,월", "13,월", "0,월", "one,월"})
    @ParameterizedTest
    void 월이_1부터_12_사이의_숫자가_아니면_에러(String text) {
        assertThatThrownBy(() -> new MonthDay(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"1,1", "1,웕", "1,철수", "1,토요일"})
    @ParameterizedTest
    void 요일이_형식에_맞지_않으면_에러(String text) {
        assertThatThrownBy(() -> new MonthDay(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource({
            "1, false",
            "2, false",
            "3, false",
            "4, false",
            "5, false",
            "6, true",
            "7, true"
    })
    @ParameterizedTest
    void 해당_날짜가_주말인지_확인(int day, boolean expectedFlag) {
        MonthDay monthDay = new MonthDay("1,월");
        boolean actualFlag = monthDay.isWeekend(day);

        assertThat(actualFlag).isEqualTo(expectedFlag);
    }
}
