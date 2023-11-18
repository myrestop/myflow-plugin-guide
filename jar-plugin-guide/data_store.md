# Storing Data

In this section, you'll learn how to store data.

## Creating Document

In this tutorial, we create an auto increment document named `JavaDoc.java` locate in `src/main/java/runflow`, the content like following:

[JavaDoc.java](java-demo-plugin/src/main/java/runflow/JavaDoc.java ':include :type=code')

> In parent class `top.myrest.myflow.db.AutoIncrementDoc`, it has two methods: `setId(Integer)` and `Integer getId()`. And if you want to customize the unique id do not need auto increment, you can extend the top level abstract class `top.myrest.myflow.db.BaseDoc<T>`.

## Creating Repository

Create a repository named `JavaRepo.java` locate in `src/main/java/runflow`, the content like following:

[JavaRepo.java](java-demo-plugin/src/main/java/runflow/JavaRepo.java ':include :type=code')

> The base class `BaseRepo<ID,T>(Class<T> docClass, Boolean enableDataSync)` has many utility methods for crud operation, and you can override method `onSyncFrom` to customize how to synchronize data.
