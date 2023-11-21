# 监听器(CycleListener)

您可以在监听器里监听插件的加载状态，或者进行一些初始化工作。

## 创建类

在`src/main/java/runflow`目录下创建一个名为`JavaCycleListener.java`的类，并写入以下内容：

[JavaCycleListener.java](../../jar-plugin-guide/java-demo-plugin/src/main/java/runflow/JavaCycleListener.java ':include :type=code')

> 查看[PluginState](appendix/plugin_state.md#pluginstate)解释。

## 添加到配置文件

添加以下内容到`plugin-spec.yml`文件：

```yaml
cycle-listener: runflow.JavaCycleListener
```
