# 占位符(Placeholder)

在本节中，我们将带您写一个随机字符串的占位符。

## 编写占位符

<!-- tabs:start -->

#### **Commandline**

在本示例中，您需要构建一个可执行的二进制文件或编写一个可执行的shell脚本，您可以从命令行获取参数。

您也可以参考位于我们项目[**CommandlineDemoPlugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin)的[**示例代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin/src/nativeMain/kotlin/Main.kt)。

#### **HTTP**

在本示例中，您需要在您服务器端公开一个`/placeholder`的接口，我们将会post方法请求这个接口。

您也可以参考位于我们项目[**HttpDemoPlugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin)的[**示例代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin/src/main/kotlin/runflow/Main.kt)。

#### **Python**

在本示例中，我们将创建一个名为`placeholder.py`的文件，并写入以下内容：

[placeholder.py](../../general-plugin-guide/python-demo-plugin/placeholder.py ':include :type=code')

#### **QLExpress**

在本示例中，我们将创建一个名为`placeholder.qlexpress`的文件，并写入以下内容：

[placeholder.qlexpress](../../general-plugin-guide/qlexpress-demo-plugin/placeholder.qlexpress ':include :type=code java')

<!-- tabs:end -->

## 添加到配置文件

添加以下内容到文件`plugin-spec.yml`：

<!-- tabs:start -->

#### **Commandline**

```yaml
placeholder-updaters:
  - updater: "{entry}"
    preview-text: a commandline placeholder
```

#### **HTTP**

```yaml
placeholder-updaters:
  - updater: "{entry}/placeholder"
    preview-text: 😁
```

#### **Python**

```yaml
placeholder-updaters:
  - updater: ./placeholder.py
    preview-text: a python placeholder
```

#### **QLExpress**

```yaml
placeholder-updaters:
  - updater: ./placeholder.qlexpress
    preview-text: 😁
```

<!-- tabs:end -->
