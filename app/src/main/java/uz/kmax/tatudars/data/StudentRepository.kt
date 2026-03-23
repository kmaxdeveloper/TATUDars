package uz.kmax.tatudars.data

import kotlinx.coroutines.flow.Flow
import uz.kmax.tatudars.domain.model.Student

class StudentRepository(private val dao: StudentDao) {

    val allStudents: Flow<List<Student>> = dao.getAll()

    suspend fun insert(student: Student) = dao.insert(student)

    suspend fun delete(student: Student) = dao.delete(student)
}
