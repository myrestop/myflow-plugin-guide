# Localized Matching

Localized matching can help us get more user-friendly search results when looking for keywords, you can implement our `top.myrest.myflow.language.LocalizationMatcher` interface class, like this:

[JavaLocalizationMatcher.java](java-demo-plugin/src/main/java/runflow/JavaLocalizationMatcher.java ':include :type')

Then, config to `plugin-spec.yml`:

```yaml
localization-matchers:
  - service: runflow.JavaLocalizationMatcher
    name-bundle-id: Demo Translator
```
