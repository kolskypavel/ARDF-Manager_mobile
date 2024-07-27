package kolskypavel.ardfmanager.backend.files.processors

import android.net.Uri
import kolskypavel.ardfmanager.backend.files.constants.DataType
import kolskypavel.ardfmanager.backend.files.wrappers.DataImportWrapper
import kolskypavel.ardfmanager.backend.room.entitity.Race
import kolskypavel.ardfmanager.backend.room.entitity.embeddeds.CategoryData

object JteProcessor : FormatProcessor {

    override fun importData(
        uri: Uri,
        dataType: DataType,
        race: Race,
        categories: List<CategoryData>
    ): DataImportWrapper {
        TODO("Not yet implemented")
    }

    override fun exportData(uri: Uri, dataType: DataType): Boolean {
        TODO("Not yet implemented")
    }
}