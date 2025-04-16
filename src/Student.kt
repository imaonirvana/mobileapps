class Student(name: String, age: Int = 0, grades: List<Int> = emptyList()) {
    var name: String = name.trim().replaceFirstChar { it.uppercaseChar() }
        private set

    var age: Int = age
        set(value) {
            if (value >= 0) field = value
        }

    var grades: List<Int> = grades
        private set

    val isAdult: Boolean
        get() = age >= 18

    val status: String by lazy { if (isAdult) "Adult" else "Minor" }

    fun getAverage(): Double = if (grades.isNotEmpty()) grades.average() else 0.0

    /**
     * Застосовує операцію до кожної оцінки.
     */
    fun processGrades(operation: (Int) -> Int) {
        grades = grades.map(operation)
    }

    /**
     * Оновлює оцінки новим списком.
     */
    fun updateGrades(newGrades: List<Int>) {
        grades = newGrades
    }

    /**
     * Перевантаження оператора додавання: об'єднує оцінки двох студентів.
     */
    operator fun plus(other: Student): List<Int> = grades + other.grades

    /**
     * Перевантаження оператора множення: множить кожну оцінку на вказаний коефіцієнт.
     * Повертає поточний екземпляр після оновлення оцінок.
     */
    operator fun times(multiplier: Int): Student {
        grades = grades.map { it * multiplier }
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Student) return false
        return this.name == other.name && this.getAverage() == other.getAverage()
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + getAverage().hashCode()
    }

    override fun toString(): String {
        return "Student(name='$name', age=$age, average=${"%.2f".format(getAverage())})"
    }
}
