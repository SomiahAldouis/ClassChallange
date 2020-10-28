package somiah.jad.classchallange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class classFragment : Fragment() {
    private lateinit var classButton: Button
    private val viewModel:StudentViewModel by lazy{
        ViewModelProviders.of(this).get(StudentViewModel::class.java)
    }
    private lateinit var recyclerView: RecyclerView
    private var adapter: Adapter?=null

override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    val view = inflater.inflate(R.layout.fragment_class, container, false)
    recyclerView =
        view.findViewById(R.id.recycler_view) as RecyclerView
    recyclerView.layoutManager = LinearLayoutManager(context)

    updateUI()

    return view
}

    private inner class Holder(view: View)
        : RecyclerView.ViewHolder(view) {

        val studentName : TextView = itemView.findViewById(R.id.student_name)
        val studentNumL: TextView = itemView.findViewById(R.id.student_num)



    }
    private inner class Adapter(var students: List<Student>)
        : RecyclerView.Adapter<Holder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : Holder {
            val view = layoutInflater.inflate(R.layout.item, parent, false)
            return Holder(view)
        }
        override fun getItemCount() = students.size
        override fun onBindViewHolder(holder: Holder, position: Int) {
            val student = students[position]
            holder.apply {
                studentName.text = student.studentName
                studentNumL.text = student.studentNumber.toString()
            }
        }
    }

    private fun updateUI() {
        val students = viewModel.students
        adapter = Adapter(students)
        recyclerView.adapter = adapter
        
    }


    companion object {
        fun newInstance(): classFragment {
            return classFragment()
        }
    }


}