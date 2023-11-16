# Action

In this section, we'll write two action, an action writing in java that returns emojis like [general plugin demo](general-plugin-guide/action.md#action), an action writing in kotlin that can dynamic refresh the content by customizing ui.

## Java Action

Create a java action file named `JavaActionHandler.java` locate in `src/main/java/runflow`, writing the following content:

[JavaActionHandler.java](java-demo-plugin/src/main/java/runflow/JavaActionHandler.java ':include :type=code')

Add the following content to `plugin-spec.yml`:

```yaml
actions:
  - keywords:
      - java
    handler: runflow.JavaActionHandler
```

## Kotlin Action

Create a kotlin action file named `KotlinActionHandler.kt` locate in `src/main/kotlin/runflow`, writing the following content:

[KotlinActionHandler.java](java-demo-plugin/src/main/kotlin/runflow/KotlinActionHandler.kt ':include :type=code')

Add the following content in `plugin-spec.yml`'s `actions` node:

```yaml
  - keywords:
      - kotlin
    handler: runflow.KotlinActionHandler
```

> `ActionRequireArgHandler` is our optimized abstraction class, you can also implement the top interface class `ActionKeywordHandler`.
