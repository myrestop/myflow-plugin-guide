package runflow;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.myrest.myflow.enumeration.PluginState;
import top.myrest.myflow.plugin.PluginCycleListener;

public class JavaCycleListener implements PluginCycleListener {

    @Override
    public void afterLoaded(@NotNull String path) {
        System.out.println("after plugin loaded");
    }

    @Override
    public void beforeAppExit() {
        System.out.println("before app exit");
    }

    @Nullable
    @Override
    public PluginState beforeLoad(@NotNull String path) {
        System.out.println("before load plugin");
        return PluginState.RUNNING;
    }

    @Override
    public void onPluginDisable() {
        System.out.println("plugin disabled");
    }

    @Override
    public void onPluginRun() {
        System.out.println("run plugin");
    }

    @Override
    public void onPluginStop() {
        System.out.println("plugin stopped");
    }

    @Override
    public void onPluginUninstall(boolean shouldDeleteSavedData) {
        System.out.println("prepare to uninstall plugin");
    }
}
