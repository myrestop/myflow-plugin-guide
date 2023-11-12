package runflow

import java.util.Random
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.serialization.jackson.jackson
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(
        factory = CIO,
        port = 8080,
    ) {
        install(ContentNegotiation) {
            jackson {
                enable(SerializationFeature.INDENT_OUTPUT)
            }
        }
        routing {
            post(path = "/cycle-listener") {
                println(call.receive<String>())
                call.respondText("RUNNING")
            }
            post(path = "/action") {
                val body = call.receive<Map<String, Any>>()
                println(body)
                val method = body["method"] as String
                if (method == "EXECUTED_CALLBACK") {
                    return@post
                }
                val param = body["body"] as Map<String, Any>
                val len = (param["args"] as List<Map<String, String>>).sumOf { it["strValue"]?.length ?: 0 }
                call.respond(
                    listOf(
                        mapOf(
                            "actionId" to "emoji",
                            "title" to listOf(
                                mapOf(
                                    "value" to "😃".repeat(len),
                                    "type" to "PLAIN_TITLE",
                                ),
                            ),
                            "callbacks" to listOf(
                                mapOf(
                                    "actionMethod" to "COPY_RESULT",
                                ),
                            ),
                            "executedCallback" to "callback executed",
                        )
                    )
                )
            }
            post(path = "/placeholder") {
                println(call.receive<String>())
                val list = listOf("😁", "🤣", "😊", "😂", "😢", "😎", "😉", "😜", "😆", "🤔", "🤢", "😃");
                val idx: Int = (System.currentTimeMillis() % list.size).toInt()
                call.respondText(list[idx])
            }
            post(path = "/theme") {
                println(call.receive<String>())
                call.respond(
                    mapOf(
                        "isLight" to true,
                        "primary" to getRandomColor(),
                        "primaryVariant" to getRandomColor(),
                        "secondary" to getRandomColor(),
                        "secondaryVariant" to getRandomColor(),
                        "background" to getRandomColor(),
                        "surface" to getRandomColor(),
                        "error" to getRandomColor(),
                        "onPrimary" to getRandomColor(),
                        "onSecondary" to getRandomColor(),
                        "onBackground" to getRandomColor(),
                        "onSurface" to getRandomColor(),
                        "onError" to getRandomColor(),
                    ),
                )
            }
        }
    }.start(true)
}

private fun getRandomColor(): String {
    val random = Random()
    val red = random.nextInt(255)
    val green = random.nextInt(255)
    val blue = random.nextInt(255)
    return "ff" + red.toString(16) + green.toString(16) + blue.toString(16)
}
