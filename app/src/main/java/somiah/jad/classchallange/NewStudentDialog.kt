package somiah.jad.classchallange

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class NewStudentDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val v = activity?.layoutInflater?.inflate(R.layout.new_student_dialog,null)
        val nameText = v?.findViewById(R.id.name_input) as EditText
        val numberText = v?.findViewById(R.id.number_input) as EditText
        val resultText = v?.findViewById(R.id.result_input) as CheckBox

        return AlertDialog.Builder(requireContext(),R.style.ThemeOverlay_AppCompat_Dialog_Alert)
            .setView(v)
            .setPositiveButton("Add"){ dialog, _ ->
                val s= Student(UUID.randomUUID(),nameText.text.toString(), numberText.text.toString().toInt(),resultText.isChecked)
                targetFragment?.let {
                    (it as Callbacks).onStudentAdd(s)
                }
            }.setNegativeButton("Cancel"){dialog, _ ->
                dialog.cancel()
            }.create()
    }
    interface Callbacks{
        fun onStudentAdd(student: Student)
    }
}