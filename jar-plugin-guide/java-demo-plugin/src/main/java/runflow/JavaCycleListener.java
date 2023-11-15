package runflow;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.myrest.myflow.enumeration.PluginState;
import top.myrest.myflow.plugin.PluginCycleListener;

public class JavaCycleListener implements PluginCycleListener {

    @Override
    public void afterLoaded(@NotNull String s) {

    }

    @Override
    public void beforeAppExit() {

    }

    @Nullable
    @Override
    public PluginState beforeLoad(@NotNull String s) {
        return null;
    }

    @Override
    public void onPluginDisable() {

    }

    @Override
    public void onPluginRun() {

    }

    @Override
    public void onPluginStop() {

    }

    @Override
    public void onPluginUninstall(boolean b) {

    }
}
