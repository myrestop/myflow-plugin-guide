package runflow;

import org.jetbrains.annotations.NotNull;
import top.myrest.myflow.action.ActionPlaceholderUpdater;

public class JavaPlaceholder extends ActionPlaceholderUpdater {

    @Override
    public boolean isScheduleUpdater() {
        return true;
    }

    @NotNull
    @Override
    public String getPlaceholderValue() {
        return "";
    }
}
