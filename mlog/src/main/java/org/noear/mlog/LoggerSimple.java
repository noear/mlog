package org.noear.mlog;

import org.noear.mlog.utils.LogFormatter;

/**
 * 日志器简化版
 *
 * @author noear
 * @since 1.0
 */
public class LoggerSimple implements Logger {
    protected String name;
    protected Class<?> clz;
    protected Appender appender;

    public LoggerSimple(String name) {
        this.name = name;
        this.appender = LoggerFactory.getFactory().getAppender();
    }

    public LoggerSimple(Class<?> clz) {
        this.name = clz.getName();
        this.clz = clz;
        this.appender = LoggerFactory.getFactory().getAppender();
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void trace(Object content) {
        traceDo(null, content, null, null);
    }

    @Override
    public void trace(String format, Object... args) {
        traceDo(null, null, format, args);
    }

    @Override
    public void trace(Metainfo metainfo, Object content) {
        traceDo(metainfo, content, null, null);
    }

    @Override
    public void trace(Metainfo metainfo, String format, Object... args) {
        traceDo(metainfo, null, format, args);
    }

    private void traceDo(Metainfo metainfo, Object content, String format, Object[] args) {
        this.writeDo(Level.TRACE, metainfo, content, format, args);
    }


    @Override
    public void debug(Object content) {
        debugDo(null, content, null, null);
    }

    @Override
    public void debug(String format, Object... args) {
        debugDo(null, null, format, args);
    }

    @Override
    public void debug(Metainfo metainfo, Object content) {
        debugDo(metainfo, content, null, null);
    }

    @Override
    public void debug(Metainfo metainfo, String format, Object... args) {
        debugDo(metainfo, null, format, args);
    }

    private void debugDo(Metainfo metainfo, Object content, String format, Object[] args) {
        this.writeDo(Level.DEBUG, metainfo, content, format, args);
    }


    @Override
    public void info(Object content) {
        infoDo(null, content, null, null);
    }

    @Override
    public void info(String format, Object... args) {
        infoDo(null, null, format, args);
    }

    @Override
    public void info(Metainfo metainfo, Object content) {
        infoDo(metainfo, content, null, null);
    }

    @Override
    public void info(Metainfo metainfo, String format, Object... args) {
        infoDo(metainfo, null, format, args);
    }

    private void infoDo(Metainfo metainfo, Object content, String format, Object[] args) {
        this.writeDo(Level.INFO, metainfo, content, format, args);
    }


    @Override
    public void warn(Object content) {
        warnDo(null, content, null, null);
    }

    @Override
    public void warn(String format, Object... args) {
        warnDo(null, null, format, args);
    }

    @Override
    public void warn(Metainfo metainfo, Object content) {
        warnDo(metainfo, content, null, null);
    }

    @Override
    public void warn(Metainfo metainfo, String format, Object... args) {
        warnDo(metainfo, null, format, args);
    }

    private void warnDo(Metainfo metainfo, Object content, String format, Object[] args) {
        this.writeDo(Level.WARN, metainfo, content, format, args);
    }


    @Override
    public void error(Object content) {
        errorDo(null, content, null, null);
    }

    @Override
    public void error(String format, Object... args) {
        errorDo(null, null, format, args);
    }

    @Override
    public void error(Metainfo metainfo, Object content) {
        errorDo(metainfo, content, null, null);
    }

    @Override
    public void error(Metainfo metainfo, String format, Object... args) {
        errorDo(metainfo, null, format, args);
    }

    private void errorDo(Metainfo metainfo, Object content, String format, Object[] args) {
        this.writeDo(Level.ERROR, metainfo, content, format, args);
    }


    protected void writeDo(Level level, Metainfo metainfo, Object content, String format, Object[] args) {
        if (format != null) {
            if (args != null && args.length > 0) {
                content = LogFormatter.arrayFormat(format, args).getMessage();
            } else {
                content = format;
            }
        }

        appender.append(getName(), clz,level, metainfo, content);
    }
}
