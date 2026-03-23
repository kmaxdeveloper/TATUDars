package uz.kmax.tatudars.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.kmax.tatudars.R
import uz.kmax.tatudars.domain.model.Student

class StudentAdapter(
    private val onDelete: (Student) -> Unit
) : ListAdapter<Student, StudentAdapter.ViewHolder>(DiffCallback) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvGroup: TextView = view.findViewById(R.id.tvGroup)
        val tvGrade: TextView = view.findViewById(R.id.tvGrade)
        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = getItem(position)
        holder.tvName.text  = "${student.firstName} ${student.lastName}"
        holder.tvGroup.text = "Guruh: ${student.group}"
        holder.tvGrade.text = "Baho: ${student.grade}"
        holder.btnDelete.setOnClickListener { onDelete(student) }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(old: Student, new: Student) = old.id == new.id
        override fun areContentsTheSame(old: Student, new: Student) = old == new
    }
}