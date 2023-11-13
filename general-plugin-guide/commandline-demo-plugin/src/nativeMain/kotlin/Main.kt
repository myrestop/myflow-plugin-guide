import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.addJsonObject
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonArray

@OptIn(ExperimentalEncodingApi::class, ExperimentalForeignApi::class)
fun main(args: Array<String>) {
    val base64 = args.first()
    val json = Base64.decode(base64).toKString()
    val request = Json.parseToJsonElement(json)
    when (request.jsonObject["method"]?.jsonPrimitive?.content) {
        "BEFORE_PLUGIN_LOAD" -> println("RUNNING")
        "PLACEHOLDER" -> println("a commandline placeholder")
        "ACTION_CALLBACK" -> println(json)
        "QUERY_ACTION" -> {
            val len = request.jsonObject["body"]?.jsonObject?.get("args")?.jsonArray?.sumOf { it.jsonObject["strValue"]?.jsonPrimitive?.content?.length ?: 0 } ?: 0
            println(
                Json.encodeToString(
                    buildJsonArray {
                        addJsonObject {
                            put("actionId", "emoji")
                            putJsonArray("title") {
                                addJsonObject {
                                    put("value", "^_^".repeat(len))
                                    put("type", "PLAIN_TITLE")
                                }
                            }
                            putJsonArray("callbacks") {
                                addJsonObject {
                                    put("actionCallback", "action callback")
                                }
                            }
                        }
                    },
                ),
            )
        }

        else -> {}
    }
}
