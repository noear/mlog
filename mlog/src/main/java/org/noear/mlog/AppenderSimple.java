package org.noear.mlog;

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

        buf.append(new Date().toInstant().toString()).append(" ")
                .append("[").append(level.name()).append("]").append(" ");

        if (metainfo != null) {
            buf.append(metainfo.toString()).append(" ");
        }

        if (clz != null) {
            buf.append(clz.getTypeName()).append("#").append(getName()).append(":: ");
        } else {
            buf.append(name).append("#").append(getName()).append(":: ");
        }

        buf.append(content);

        if (level == Level.ERROR) {
            System.err.println(buf.toString());
        } else {
            System.out.println(buf.toString());
        }
    }
}
