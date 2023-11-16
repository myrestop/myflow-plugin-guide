# Cycle Listener

You can listen plugin loading state or do some initialization in cycle listener.

## Creating Class

Create a java class named `JavaCycleListener.java` locate in `src/main/java/runflow`, writing codes like follows:

[JavaCycleListener.java](java-demo-plugin/src/main/java/runflow/JavaCycleListener.java ':include :type=code')

## Adding To Specification File

Add the following content to `plugin-spec.yml`:

```yaml
cycle-listener: runflow.JavaCycleListener
```
