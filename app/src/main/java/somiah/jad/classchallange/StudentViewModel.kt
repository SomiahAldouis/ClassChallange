package somiah.jad.classchallange

import androidx.lifecycle.ViewModel

class StudentViewModel: ViewModel() {

    val students = mutableListOf<Student>()
    init {
        for (i in 0 until 20) {
            val student = Student()
            student.studentName = "Somiah Aldouis $i"
            student.studentNumber = i
            student.studentResult = if (i%2==0){
                true
            }else{
                false
            }

            students += student
        }


    }

    fun addStudent(student: Student) {
        val studentIn = Student()

        studentIn.studentName = student.studentName
        studentIn.studentNumber = student.studentNumber
        studentIn.studentResult = student.studentResult

    }
}