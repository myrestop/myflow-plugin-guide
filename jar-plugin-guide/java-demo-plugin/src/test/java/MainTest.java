import top.myrest.myflow.AppInfo;
import top.myrest.myflow.action.Actions;
import top.myrest.myflow.baseimpl.AppKt;
import top.myrest.myflow.baseimpl.FlowApp;
import top.myrest.myflow.baseimpl.MainKt;
import top.myrest.myflow.baseimpl.setting.AppSettingsActionHandler;
import top.myrest.myflow.dev.DevProps;

public class MainTest {

    public static void main(String[] args) {
        MainKt.enableDevEnv();
        DevProps.INSTANCE.setDisableNativeListener(false);
        new FlowApp().configApp();
        AppInfo.INSTANCE.getRuntimeProps().setPinActionWindowOnStartupShow(true);
        Actions.INSTANCE.register("settings", new AppSettingsActionHandler(), AppInfo.BUILTIN_PLUGIN_ID);
        AppKt.App(AppInfo.APP_NAME + "JavaDemo");
    }
}
