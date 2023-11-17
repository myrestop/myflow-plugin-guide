package runflow;

import java.util.Collections;
import java.util.List;
import cn.hutool.core.util.StrUtil;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.myrest.myflow.action.ActionParam;
import top.myrest.myflow.action.ActionRequireArgHandler;
import top.myrest.myflow.action.ActionResult;
import top.myrest.myflow.action.ActionResultCallback;
import top.myrest.myflow.action.ActionResultTitle;
import top.myrest.myflow.component.SettingsContent;
import top.myrest.myflow.enumeration.ActionArgMode;
import top.myrest.myflow.enumeration.ActionArgType;
import top.myrest.myflow.enumeration.ActionMethod;
import top.myrest.myflow.enumeration.ActionTitleType;
import top.myrest.myflow.enumeration.ActionWindowBehavior;
import top.myrest.myflow.enumeration.HotEventType;
import top.myrest.myflow.enumeration.SortOrder;

public class JavaActionHandler extends ActionRequireArgHandler {

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
    public Pair<ActionArgMode, List<ActionArgType>> getArgRequireMode() {
        return new Pair<>(ActionArgMode.REQUIRE_NOT_EMPTY, Collections.singletonList(ActionArgType.STRING));
    }

    @NotNull
    @Override
    public List<ActionResult> queryArgAction(@NotNull ActionParam actionParam) {
        int len = actionParam.getArgs().stream().mapToInt(e -> e.getStrValue().length()).sum();
        String result = StrUtil.repeat("😃", len);
        List<ActionResultTitle> title = Collections.singletonList(new ActionResultTitle(result, ActionTitleType.PLAIN_TITLE));
        List<ActionResultCallback> callbacks = Collections.singletonList(new ActionResultCallback(null, "", null, ActionMethod.COPY_RESULT, null, SortOrder.NONE, ActionWindowBehavior.HIDE_IF_POSSIBLE, true));
        ActionResult actionResult = new ActionResult("java", "", 100, null, title, "", result, callbacks, null, null, null);
        return Collections.singletonList(actionResult);
    }
}
