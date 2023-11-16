package runflow;

import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import top.myrest.myflow.action.ActionPlaceholderUpdater;

public class JavaPlaceholder extends ActionPlaceholderUpdater {

    private final List<String> list = Arrays.asList("😃", "🤢", "🤔", "😆", "😜", "😉", "😎", "😢", "😂", "😊", "😁", "😘", "😒", "😍");

    @Override
    public boolean isScheduleUpdater() {
        return true;
    }

    @NotNull
    @Override
    public String getPlaceholderValue() {
        return list.get((int) (System.currentTimeMillis() % list.size()));
    }
}
