package runflow;

import cn.hutool.core.codec.Base64;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.myrest.myflow.component.SettingsContent;
import top.myrest.myflow.data.DataEncryptor;

public class JavaEncryptor implements DataEncryptor {

    @NotNull
    @Override
    public String getAlgorithmName() {
        return "demo encryptor";
    }

    @NotNull
    @Override
    public String encrypt(@NotNull String content) {
        return Base64.encode(content);
    }

    @NotNull
    @Override
    public String decrypt(@NotNull String content) {
        return Base64.decodeStr(content);
    }

    @Nullable
    @Override
    public SettingsContent getSettingsContent() {
        return null;
    }
}
