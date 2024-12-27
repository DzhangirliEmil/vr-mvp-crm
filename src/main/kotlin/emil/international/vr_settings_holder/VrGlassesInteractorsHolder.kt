package emil.international.vr_settings_holder

import emil.international.adminka.Adminka

class VrGlassesInteractorsHolder(
    adminka: Adminka,
) {
    private val interactorMap = mutableMapOf<String, VrGlassesInteractor>(
        "lol" to VrGlassesInteractorImpl(adminka),
    )

    fun createInteractor(settings: VrGlassesInteractor, id: String) {
        interactorMap[id] = settings
    }

    fun getInteractor(id: String): VrGlassesInteractor? {
        return interactorMap[id]
    }
}