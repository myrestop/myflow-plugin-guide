# Http Service

To enable http service we use [**ktor**](https://ktor.io/docs/welcome.html), so if you want to expose http endpoint make sure you know ktor.

Writing a hello http service by creating a kotlin file named `KotlinHttpService.kt`, code like the following:

[KotlinHttpService.kt](java-demo-plugin/src/main/kotlin/runflow/KotlinHttpService.kt ':include :type=code')

Config to `plugin-spec.yml`:

```yaml
http-modules:
  - runflow.KotlinHttpService.helloModule
```

Restart app, open url `http://127.0.0.1:8177/hello` set the result.

> 8177 is our default http port, you can customize it at **General Settings** page (don't forget to restart).
