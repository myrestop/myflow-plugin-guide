# 数据加密器

在本节中，我们将编写一个简单的通过base64编码的加密器，这里只是向您解释如何为我们的数据同步服务提供数据加密的功能。

## 编写加密器

在目录`src/main/java/runflow`下创建一个名为`JavaEncryptor.java`的文件，并写入以下内容：

[JavaEncryptor.java](../../jar-plugin-guide/java-demo-plugin/src/main/java/runflow/JavaEncryptor.java ':include :type=code')

## 添加到配置文件

添加下面的内容到文件`plugin-spec.yml`：

```yaml
data-encryptors:
  - runflow.JavaEncryptor
```

> 如何自定义加密器的设置界面？您可以通过重写`getSettingsContent`方法，并返回一个实现接口`top.myrest.myflow.component.SettingsContent`的实例。要实现这个功能，您首先应该了解[JetpackCompose](https://developer.android.com/jetpack/compose/documentation)。