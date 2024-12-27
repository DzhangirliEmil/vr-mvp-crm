package emil.international

import emil.international.adminka.Adminka
import emil.international.vr_settings_holder.VrGlassesInteractorsHolder
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val adminka = Adminka(this)
    val settingsHolder = VrGlassesInteractorsHolder(adminka)


    configureSerialization()
    configureFrameworks()
    configureSockets()

    configureRouting(settingsHolder)
}
