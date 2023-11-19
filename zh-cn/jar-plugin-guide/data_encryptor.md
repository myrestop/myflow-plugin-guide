# Data Encryptor

In this section, we'll write a simple encryptor that implements by base64, just explaining to you how to provide data encryptor to our data synchronization service.

## Writing Encryptor

Create a java file named `JavaEncryptor.java` locate in `src/main/java/runflow`, and writing the following content:

[JavaEncryptor.java](java-demo-plugin/src/main/java/runflow/JavaEncryptor.java ':include :type=code')

## Adding To Specification File

Add the following content to `plugin-spec.yml`:

```yaml
data-encryptors:
  - runflow.JavaEncryptor
```

> How to customize the encryptor settings content? Override the method `getSettingsContent`, and return an instance which implemented `top.myrest.myflow.component.SettingsContent` interface class. To implement this function, you should know [Jetpack Compose](https://developer.android.com/jetpack/compose/documentation) firstly.