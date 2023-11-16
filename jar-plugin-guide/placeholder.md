# Placeholder

In this section, we’ll walk you through writing a random emoji string as the placeholder.

## Writing Placeholder

Create a java placeholder file named `JavaPlaceholder.java` locate in `src/main/java/runflow`, and writing the following content:

[JavaPlaceholder.java](java-demo-plugin/src/main/java/runflow/JavaPlaceholder.java ':include :type=code')

## Adding To Specification File

Add the following content to `plugin-spec.yml`:

```yaml
placeholder-updaters:
  - updater: runflow.JavaPlaceholder
    preview-text: 😁
```