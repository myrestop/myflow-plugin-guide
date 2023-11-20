# QLExpress

**默认导入的包：** 您不需要再导入这些包，您可以直接使用这些包下面的类。

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

**内置的方法**

| 方法                    | 返回类型           | 说明                  | 示例                                                       |
|-----------------------|----------------|---------------------|----------------------------------------------------------|
| listof(Object...)     | List\<Object\> | 创建一个list            | list=listof(1,2,3,"a");                                  |
| nullto(Object,Object) | Object         | 如果第一个值为null，那么返回第二个 | a_null_value=null;value=nullto(a_null_value,"not_null"); |
| List.avg()            | Double         | 扩展list的方法           | avg=listof(1,2,3,4,5).avg();                             |
| String.repeat(Int)    | String         | 扩展string的方法         | value="a".repeat(9);                                     |

> [**了解Hutool**](https://hutool.cn)

> [**了解QLExpress**](https://github.com/alibaba/QLExpress)
