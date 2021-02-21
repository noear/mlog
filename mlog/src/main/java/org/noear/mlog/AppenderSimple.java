package org.noear.mlog;

import org.noear.mlog.utils.PrintUtil;

import java.util.Date;

/**
 * @author noear 2021/2/21 created
 */
public class AppenderSimple implements Appender {
    protected Level level = LoggerFactory.getLevel();

    @Override
    public String getName() {
        return "simple";
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public void append(String name, Class<?> clz, Level level, Metainfo metainfo, Object content) {
        if (this.level.code > level.code) {
            return;
        }

        appendDo(name, clz, level, metainfo, content);
    }

    protected void appendDo(String name, Class<?> clz, Level level, Metainfo metainfo, Object content) {

        StringBuilder buf = new StringBuilder();
        buf.append(new Date().toInstant()).append(" ");
        buf.append("[").append(level.name()).append("] ");
        buf.append("[*").append(Thread.currentThread().getName()).append("]");

        if (metainfo != null) {
            buf.append(metainfo.toString());
        }

        if (clz != null) {
            buf.append(" ").append(clz.getTypeName()).append("#").append(getName());
        } else {
            buf.append(" ").append(name).append("#").append(getName());
        }

        buf.append(" ::\r\n");

        switch (level) {
            case ERROR: {
                PrintUtil.red(buf.toString());
                break;
            }
            case WARN:{
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

        System.out.println(content);
    }
}