# 主题(Theme)

在本节中，我们将实现一个简单的随机主题。

## 编写主题

在`src/main/kotlin/runflow`目录下创建一个名为`KotlinTheme.kt`的文件，并写入以下内容：

[KotlinTheme.kt](../../jar-plugin-guide/java-demo-plugin/src/main/kotlin/runflow/KotlinTheme.kt ':include :type=code')

## 添加到配置文件

添加以下内容到文件`plugin-spec.yml`：

```yaml
themes:
  - service: runflow.KotlinTheme
    name-bundle-id: Demo Theme
```

> 了解[**主题解释**](appendix/theme.md#theme)。
