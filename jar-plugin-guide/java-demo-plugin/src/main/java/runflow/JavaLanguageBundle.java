package runflow;

import top.myrest.myflow.enumeration.LanguageType;

public class JavaLanguageBundle {

    // we will auto-inject
    public static JavaLanguageBundle INSTANCE;

    private LanguageType languageType = LanguageType.EN_US;

    private String someKey = "Some Key";

    private String otherKey = "Other Key";

    public LanguageType getLanguageType() {
        return languageType;
    }

    public JavaLanguageBundle setLanguageType(LanguageType languageType) {
        this.languageType = languageType;
        return this;
    }

    public String getSomeKey() {
        return someKey;
    }

    public JavaLanguageBundle setSomeKey(String someKey) {
        this.someKey = someKey;
        return this;
    }

    public String getOtherKey() {
        return otherKey;
    }

    public JavaLanguageBundle setOtherKey(String otherKey) {
        this.otherKey = otherKey;
        return this;
    }
}