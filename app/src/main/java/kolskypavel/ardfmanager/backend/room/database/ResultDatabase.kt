package kolskypavel.ardfmanager.backend.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kolskypavel.ardfmanager.backend.room.dao.ResultDao
import kolskypavel.ardfmanager.backend.room.entitity.Result

@Database(entities = [Result::class], version = 1, exportSchema = false)
@TypeConverters(DateTimeTypeConverter::class)
abstract class ResultDatabase : RoomDatabase() {
    abstract fun resultDao(): ResultDao
}