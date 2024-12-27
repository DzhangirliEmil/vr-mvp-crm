package emil.international

import emil.international.adminka.Adminka
import emil.international.vr_settings_holder.VrGlassesInteractor
import emil.international.vr_settings_holder.VrGlassesInteractorsHolder
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    vrGlassesInteractorsHolder: VrGlassesInteractorsHolder,
) {
    routing {
        get("/") {
            val interactor = call.extractInteractor(vrGlassesInteractorsHolder) ?: return@get

            call.respondText("Hello World! with id $id")
        }
    }
}

private suspend fun RoutingCall.extractInteractor(vrGlassesInteractorsHolder: VrGlassesInteractorsHolder): VrGlassesInteractor? {
    val id = queryParameters.get(QueryParametersNames.glassesId)

    if (id == null) {
        respondText("no glasses id")
        return null
    }

    val interactor = vrGlassesInteractorsHolder.getInteractor(id)

    if (interactor == null) {
        respondText("no interactor creator")
        return null
    }

    return interactor
}
