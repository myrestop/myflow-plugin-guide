package runflow;

import java.util.Collections;
import java.util.List;
import cn.hutool.core.util.CharsetUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.myrest.myflow.action.ActionResultCallback;
import top.myrest.myflow.action.ActionResultCallbackExtension;
import top.myrest.myflow.enumeration.ActionWindowBehavior;
import top.myrest.myflow.enumeration.SortOrder;

public class JavaExtension implements ActionResultCallbackExtension {

    @Override
    public boolean isSupport(@Nullable Object sourceResult, @Nullable Object finalResult) {
        return finalResult != null && finalResult instanceof String && ((String) finalResult).startsWith("😃");
    }

    @NotNull
    @Override
    public List<ActionResultCallback> getExtendedCallbacks(@Nullable Object sourceResult, @Nullable Object finalResult) {
        Function1<Object, Unit> customizedCallback = e -> {
            System.out.println(new String(e.toString().getBytes(CharsetUtil.CHARSET_UTF_8), CharsetUtil.defaultCharset()));
            return Unit.INSTANCE;
        };
        return List.of(new ActionResultCallback(null, "Print", null, Collections.emptyList(), null, customizedCallback, SortOrder.NONE, ActionWindowBehavior.EMPTY_LIST, true));
    }
}
