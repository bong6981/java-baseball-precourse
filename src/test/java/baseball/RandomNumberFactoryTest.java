package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberFactoryTest {
    private final int NUMBER_OF_DIGITS = 3;
    private final int NUMBER_NOT_TO_INCLUDE = 0;
    private Set<Integer> numbers;

    @BeforeEach
    void 난수_생성() {
        numbers = RandomNumberFactory.generate();
    }

    @Test
    void 생성된_난수는_3자리() {
        assertThat(numbers).hasSize(NUMBER_OF_DIGITS);
    }

    @Test
    void 생성된_난수는_서로_다른_수로_구성() {
        assertThat(numbers).doesNotContain(NUMBER_NOT_TO_INCLUDE);
        for (int number : numbers) {
            assertThat(numbers).containsOnlyOnce(number);
        }
    }
}
