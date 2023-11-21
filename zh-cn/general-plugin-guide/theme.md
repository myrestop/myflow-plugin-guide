# 主题(Theme)

要提供一个主题，您可以创建一个主题json文件，或响应一个[**主题的json**](appendix/theme.md#theme)。

## 编写主题

<!-- tabs:start -->

#### **Commandline**

在本示例中，我们在项目[**CommandlineDemoPlugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin)下创建一个名为[**theme.json**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin/theme.json)的文件。

并写入以下内容：

[theme.json](../../general-plugin-guide/commandline-demo-plugin/theme.json ':include :type=code')

#### **HTTP**

在本示例中，您需要在您服务器端公开一个`/theme`的接口，我们将会post方法请求这个接口。

您也可以参考位于我们项目[**HttpDemoPlugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin)的[**示例代码**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin/src/main/kotlin/runflow/Main.kt)。

#### **Python**

在本示例中，我们创建一个名为`theme.json`的文件，并写入以下内容：

[theme.json](../../general-plugin-guide/python-demo-plugin/theme.json ':include :type=code')

#### **QLExpress**

在本示例中，我们创建一个名为`theme.json`的文件，并写入以下内容：

[theme.json](../../general-plugin-guide/qlexpress-demo-plugin/theme.json ':include :type=code')

<!-- tabs:end -->

## 添加到配置文件

添加以下内容到文件`plugin-spec.yml`：

<!-- tabs:start -->

#### **Commandline**

```yaml
themes:
  - service: ./theme.json
    name-bundle-id: Demo Theme
```

#### **HTTP**

```yaml
themes:
  - service: "{entry}/theme"
    name-bundle-id: Demo Theme
```

#### **Python**

```yaml
themes:
  - service: ./theme.json
    name-bundle-id: Demo Theme
```

#### **QLExpress**

```yaml
themes:
  - service: ./theme.json
    name-bundle-id: Demo Theme
```

<!-- tabs:end -->

> 了解[**主题字段解释**](appendix/theme.md#theme)。
