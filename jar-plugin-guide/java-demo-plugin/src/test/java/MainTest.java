import top.myrest.myflow.AppInfo;
import top.myrest.myflow.baseimpl.AppKt;
import top.myrest.myflow.baseimpl.FlowApp;
import top.myrest.myflow.baseimpl.MainKt;
import top.myrest.myflow.dev.DevProps;

public class MainTest {

    public static void main(String[] args) {
        MainKt.enableDevEnv();
        DevProps.INSTANCE.setDisableNativeListener(false);
        new FlowApp().configApp();
        AppKt.App(AppInfo.APP_NAME + "JavaDemo");
    }
}
