package somiah.jad.classchallange

import java.util.*

data class Student(val studentId: UUID = UUID.randomUUID(),
                   var studentName: String = "",
                   var studentNumber: Int = 0 ,
                   var studentResult: Boolean = true)
