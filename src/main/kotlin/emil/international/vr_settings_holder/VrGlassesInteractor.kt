package emil.international.vr_settings_holder

import emil.international.PoiModel
import emil.international.adminka.Adminka

interface VrGlassesInteractor {

}

class VrGlassesInteractorImpl(
    private val adminka: Adminka,
) : VrGlassesInteractor {

    fun poiList(): List<PoiModel> {
        return adminka.getPoiList()
    }
}