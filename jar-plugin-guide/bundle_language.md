# Bundle Language To Bean

**It's easy to bundle your language resources to java bean.**

**If you don't config the bean class, we'll bundle to `LinkedHashMap`.**

**Java Code**

[JavaLanguageBundle.java](java-demo-plugin/src/main/java/runflow/JavaLanguageBundle.java ':include :type=code')

**Kotlin Code**

[KotlinLanguageBundle.kt](java-demo-plugin/src/main/kotlin/runflow/KotlinLanguageBundle.kt ':include :type=code')

**Add Language Resource**

`en_us.yml` locate in `language`:

[en_us.yml](java-demo-plugin/language/en_us.yml ':include :type=code')

`zh_cn.yml` locate in `language`:

[zh_cn.yml](java-demo-plugin/language/zh_cn.yml ':include :type=code')

**Bundle To Bean**

By configuring `plugin-spec.yml`, If you don't config the bean class, we'll bundle to `LinkedHashMap`.

```yaml
language-bundle-name: runflow.KotlinLanguageBundle
```

> To bundle to bean, the field `languageType` and `INSTANCE` is required, and if the bundle id has default value for current language type, you don't write the language resource file, like this example, we don't need `en_us.yml` in fact.