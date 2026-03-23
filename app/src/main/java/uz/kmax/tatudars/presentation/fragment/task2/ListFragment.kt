package uz.kmax.tatudars.presentation.fragment.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.kmax.base.fragment.BaseFragmentWC
import uz.kmax.tatudars.R
import uz.kmax.tatudars.data.adapter.StudentAdapter
import uz.kmax.tatudars.databinding.FragmentListBinding
import uz.kmax.tatudars.presentation.viewModel.StudentViewModel

class ListFragment : BaseFragmentWC<FragmentListBinding>(FragmentListBinding::inflate) {


    // activityViewModels — ViewModel ni Activity bilan ulashadi (AddFragment ham ishlata oladi)
    private val viewModel: StudentViewModel by activityViewModels()

    override fun onViewCreated() {

        // Adapter
        val adapter = StudentAdapter { student ->
            viewModel.deleteStudent(student)
            Toast.makeText(requireContext(), "${student.firstName} o'chirildi", Toast.LENGTH_SHORT)
                .show()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Talabalar ro'yxatini kuzatish
        viewModel.allStudents.observe(viewLifecycleOwner) { students ->
            adapter.submitList(students)
        }

        // FAB bosilganda AddFragment ga o'tish
        binding.fab.setOnClickListener {
            //
        }
    }
}
