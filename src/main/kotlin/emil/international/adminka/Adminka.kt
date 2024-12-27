package emil.international.adminka

import emil.international.PoiModel
import io.ktor.server.application.*

class Adminka(application: Application) {

    private val poiList = listOf<PoiModel>(
        PoiModel("заголовок", "описание")
    )
    fun getPoiList(): List<PoiModel> {
        return poiList
    }
}
