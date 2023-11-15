package runflow;

import org.jetbrains.annotations.NotNull;
import top.myrest.myflow.action.ActionParam;
import top.myrest.myflow.action.ActionRequireArgHandler;
import top.myrest.myflow.action.ActionResult;

import java.util.Collections;
import java.util.List;

public class JavaActionHandler extends ActionRequireArgHandler {

    @NotNull
    @Override
    public List<ActionResult> queryArgAction(@NotNull ActionParam actionParam) {
        return Collections.emptyList();
    }
}
