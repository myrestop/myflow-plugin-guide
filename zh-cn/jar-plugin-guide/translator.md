# Translator

To implement a language translator, you can implement our `top.myrest.myflow.language.Translator` interface class, like this:

[JavaTranslator.java](java-demo-plugin/src/main/java/runflow/JavaTranslator.java ':include :type')

Then, config to `plugin-spec.yml`:

```yaml
translator:
  service: runflow.JavaTranslator
  name-bundle-id: Demo Translator
```

> See [language codes](appendix/language_code.md#language-code).
