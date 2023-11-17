package runflow;

import java.util.List;
import cn.hutool.core.util.CharsetUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import top.myrest.myflow.action.ActionResultCallback;
import top.myrest.myflow.action.ActionResultCallbackExtension;
import top.myrest.myflow.enumeration.ActionWindowBehavior;
import top.myrest.myflow.enumeration.SortOrder;

public class JavaExtension implements ActionResultCallbackExtension {

    @Override
    public boolean isSupport(@NotNull Object result) {
        return result instanceof String && ((String) result).startsWith("😃");
    }

    @NotNull
    @Override
    public List<ActionResultCallback> getExtendedCallbacks(@NotNull Object result) {
        Function1<Object, Unit> customizedCallback = (Function1<Object, Unit>) e -> {
            System.out.println(new String(e.toString().getBytes(CharsetUtil.CHARSET_UTF_8), CharsetUtil.defaultCharset()));
            return Unit.INSTANCE;
        };
        return List.of(new ActionResultCallback(null, "Print", null, null, customizedCallback, SortOrder.NONE, ActionWindowBehavior.EMPTY_LIST, true));
    }
}
