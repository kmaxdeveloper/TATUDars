package uz.kmax.tatudars.data.room.instance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.kmax.tatudars.data.room.dao.ContactDao
import uz.kmax.tatudars.domain.retrofit.Contact

@Database(
    entities = [
        Contact::class    // hozir faqat shu
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    // Har bir Dao shu yerda ro'yxatlanadi
    abstract fun contactDao(): ContactDao
    // abstract fun productDao(): ProductDao  ← keyinroq
    // abstract fun orderDao(): OrderDao      ← keyinroq

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}