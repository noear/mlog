package org.noear.mlog;

import org.noear.mlog.utils.PrintUtil;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author noear 2021/2/21 created
 */
public class AppenderSimple implements Appender {
    protected static Appender instance = new AppenderSimple();

    @Override
    public String getName() {
        return "simple";
    }

    @Override
    public void append(String loggerName, Class<?> clz, Level level, Metainfo metainfo, Object content) {
        if (LoggerFactory.getLevel().code > level.code) {
            return;
        }

        appendDo(loggerName, clz, level, metainfo, content);
    }

    protected void appendDo(String loggerName, Class<?> clz, Level level, Metainfo metainfo, Object content) {

        StringBuilder buf = new StringBuilder();
        buf.append("[").append(level.name()).append("] ");
        buf.append(LocalDateTime.now()).append(" ");
        buf.append("[*").append(Thread.currentThread().getName()).append("]");

        if (metainfo != null) {
            buf.append(metainfo.toString());
        }

        if (clz != null) {
            buf.append(" ").append(clz.getTypeName()).append("#").append(getName());
        } else {
            buf.append(" ").append(loggerName).append("#").append(getName());
        }

        buf.append(":\r\n");

        switch (level) {
            case ERROR: {
                PrintUtil.red(buf.toString());
                break;
            }
            case WARN: {
                PrintUtil.yellow(buf.toString());
                break;
            }
            case DEBUG: {
                PrintUtil.blue(buf.toString());
                break;
            }
            default: {
                PrintUtil.black(buf.toString());
                break;
            }
        }

        appendContentDo(content);
    }

    protected void appendContentDo(Object content) {
        System.out.println(content);
    }
}
