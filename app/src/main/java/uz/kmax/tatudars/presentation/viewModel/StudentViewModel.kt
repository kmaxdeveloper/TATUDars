package uz.kmax.tatudars.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.kmax.tatudars.domain.model.Student
import uz.kmax.tatudars.data.StudentDatabase
import uz.kmax.tatudars.data.StudentRepository

class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: StudentRepository = StudentRepository(
        StudentDatabase.Companion.getDatabase(application).studentDao()
    )

    val allStudents = repository.allStudents.asLiveData()

    fun addStudent(firstName: String, lastName: String, group: String, grade: Float) {
        viewModelScope.launch {
            repository.insert(
                Student(
                    firstName = firstName,
                    lastName = lastName,
                    group = group,
                    grade = grade
                )
            )
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            repository.delete(student)
        }
    }
}