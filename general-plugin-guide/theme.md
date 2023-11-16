# Theme

To provide a theme, you can create a theme json file, or respond [**theme as json**](appendix/theme.md#theme).

## Writing Theme

<!-- tabs:start -->

#### **Commandline**

In this example, we create a theme file named: [**theme.json**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin/theme.json) in [**commandline demo plugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin).

The content is as follows:

[theme.json](commandline-demo-plugin/theme.json ':include :type=code')

#### **HTTP**

In this example, you need expose an endpoint `/theme` in your web server, we'll use post method to request you.

And you can refer our [**sample code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin/src/main/kotlin/runflow/Main.kt) in [**http demo plugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin).

#### **Python**

In this example we create a theme file named `theme.json`, and writing the following content:

[theme.json](python-demo-plugin/theme.json ':include :type=code')

#### **QLExpress**

In this example we create a theme file named `theme.json`, and writing the following content:

[theme.json](qlexpress-demo-plugin/theme.json ':include :type=code')

<!-- tabs:end -->

## Adding To Specification File

Add the following content to `plugin-spec.yml`:

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

> Read [**theme explanation**](appendix/theme.md#theme).
