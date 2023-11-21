# 监听器(CycleListener)

如果您想监听插件的加载状态，您可以在`plugin-spec.yml`文件中添加一个监听器。我们将通过在[JsonRpc请求公共字段](appendix/json_rpc.md#jsonrpc请求的公共字段)解释中的`method`字段将状态传递给您。

在`BEFORE_PLUGIN_LOAD`和`AFTER_PLUGIN_LOADED`这两个请求方法中, 我们会把插件所在的路径放入`body`字段中传递给您，其他的请求方法没有任何参数。

请求的Json示例：

```json
{
    "method": "AFTER_PLUGIN_LOADED",
    "body": {
        "path": "/path/plugin"
    }
}
```

## 编写监听器

<!-- tabs:start -->

#### **Commandline**

在本示例中，您需要构建一个可执行的二进制文件或编写一个可执行的shell脚本，您可以从命令行获取参数。

您也可以参考位于我们项目[**CommandlineDemoPlugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin)的[**示例代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin/src/nativeMain/kotlin/Main.kt)。

#### **HTTP**

在本示例中，您需要在您服务器端公开一个`/cycle-listener`的接口，我们将会post方法请求这个接口。

您也可以参考位于我们项目[**HttpDemoPlugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin)的[**示例代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin/src/main/kotlin/runflow/Main.kt)。

#### **Python**

在本示例中，我们需要创建一个名为`cycle_listener.py`的监听文件，并写入以下内容：

[cycle_listener.py](../../general-plugin-guide/python-demo-plugin/cycle_listener.py ':include :type=code')

#### **QLExpress**

在本示例中，我们需要创建一个名为`cycle_listener.qlexpress`的监听文件，并写入以下内容：

[cycle_listener.qlexpress](../../general-plugin-guide/qlexpress-demo-plugin/cycle_listener.qlexpress ':include :type=code java')

<!-- tabs:end -->

在`BEFORE_PLUGIN_LOAD`方法请求时，您可以返回一个[**插件状态**](appendix/plugin_state.md#pluginstate)来告诉我们是否加载您的插件，如果返回的状态不是`RUNNING`，我们就不会加载您的插件。

> 在实际开发过程中，您可以根据需要做很多其他的工作。

## 添加到配置文件

添加以下内容到文件`plugin-spec.yml`：

<!-- tabs:start -->

#### **Commandline**

```yaml
cycle-listener: "{entry}"
```

#### **HTTP**

```yaml
cycle-listener: "{entry}/cycle-listener"
```

#### **Python**

```yaml
cycle-listener: ./cycle_listener.py
```

#### **QLExpress**

```yaml
cycle-listener: ./cycle_listener.qlexpress
```

<!-- tabs:end -->
