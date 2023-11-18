package runflow

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

object KotlinHttpService {
    @JvmStatic
    fun Application.helloModule() {
        routing {
            get("/hello") {
                call.respondText("Hello!")
            }
        }
    }
}
