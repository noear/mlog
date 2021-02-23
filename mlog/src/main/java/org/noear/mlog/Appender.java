package org.noear.mlog;

/**
 * 日志添加器
 *
 * @author noear
 * @since 1.0
 */
public interface Appender {
    String getName();

    void append(String loggerName, Class<?> clz, Level level, Metainfo metainfo, Object content);
}
