package kolskypavel.ardfmanager.backend.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RewriteQueriesToDropUnusedColumns
import androidx.room.Transaction
import androidx.room.Upsert
import kolskypavel.ardfmanager.backend.room.entitity.Competitor
import kolskypavel.ardfmanager.backend.room.entitity.embeddeds.CompetitorData
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface CompetitorDao {
    @Query("SELECT * FROM competitor WHERE event_id=(:eventId)")
    fun getCompetitorFlowByEvent(eventId: UUID): Flow<List<Competitor>>

    @Query("SELECT * FROM competitor WHERE event_id=(:eventId) ")
    @Transaction
    @RewriteQueriesToDropUnusedColumns
    fun getCompetitorDataFlow(eventId: UUID): Flow<List<CompetitorData>>

    @Query("SELECT * FROM competitor WHERE event_id=(:eventId) ")
    @Transaction
    @RewriteQueriesToDropUnusedColumns
    suspend fun getCompetitorData(eventId: UUID): List<CompetitorData>

    @Query("SELECT * FROM competitor WHERE id=(:id) LIMIT 1")
    suspend fun getCompetitor(id: UUID): Competitor

    @Query("SELECT * FROM competitor WHERE si_number=(:siNumber) AND event_id = (:eventId) LIMIT 1")
    suspend fun getCompetitorBySINumber(siNumber: Int, eventId: UUID): Competitor?

    @Query("SELECT start_number FROM competitor WHERE event_id=(:eventId) ORDER BY start_number DESC LIMIT 1 ")
    suspend fun getHighestStartNumberByEvent(eventId: UUID): Int

    @Query("SELECT * FROM competitor WHERE category_id=(:categoryId)")
    fun getCompetitorsByCategory(categoryId: UUID): List<Competitor>

    @Query("SELECT COUNT(*) FROM competitor WHERE si_number=(:siNumber) AND event_id =(:eventId)  LIMIT 1")
    suspend fun checkIfSINumberExists(siNumber: Int, eventId: UUID): Int

    @Query("SELECT COUNT(*) FROM competitor WHERE start_number=(:startNumber) AND event_id =(:eventId)  LIMIT 1")
    suspend fun checkIfStartNumberExists(startNumber: Int, eventId: UUID): Int

    @Upsert(entity = Competitor::class)
    fun createCompetitor(competitor: Competitor)

    @Query("DELETE FROM competitor WHERE id =(:id)")
    suspend fun deleteCompetitor(id: UUID)

    @Query("DELETE FROM competitor WHERE event_id =(:eventId)")
    suspend fun deleteAllCompetitors(eventId: UUID)
}