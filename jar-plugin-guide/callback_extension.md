# Action Callback Extension

In this section, we will show you how to extend callback to action result.

## Writing Callback Extension

Create a java file named `JavaExtension.java` locate in `src/main/java/runflow`, and writing the following content:

[JavaExtension.java](java-demo-plugin/src/main/java/runflow/JavaExtension.java ':include :type=code')

## Adding To Specification File

Add the following content to `plugin-spec.yml`:

```yaml
action-result-callback-extensions:
  - service: runflow.JavaExtension
    name-bundle-id: Demo Extension
```

> Read [**explanation of action result callback**](appendix/action_result_callback.md#action-result-callback-fields-explanation).

> To validate the extension, you should follow our [**action tutorial**](jar-plugin-guide/action.md#java-action) to write a java action.
