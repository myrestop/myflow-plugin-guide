# Theme

In this section, we’ll implement a simple random theme provider.

## Writing Theme

Create a kotlin file named `KotlinTheme.kt` locate in `src/main/kotlin/runflow`, and writing the following content:

[KotlinTheme.kt](java-demo-plugin/src/main/kotlin/runflow/KotlinTheme.kt ':include :type=code')

## Adding To Specification File

Add the following content to `plugin-spec.yml`:

```yaml
themes:
  - service: runflow.KotlinTheme
    name-bundle-id: Demo Theme
```

> Read [**theme explanation**](appendix/theme.md#theme).
