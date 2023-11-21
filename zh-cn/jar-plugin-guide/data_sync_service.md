# 数据同步服务

首先，在本节中我们要说句抱歉，我们没有一个很好的示例展示给您，但是我们仍然会向您解释如何编写数据同步服务。

## 编写数据同步服务

在`src/main/kotlin/runflow`目录下创建一个名为`KotlinSyncService.kt`的文件，我们会在代码注释中向您解释如何编写数据同步服务：

[KotlinSyncService.kt](../../jar-plugin-guide/java-demo-plugin/src/main/kotlin/runflow/KotlinSyncService.kt ':include :type=code')

## 添加到配置文件

添加下面内容到文件`plugin-spec.yml`：

```yaml
data-sync-services:
  - service: runflow.KotlinSyncService
    name-bundle-id: Demo Sync Service
```
