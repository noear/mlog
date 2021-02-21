package org.noear.mlog;

/**
 * 日志添加器
 *
 * @author noear
 * @since 1.0
 */
public interface Appender {
    String getName();

    Level getLevel();
    void setLevel(Level level);

    void append(String name, Class<?> clz, Level level, Metainfo metainfo, Object content);
}
