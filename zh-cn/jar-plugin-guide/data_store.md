# 存储数据

在本节，您将了解如何存储数据。

## 创建Document

在目录`src/main/java/runflow`下创建一个名为`JavaDoc.java`的自增Document，并写入以下内容：

[JavaDoc.java](../../jar-plugin-guide/java-demo-plugin/src/main/java/runflow/JavaDoc.java ':include :type=code')

> 在父类`top.myrest.myflow.db.AutoIncrementDoc`有两个方法：`setId(Integer)`和`Integer getId()`。如果您想要自定义唯一ID，不需要自增，您可以继承上层的抽象类`top.myrest.myflow.db.BaseDoc<T>`。

## 创建Repository

在`src/main/java/runflow`目录下创建一个名为`JavaRepo.java`的Repository，并写入以下内容：

[JavaRepo.java](../../jar-plugin-guide/java-demo-plugin/src/main/java/runflow/JavaRepo.java ':include :type=code')

> 基类`BaseRepo<ID,T>(Class<T> docClass, Boolean enableDataSync)`涵盖了许多实用的增删改查的方法，并且您可以重写方法`onSyncFrom`来自定义数据同步。
