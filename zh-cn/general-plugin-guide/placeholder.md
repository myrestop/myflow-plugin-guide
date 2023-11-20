# 占位符(Placeholder)

In this section, we'll walk you through writing a random emoji string as the placeholder.

## Writing Placeholder

<!-- tabs:start -->

#### **Commandline**

In this example, you should build an executable binary file or write an executable shell script, you can get an argument from commandline.

And you can refer our [**sample code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin/src/nativeMain/kotlin/Main.kt) in [**commandline demo plugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin).

#### **HTTP**

In this example, you need expose an endpoint `/placeholder` in your web server, we'll use post method to request you.

And you can refer our [**sample code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin/src/main/kotlin/runflow/Main.kt) in [**http demo plugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin).

#### **Python**

In this example we create a placeholder file named `placeholder.py`, and writing the following content:

[placeholder.py](python-demo-plugin/placeholder.py ':include :type=code')

#### **QLExpress**

In this example we create a placeholder file named `placeholder.qlexpress`, and writing the following content:

[placeholder.qlexpress](qlexpress-demo-plugin/placeholder.qlexpress ':include :type=code java')

<!-- tabs:end -->

## Adding To Specification File

Add the following content to `plugin-spec.yml`:

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
