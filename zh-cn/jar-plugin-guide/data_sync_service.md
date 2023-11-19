# Data Sync Service

First we want to say sorry in this section, we haven't a good example to you, but we'll also explain to you how to write a data sync service.

## Writing Synchronization Service

Create a kotlin file named `KotlinSyncService.kt` locate in `src/main/kotlin/runflow`, you can read our explanation in code comments:

[KotlinSyncService.kt](java-demo-plugin/src/main/kotlin/runflow/KotlinSyncService.kt ':include :type=code')

## Adding To Specification File

After you coding finished, add the following content to `plugin-spec.yml`:

```yaml
data-sync-services:
  - service: runflow.KotlinSyncService
    name-bundle-id: Demo Sync Service
```
