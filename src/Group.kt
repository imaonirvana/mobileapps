class Group(private val students: List<Student>) {

    constructor(vararg students: Student) : this(students.toList())

    operator fun get(index: Int): Student? = students.getOrNull(index)

    fun getTopStudent(): Student? = students.maxByOrNull { it.getAverage() }

    /**
     * Додає нового студента до групи, повертаючи оновлену групу.
     */
    fun addStudent(student: Student): Group = Group(students + student)
}
