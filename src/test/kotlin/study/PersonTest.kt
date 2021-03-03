package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "이현규", age = 31, nickname = "이안")
        assertThat(person.name).isEqualTo("이현규")
        assertThat(person.age).isEqualTo(31)
        assertThat(person.nickname).isEqualTo("이안")

        val person2 = Person(nickname = "이안", name = "이현규", age = 31)
        assertThat(person2.name).isEqualTo("이현규")
        assertThat(person2.age).isEqualTo(31)
        assertThat(person2.nickname).isEqualTo("이안")
    }

    @Test
    internal fun `널 타입`() {
        val person = Person("이현규", 31, null)
        assertAll(
            { assertThat(person.name).isEqualTo("이현규") },
            { assertThat(person.age).isEqualTo(31) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person("이현규", 31)
        assertAll(
            { assertThat(person.name).isEqualTo("이현규") },
            { assertThat(person.age).isEqualTo(31) },
            { assertThat(person.nickname).isEqualTo("닉네임 없음") }
        )
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("이현규", 31)
        val person2 = Person("이현규", 31)
        assertThat(person1).isEqualTo(person2)
    }
}
