package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitterTest {
    @DisplayName("쉼표 또는 콜론으로 구분자 분리")
    @Test
    void 기본구분자_분리() {
        StringSplitter splitter = new StringSplitter();
        String result[] = splitter.split("1,2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("구분자가 없을 경우 예외 발생")
    @Test
    void 구분자_없음_예외_테스트() {
        StringSplitter splitter = new StringSplitter();
        assertThatThrownBy(() -> splitter.split("123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀으로 구분자 분리")
    @Test
    void 커스텀구분자_분리() {
        StringSplitter splitter = new StringSplitter();
        String result[] = splitter.split("//;\n1;2;3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자 존재 숫자가 없을 경우 예외 발생")
    @Test
    void 커스텀_구분자_숫자_없음_예외_테스트() {
        StringSplitter splitter = new StringSplitter();
        assertThatThrownBy(() -> splitter.split("//;\n"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
