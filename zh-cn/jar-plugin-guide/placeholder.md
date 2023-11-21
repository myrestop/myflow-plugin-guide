# 占位符(Placeholder)

在本节中，我们将带你编写一个随机表情符的占位符。

## 编写占位符

在`src/main/java/runflow`目录下创建一个名为`JavaPlaceholder.java`的文件，并写入以下内容：

[JavaPlaceholder.java](../../jar-plugin-guide/java-demo-plugin/src/main/java/runflow/JavaPlaceholder.java ':include :type=code')

## 添加到配置文件

添加以下内容到文件`plugin-spec.yml`：

```yaml
placeholder-updaters:
  - updater: runflow.JavaPlaceholder
    preview-text: 😁
```