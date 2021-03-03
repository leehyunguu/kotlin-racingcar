class Calculator {
    fun calculate(input: String?): Long {
        validate(input)

        return execute(input!!)
    }

    private fun execute(input: String): Long {
        val operators = splitExpression(input, OPERATOR_REGEX)
        val digits = splitExpression(input, DIGIT_REGEX).map { it.toInt() }
        return 0
    }

    private fun splitExpression(input: String, operatorRegex: Regex): List<String> {
        return input.split(operatorRegex).map { it.trim() }
    }

    private fun validate(input: String?) {
        if (input.isNullOrBlank() || !INPUT_REGEX.matches(input)) throw IllegalArgumentException()
    }

    companion object {
        private val OPERATOR_REGEX = "[+\\-*/]".toRegex()
        private val DIGIT_REGEX = "[\\d+]".toRegex()
        private val INPUT_REGEX = "(\\d[+\\-*/])+\\d".toRegex()
    }
}
