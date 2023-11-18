package runflow;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import top.myrest.myflow.enumeration.LanguageType;
import top.myrest.myflow.language.Translator;

public class JavaTranslator implements Translator {

    @NotNull
    @Override
    public List<LanguageType> getSupportLanguages() {
        // return your supported languages
        return Collections.emptyList();
    }

    @NotNull
    @Override
    public String translate(@NotNull String content, @NotNull LanguageType sourceLanguage, @NotNull LanguageType targetLanguage) {
        // translate content from source language to target language
        return content;
    }
}
