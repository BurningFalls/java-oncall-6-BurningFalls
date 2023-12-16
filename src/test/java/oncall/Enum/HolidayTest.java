package oncall.Enum;

import oncall.Model.Workers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HolidayTest {

    @CsvSource({
            "1, 1, true",
            "10, 8, false",
            "10, 9, true"
    })
    @ParameterizedTest
    void 공휴일인지_테스트(int month, int day, boolean expectedFlag) {
        boolean actualFlag = Holiday.isContains(month, day);

        assertThat(actualFlag).isEqualTo(expectedFlag);
    }
}
