# 翻译

要实现语言翻译，您可以实现我们的`top.myrest.myflow.language.Translator`接口，代码如下：

[JavaTranslator.java](../../jar-plugin-guide/java-demo-plugin/src/main/java/runflow/JavaTranslator.java ':include :type')

然后，添加到文件`plugin-spec.yml`：

```yaml
translator:
  service: runflow.JavaTranslator
  name-bundle-id: Demo Translator
```

> 了解[语言编码](appendix/language_code.md#语言编码)。
