# 绑定语言到JavaBean

**将语言资源绑定到JavaBean是很简单的。**

**如果您没有配置JavaBean类，我们将绑定到`LinkedHashMap`。**

**Java代码**

[JavaLanguageBundle.java](../../jar-plugin-guide/java-demo-plugin/src/main/java/runflow/JavaLanguageBundle.java ':include :type=code')

**Kotlin代码**

[KotlinLanguageBundle.kt](../../jar-plugin-guide/java-demo-plugin/src/main/kotlin/runflow/KotlinLanguageBundle.kt ':include :type=code')

**添加语言资源**

`en_us.yml`位于`language`目录：

[en_us.yml](../../jar-plugin-guide/java-demo-plugin/language/en_us.yml ':include :type=code')

`zh_cn.yml`位于`language`目录：

[zh_cn.yml](../../jar-plugin-guide/java-demo-plugin/language/zh_cn.yml ':include :type=code')

**绑定到Bean**

配置到`plugin-spec.yml`，如果您没有配置JavaBean类，我们将绑定到`LinkedHashMap`。

```yaml
language-bundle-name: runflow.KotlinLanguageBundle
```

> 绑定到JavaBean时，字段`languageType`和`INSTANCE`是必须的，如果当前语言类型的绑定ID有默认的值，那么您不需要新建当前语言的资源文件，比如本示例中，我们其实可以不用创建`en_us.yml`文件。