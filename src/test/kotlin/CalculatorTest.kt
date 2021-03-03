import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" "])
    fun `null 또는 공백일 경우`(input: String?) {
        assertThatIllegalArgumentException().isThrownBy { Calculator().calculate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["test", "+2", "2+", "2++", "2+-1", "2//3", "4+2+", "+4+3"])
    fun `정상적인 식이 아닐 경우`(input: String?) {
        assertThatIllegalArgumentException().isThrownBy { Calculator().calculate(input) }
    }

    @Test
    fun `덧셈`() {
        assertThat(Calculator().calculate("2+3")).isEqualTo(5)
    }
}
