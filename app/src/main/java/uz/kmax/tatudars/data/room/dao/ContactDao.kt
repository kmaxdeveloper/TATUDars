package uz.kmax.tatudars.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.kmax.tatudars.domain.retrofit.Contact

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts ORDER BY first_name ASC")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getById(id: Int): Contact?

    @Insert
    fun insert(contact: Contact)

    @Update
    fun update(contact: Contact)

    @Delete
    fun delete(contact: Contact)
}