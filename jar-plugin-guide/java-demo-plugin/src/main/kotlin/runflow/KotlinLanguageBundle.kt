package runflow

import top.myrest.myflow.enumeration.LanguageType

class KotlinLanguageBundle {

    var languageType = LanguageType.EN_US

    var someKey = "Some Key"

    var otherKey = "Other Key"

    companion object {

        @JvmStatic
        lateinit var INSTANCE: KotlinLanguageBundle
    }
}