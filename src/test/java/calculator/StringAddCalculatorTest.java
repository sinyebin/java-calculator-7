package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    @DisplayName("숫자 더하기")
    @Test
    void 덧셈() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.sumNumList(Arrays.asList(1, 2));
        assertThat(result).isEqualTo(3);
    }
}
