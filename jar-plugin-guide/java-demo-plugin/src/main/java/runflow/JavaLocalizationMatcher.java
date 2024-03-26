package runflow;

import org.jetbrains.annotations.NotNull;
import top.myrest.myflow.language.LocalizationMatchResult;
import top.myrest.myflow.language.LocalizationMatcher;
import top.myrest.myflow.language.LocalizedMatching;

public class JavaLocalizationMatcher implements LocalizationMatcher {

    @Override
    public boolean isSupport(@NotNull String content) {
        return false;
    }

    @NotNull
    @Override
    public LocalizationMatchResult match(@NotNull String keyword, @NotNull String content) {
        return LocalizedMatching.INSTANCE.getNotMatched();
    }
}
