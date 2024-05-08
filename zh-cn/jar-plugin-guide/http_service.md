# Http服务

要启用我们使用[**ktor**](https://ktor.io/docs/welcome.html)提供的http服务来公开接口，请确保您已了解ktor。

### 通过配置的方式启动HTTP服务

创建一个名为`KotlinHttpService.kt`的文件写一个输出hello的接口，代码如下：

[KotlinHttpService.kt](../../jar-plugin-guide/java-demo-plugin/src/main/kotlin/runflow/KotlinHttpService.kt ':include :type=code')

配置`plugin-spec.yml`:

```yaml
http-modules:
  - runflow.KotlinHttpService.helloModule
```

### 通过代码的方式启动HTTP服务

```kotlin
top.myrest.myflow.http.HttpServices.getHttpServerApplication()?.apply {
    routing {
        get("/hello") {
            call.respondText("Hello!")
        }
    }
}
```

### 最后

重启应用，用浏览器打开`http://127.0.0.1:8177/hello`。

> 8177是我们默认的端口，您可以在**通用设置**页面修改端口（不要忘记重启）。
