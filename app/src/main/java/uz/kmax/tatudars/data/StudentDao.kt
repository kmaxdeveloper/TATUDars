package uz.kmax.tatudars.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.kmax.tatudars.domain.model.Student

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: Student)

    @Query("SELECT * FROM students ORDER BY id DESC")
    fun getAll(): Flow<List<Student>>

    @Delete
    suspend fun delete(student: Student)
}
