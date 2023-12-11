package kolskypavel.ardfmanager.backend.wrappers

import kolskypavel.ardfmanager.backend.room.entitity.Category
import kolskypavel.ardfmanager.backend.room.entitity.Competitor
import kolskypavel.ardfmanager.backend.room.entitity.Readout
import java.io.Serializable

data class ReadoutDataWrapper(
    var readout: Readout,
    var punches: ArrayList<PunchWrapper>,
    var competitor: Competitor?,
    var category: Category?
) : Serializable