# Cycle Listener

If you want to listen your plugin state, you should add a cycle listener to `plugin-spec.yml` file. And we will pass the state to you use the `method` field explained in our [common fields explanation](appendix/json_rpc.md#the-request-parameter-common-fields).

In `BEFORE_PLUGIN_LOAD` and `AFTER_PLUGIN_LOADED` two request methods, we'll pass the plugin location path to you by putting into `body` field, otherwise no other parameters. 

Request example json:

```json
{
    "method": "AFTER_PLUGIN_LOADED",
    "body": {
        "path": "/path/plugin"
    }
}
```

## Writing Cycle Listener

<!-- tabs:start -->

#### **Commandline**

In this example, you should build an executable binary file or write an executable shell script, you can get an argument from commandline.

And you can refer our [**sample code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin/src/nativeMain/kotlin/Main.kt) in [**commandline demo plugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/commandline-demo-plugin).

#### **HTTP**

In this example, you need expose an endpoint `/cycle-listener` in your web server, we'll use post method to request you.

And you can refer our [**sample code**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin/src/main/kotlin/runflow/Main.kt) in [**http demo plugin**](https://github.com/myrestop/myflow-plugin-guide/tree/master/general-plugin-guide/http-demo-plugin).

#### **Python**

In this example we create a listener file named `cycle_listener.py`, and writing the following content:

[cycle_listener.py](python-demo-plugin/cycle_listener.py ':include :type=code')

#### **QLExpress**

In this example we create a listener file named `cycle_listener.qlexpress`, and writing the following content:

[cycle_listener.qlexpress](qlexpress-demo-plugin/cycle_listener.qlexpress ':include :type=code java')

<!-- tabs:end -->

At `BEFORE_PLUGIN_LOAD` method request, you can return the [**plugin state**](appendix/plugin_state.md#plugin-state) to tell us whether to load your plugin, if you return the state is not `RUNNING`, we do not load your plugin.

> In actual development, you can do a lot of other things as needed.

## Adding To Specification File

Add the following content to `plugin-spec.yml`:

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
