# 扩展动作回调

在本节中，我们将向您暂时如何扩展一个动作回调。

## 编写扩展

在目录`src/main/java/runflow`下创建一个名为`JavaExtension.java`的文件，并写入以下内容：

[JavaExtension.java](../../jar-plugin-guide/java-demo-plugin/src/main/java/runflow/JavaExtension.java ':include :type=code')

## 添加到配置文件

添加下面内容到`plugin-spec.yml`文件：

```yaml
action-result-callback-extensions:
  - service: runflow.JavaExtension
    name-bundle-id: Demo Extension
```

> 了解[**ActionResultCallback**](appendix/action_result_callback.md#字段解释)。

> 要验证这个扩展，您需要跟随我们的[**动作教程**](jar-plugin-guide/action.md#java-action)用Java或Kotlin编写一个动作。
