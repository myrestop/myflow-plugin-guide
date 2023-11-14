# General Plugin Guide

Start from this tutorial, you'll learn how to write a plugin in practice. In this chapter, we will discuss how to write a general plugin with action, placeholder updater and theme provider.

And we will use `commandline`, `http`, `python` and `qlexress` to implement these functions, you can read the parts which you're interesting, get ready, let's start.

## Creating Project Directory And Plugin Specification File

First step, we need to create a project directory and plugin specification file `plugin-spec.yml`.

<!-- tabs:start -->

#### **Commandline**

In this plugin, we create a project directory named `commandline-demo-plugin`, and write the following content to `plugin-spec.yml` file.

```yaml
id: runflow.commandline
name: Commandline Plugin
entry: ./{os}/commandline-demo-plugin
customize-loader: commandline
version: 1.0.0
compatible-version:
  since-build: 0
  until-build: 2147483647
```

**In this implementation, we will pass a parameter to you via commandline which is a base64 encoded json string, so when you get the argument, first you should decode it to json string by base64, then use a json library you liked to parse it.**

[**The Example Full Code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin).

#### **HTTP**

In this plugin, we create a project directory named `http-demo-plugin`, and write the following content to `plugin-spec.yml` file.

```yaml
id: runflow.http
name: HTTP Plugin
entry: http://127.0.0.1:8080
customize-loader: http
version: 1.0.0
compatible-version:
  since-build: 0
  until-build: 2147483647
```

**In this implementation, we will use http post method to request you with a json body, and we require your http interface to respond within 500 milliseconds.** 

[**The Example Full Code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin).

#### **Python**

In this plugin, we create a project directory named `python-demo-plugin`, and write the following content to `plugin-spec.yml` file.

```yaml
id: runflow.python
name: Python Plugin
customize-loader: python
version: 1.0.0
compatible-version:
  since-build: 0
  until-build: 2147483647
```

**In python implementation, it is essentially same as `commandline`, we will pass a parameter to you via commandline which is a base64 encoded json string.**

[**The Example Full Code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/python-demo-plugin).

#### **QLExpress**

In this plugin, we create a project directory named `qlexpress-demo-plugin`, and write the following content to `plugin-spec.yml` file.

```yaml
id: runflow.qlexpress
name: QLExpress Plugin
customize-loader: qlexpress
version: 1.0.0
compatible-version:
  since-build: 0
  until-build: 2147483647
```

**In this implementation, the request json parameter we will put them into the context directly, you can use them as variables.** [Learn QLExpress.](https://github.com/alibaba/QLExpress)

[**The Example Full Code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/qlexpress-demo-plugin).

<!-- tabs:end -->

> [What do these fields mean?](appendix/plugin_specification.md#plugin-specification)

## The Request Parameter Common Fields

Learn [the request parameter common fields](appendix/json_rpc.md#the-request-parameter-common-fields), you can also read it later.

In `qlexpress` plugin, all of these fields are variables, otherwise as a json string.

## Writing Functions

- [**Cycle Listener**](general-plugin-guide/cycle-listener.md#cycle-listener)
- [**Action**](general-plugin-guide/action.md#action)
- [**Placeholder**](general-plugin-guide/placeholder.md#placeholder)
- [**Theme**](general-plugin-guide/theme.md#theme)
