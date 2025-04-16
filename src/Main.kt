import kotlinx.coroutines.*

suspend fun fetchGradesFromServer(): List<Int> {
    delay(2000)
    return listOf(95, 87, 90, 100, 78)
}

fun main() = runBlocking {
    // Асинхронне оновлення оцінок для студента asyncio
    val studentasyncio = Student("asyncio")
    val grades = fetchGradesFromServer()
    studentasyncio.updateGrades(grades)

    // Створення інших студентів
    val studentOne = Student("StudentOne")
    val studentTwo = Student("StudentTwo")

    studentOne.updateGrades(listOf(89, 90, 95))
    studentTwo.updateGrades(listOf(60, 75, 89))

    // Перевантаження оператора +
    val combinedGrades = studentOne + studentTwo
    println("Combined grades: $combinedGrades")

    // Перевантаження оператора *
    val boostedStudent = studentTwo * 2
    println("Boosted student: $boostedStudent")

    // Порівняння студентів (equals використовується)
    println("studentOne == studentTwo: ${ studentOne == studentTwo }")

    // Використання lazy властивості status
    println("Status of studentOne: ${studentOne.status}")

    // Демонстрація використання групи студентів
    val group = Group(studentasyncio, studentOne, studentTwo)
    val topStudent = group.getTopStudent()
    println("Top student in group: $topStudent")
}
