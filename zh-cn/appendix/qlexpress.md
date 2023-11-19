# QLExpress

**Default Imported Packages:** you don't need to import these packages again, just use the classes in the imported package directly.

```java
import java.lang;
import java.util;
import java.util.stream;
import java.io;
import cn.hutool.core.codec;
import cn.hutool.core.collection;
import cn.hutool.core.date;
import cn.hutool.core.io;
import cn.hutool.core.lang;
import cn.hutool.core.swing;
import cn.hutool.core.util;
import cn.hutool.http;
```

**Builtin Bind Methods**

| method                | return type    | explanation                                 | example                                                  |
|-----------------------|----------------|---------------------------------------------|----------------------------------------------------------|
| listof(Object...)     | List\<Object\> | create a list                               | list=listof(1,2,3,"a");                                  |
| nullto(Object,Object) | Object         | if first value is null, return second value | a_null_value=null;value=nullto(a_null_value,"not_null"); |
| List.avg()            | Double         | list extension method                       | avg=listof(1,2,3,4,5).avg();                             |
| String.repeat(Int)    | String         | string extension method                     | value="a".repeat(9);                                     |

> [**Learn Hutool**](https://hutool.cn)

> [**Learn QLExpress**](https://github.com/alibaba/QLExpress)
