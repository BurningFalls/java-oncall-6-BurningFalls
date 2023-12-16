package oncall.Model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WorkersTest {

    @ValueSource(strings = {",민수", "민수,", ",민수,"})
    @ParameterizedTest
    void 입력_형태가_유효하지_않으면_에러(String text) {
        assertThatThrownBy(() -> new Workers(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"철수", "철수,영희"})
    @ParameterizedTest
    void 길이가_5_미만이면_에러(String text) {
        assertThatThrownBy(() -> new Workers(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"철수철수철수, 빨강, 주황, 노랑, 초록"})
    @ParameterizedTest
    void 이름이_6자_이상이면_에러(String text) {
        assertThatThrownBy(() -> new Workers(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"철수,철수,철수,철수,철수", "철수,영희,영희,빨강,주황"})
    @ParameterizedTest
    void 중복되는_이름이_있으면_에러(String text) {
        assertThatThrownBy(() -> new Workers(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 두_근무_순번의_길이가_다르면_에러() {
        Workers workers1 = new Workers("빨강,주황,노랑,초록,파랑");
        Workers workers2 = new Workers("빨강,주황,노랑,초록,파랑,남색");

        assertThatThrownBy(() -> workers1.isSameLength(workers2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 두_근무_순번의_구성이_다르면_에러() {
        Workers workers1 = new Workers("빨강,주황,노랑,초록,파랑");
        Workers workers2 = new Workers("파랑,노랑,주황,남색,빨강");

        assertThatThrownBy(() -> workers1.isContainsAll(workers2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource({
            "빨강, 주황",
            "노랑, 초록",
            "파랑, 빨강"
    })
    @ParameterizedTest
    void 다음_인덱스_이름_가져오기(String name, String expectedNextName) {
        Workers workers = new Workers("빨강,주황,노랑,초록,파랑");
        String actualNextName = workers.getNextName(name);

        assertThat(actualNextName).isEqualTo(expectedNextName);
    }
}
