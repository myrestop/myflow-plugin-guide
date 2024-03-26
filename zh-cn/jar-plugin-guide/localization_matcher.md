# 本地化匹配

本地化匹配可以帮助我们在查找关键字时得到更人性化的搜索结果，您可以实现我们的`top.myrest.myflow.language.LocalizationMatcher`接口，代码如下：

[JavaLocalizationMatcher.java](../../jar-plugin-guide/java-demo-plugin/src/main/java/runflow/JavaLocalizationMatcher.java ':include :type')

然后，添加到文件`plugin-spec.yml`：

```yaml
localization-matchers:
  - service: runflow.JavaLocalizationMatcher
    name-bundle-id: Demo Localization Matcher
```
