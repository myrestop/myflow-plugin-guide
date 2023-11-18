package runflow;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.myrest.myflow.action.ActionFocusedKeywordHandler;
import top.myrest.myflow.action.ActionFocusedSession;
import top.myrest.myflow.action.ActionResult;
import top.myrest.myflow.component.ActionKeywordPin;
import top.myrest.myflow.component.SettingsContent;
import top.myrest.myflow.enumeration.HotEventType;

public class JavaFocusedActionHandler extends ActionFocusedKeywordHandler {

    @Nullable
    @Override
    public SettingsContent getCustomizeSettingContent() {
        return null;
    }

    @Override
    public boolean isSupportHotEventTrigger() {
        return false;
    }

    @Override
    public void triggerOnHotEvent(@NotNull HotEventType hotEventType) {
        System.out.println("trigger on hot event, if you supported");
    }

    @NotNull
    @Override
    public ActionFocusedSession enterFocusMode(@NotNull ActionKeywordPin pin) {
        return new ActionFocusedSession(pin) {
            @NotNull
            @Override
            public String getLabel() {
                return "customized placeholder";
            }

            @Override
            public void exitFocusMode() {
                // do something while close session
            }

            @NotNull
            @Override
            public List<ActionResult> queryAction(@NotNull String action) {
                // return results like action handler
                return Collections.emptyList();
            }
        };
    }
}
