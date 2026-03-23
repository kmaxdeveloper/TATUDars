package uz.kmax.tatudars.presentation.fragment.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import uz.kmax.base.extension.onFragmentBackPressed
import uz.kmax.base.fragment.BaseFragmentWC
import uz.kmax.tatudars.R
import uz.kmax.tatudars.databinding.FragmentAddBinding
import uz.kmax.tatudars.databinding.FragmentAddContactBinding
import uz.kmax.tatudars.presentation.viewModel.StudentViewModel

class AddFragment : BaseFragmentWC<FragmentAddBinding>(FragmentAddBinding::inflate) {

    private val viewModel: StudentViewModel by activityViewModels()

    override fun onViewCreated() {

        binding.btnSave.setOnClickListener {
            val firstName = binding.etFirstName.text.toString().trim()
            val lastName  = binding.etLastName.text.toString().trim()
            val group     = binding.etGroup.text.toString().trim()
            val gradeText = binding.etGrade.text.toString().trim()

            // Validatsiya
            if (firstName.isEmpty() || lastName.isEmpty() || group.isEmpty() || gradeText.isEmpty()) {
                Toast.makeText(requireContext(), "Barcha maydonlarni to'ldiring!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val grade = gradeText.toFloatOrNull()
            if (grade == null || grade < 0f || grade > 100f) {
                Toast.makeText(requireContext(), "Baho 0-100 oralig'ida bo'lishi kerak!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ViewModel orqali saqlash
            viewModel.addStudent(firstName, lastName, group, grade)
            Toast.makeText(requireContext(), "$firstName saqlandi!", Toast.LENGTH_SHORT).show()

            // ListFragment ga qaytish
            back()
        }

        binding.btnCancel.setOnClickListener {
            onFragmentBackPressed {
                back()
            }
        }
    }
}
