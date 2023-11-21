# Getting Started

In this chapter, you will learn how to write a simple fixed response plugin.

> Make sure you installed [RunFlow](https://myrest.top/myflow).

## Creating Project Directory

You'll start by making a directory where you like, it doesn't matter where the directory locate, or directly choose an exists directory. Here, we will create a directory named: `hello-runflow`.

## Writing Hello Json File

Next, make a new json file to response fixed text, and call it `hello_runflow.json` (the file name is not important, it's just we named it like this here), open the file and write the following content.

[hello_runflow.json](hello-runflow/hello_runflow.json ':include :type=code')

> Learn more about these fields, see [Action Result](appendix/action_result.md#fields-explanation).

## Writing Plugin Specification File

In this step, you should create a plugin specification file that named `plugin-spec.yml` (note: **the configuration file name is fixed, you can't customize it**), then input the following content into it.

[plugin-spec.yml](hello-runflow/plugin-spec.yml ':include :type=code')

> Learn more about the [Plugin Specification Configuration](appendix/plugin_specification.md#plugin-specification).

## Bundling Language Resource (Optional)

If you want to your plugin to support multi languages, you need bundle the language resources.

Create a directory named `language`, then create an english language file called `en_us.yml` in `language` directory. If you also want to support simplified chinese, you can create a file named `zh_cn.yml`, [other language codes see here](appendix/language_code.md#language-code).

The file content as following:

**en_us.yml**

[en_us.yml](hello-runflow/language/en_us.yml ':include :type=code')

**zh_cn.yml**

[zh_cn.yml](hello-runflow/language/zh_cn.yml ':include :type=code')

> **We strongly suggest developer to support english language at least.**

## Describing Plugin (Optional)

By reading description file, let users known what features your plugin provided and how to use these functions conveniently.

Use english to describe the plugin by creating `description_en_us.md` in project directory, and writing the helpful content to users. In this example, we write the following content:

[description_en_us.yml](hello-runflow/description_en_us.md ':include :type=code')

Creating `description_zh_cn.yml` to support simplified chinese description:

[description_zh_cn.yml](hello-runflow/description_zh_cn.md ':include :type=code')

## Running Plugin

When you follow the steps to get here, everything is ready, now we just running it. Open RunFlow action window, go to **Settings** -> **General Settings**, scroll to the bottom, you will see a label `Load External Plugins`, choose our `plugin-spec.yml` to load this plugin.

Then type the `hello` keyword in action input field, you will see the result: `Hello RunFlow`, and if you switch the language to simplified chinese, retyping the keyword `hello` you will see `你好RunFlow` (if you bundled `zn_cn.yml`).

> [The Example Full Code](https://github.com/myrestop/myflow-plugin-guide/tree/master/hello-runflow)

## What's Next

Learn our [**conceptual interpretation**](conceptual_interpretation.md#conceptual-interpretation).
