` QQ交流群：22200020 `

# mlog

一个强调元信息的日志框架，专为对接分布式日志服务接口而设计。如将日志存入Mongo或ES或RDB，进而通过元信息进行快速查询。

目前已做为Solon cloud的日志服务接口使用...

#### 依赖

```xml
<dependency>
    <groupId>org.noear</groupId>
    <artifactId>mlog</artifactId>
    <version>1.0.2-m1</version>
</dependency>
```

#### 1、示例（自带LoggerSimple）
```java
public class LogDemo {
    static Logger logger = LoggerFactory.get(LogDemo.class);

    public static void main(String[] args) {
        //传统风格
        logger.info("{}:\n{}", "mlog", "hello world!");

        //元信息风格
        logger.info(Metainfo.m().put("order_id", "12").put("user_id", "1"),
                "{}:\n{}", "mlog", "hello world!");

        //标签元信息风格
        logger.info(Tags.tag0("order_" + 12).tag3("user_" + 1),
                "{}:\n{}", "mlog", "hello world!");
    }
}

```

打印效果：
```
[warn] org.noear.mlog.ILoggerFactoryImpl load failed
2021-02-04T04:22:49.752Z [INFO] demo.LogDemo:: mlog:
hello world!
2021-02-04T04:22:49.796Z [INFO] [@order_id:12][@user_id:1] demo.LogDemo:: mlog:
hello world!
2021-02-04T04:22:49.798Z [INFO] [@tag0:order_12][@tag3:user_1] demo.LogDemo:: mlog:
hello world!
```

#### 2、接口
```java
public interface Logger {
    String getName();

    void setName(String name);



    default boolean isTraceEnabled() {
        return LoggerFactory.getLevel().code <= Level.TRACE.code;
    }


    void trace(Object content);
    void trace(String format, Object... args);
    void trace(Metainfo metainfo, Object content);
    void trace(Metainfo metainfo, String format, Object... args);



    default boolean isDebugEnabled() {
        return LoggerFactory.getLevel().code <= Level.DEBUG.code;
    }

    void debug(Object content);
    void debug(String format, Object... args);
    void debug(Metainfo metainfo, Object content);
    void debug(Metainfo metainfo, String format, Object... args);



    default boolean isInfoEnabled() {
        return LoggerFactory.getLevel().code <= Level.INFO.code;
    }

    void info(Object content);
    void info(String format, Object... args);
    void info(Metainfo metainfo, Object content);
    void info(Metainfo metainfo, String format, Object... args);



    default boolean isWarnEnabled() {
        return LoggerFactory.getLevel().code <= Level.WARN.code;
    }

    void warn(Object content);
    void warn(String format, Object... args);
    void warn(Metainfo metainfo, Object content);
    void warn(Metainfo metainfo, String format, Object... args);


    default boolean isErrorEnabled() {
        return LoggerFactory.getLevel().code <= Level.ERROR.code;
    }

    void error(Object content);
    void error(String format, Object... args);
    void error(Metainfo metainfo, Object content);
    void error(Metainfo metainfo, String format, Object... args);
}
```


