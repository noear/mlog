package org.noear.mlog;

/**
 * 日志记录器
 *
 * @author noear
 * @since 1.0
 */
public interface Logger {
    String getName();

    void trace(Object content);
    void trace(String format, Object... args);
    void trace(Metainfo metainfo, Object content);
    void trace(Metainfo metainfo, String format, Object... args);


    void debug(Object content);
    void debug(String format, Object... args);
    void debug(Metainfo metainfo, Object content);
    void debug(Metainfo metainfo, String format, Object... args);


    void info(Object content);
    void info(String format, Object... args);
    void info(Metainfo metainfo, Object content);
    void info(Metainfo metainfo, String format, Object... args);


    void warn(Object content);
    void warn(String format, Object... args);
    void warn(Metainfo metainfo, Object content);
    void warn(Metainfo metainfo, String format, Object... args);


    void error(Object content);
    void error(String format, Object... args);
    void error(Metainfo metainfo, Object content);
    void error(Metainfo metainfo, String format, Object... args);
}
